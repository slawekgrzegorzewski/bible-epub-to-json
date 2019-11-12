package pl.jwprogrammers.parser;

import org.json.simple.JSONObject;
import pl.jwprogrammers.bible.Book;
import pl.jwprogrammers.epub.EpubReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Map;

public class BibleParser {
    private static final String EPUB_TOC_ENTRY_NAME = "OEBPS/toc.xhtml";
    private final JSONObject bibleObject = new JSONObject();
    private final EpubReader reader;

    public BibleParser(Path epubFile) throws IOException {
        reader = new EpubReader(epubFile);
    }

    public void parse() {
        new TOCParser(reader.getEntryContent(EPUB_TOC_ENTRY_NAME))
                .parse()
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(entry -> entry.getKey().getOrder()))
                .forEach(tocEntry -> readBook(tocEntry.getKey(), tocEntry.getValue()));
    }

    private void readBook(Book book, String bookNavigationFile) {
        new ChapterNavigationParser(reader.getEntryContent(bookNavigationFile))
                .parse()
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(chapterEntry -> readChapter(book, chapterEntry.getKey(), chapterEntry.getValue()));
    }

    private void readChapter(Book book, Integer chapter, String chapterContentFile) {
        new ChapterContentParser(reader.getEntryContent(chapterContentFile))
                .parse()
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(verseEntry -> addToJSON(book, chapter, verseEntry.getKey(), verseEntry.getValue()));
    }

    private void addToJSON(Book book, Integer chapter, Integer verseNumber, String verseContent) {
        JSONObject bookObject = (JSONObject) bibleObject.get(book);
        if (bookObject == null) {
            bookObject = new JSONObject();
            bibleObject.put(book, bookObject);
        }
        JSONObject chapterObject = (JSONObject) bookObject.get(chapter);
        if (chapterObject == null) {
            chapterObject = new JSONObject();
            bookObject.put(chapter, chapterObject);
        }
        chapterObject.put(verseNumber, verseContent);
    }

    public void save(Path outputFile) {
        try {
            Files.writeString(outputFile, bibleObject.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
