package pl.jwprogrammers;

import com.google.common.collect.Lists;
import org.json.simple.JSONObject;
import pl.jwprogrammers.exceptions.InvalidFormatException;
import pl.jwprogrammers.exceptions.NonExistingEpubFileException;
import pl.jwprogrammers.parser.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws NonExistingEpubFileException, InvalidFormatException, IOException {
        JSONObject bibleObject = new JSONObject();
//        JSONArray booksList = new JSONArray();
//        bibleObject.put("verses", booksList);

        EpubReader reader = new EpubReader(args[0]);
        Map<String, Book> toc = new TOCParser(reader.getEntryContent("OEBPS/toc.xhtml")).parse();
        List<ChapterNavigationParser> navigations = Lists.newArrayList();
        toc.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getValue().getOrder()))
                .forEach(tocEntry -> {
                    Book book = tocEntry.getValue();
                    System.out.println("Księga: " + book);
                    Map<Integer, String> chapters = null;
                    try {
                        chapters = new ChapterNavigationParser(reader.getEntryContent("OEBPS/" + tocEntry.getKey())).parse();
                    } catch (NonExistingEpubFileException e) {

                    }
                    chapters.entrySet().stream()
                            .sorted(Comparator.comparing(chapterEntry -> chapterEntry.getKey()))
                            .forEach(chapterEntry -> {
                                Integer chapter = chapterEntry.getKey();
                                System.out.println("Rozdział: " + chapter);
                                Map<Integer, String> verses = null;
                                try {
                                    verses = new ChapterContentParser(reader.getEntryContent("OEBPS/" + chapterEntry.getValue())).parse();
                                } catch (NonExistingEpubFileException e) {

                                }
                                verses.entrySet().stream()
                                        .sorted(Comparator.comparing(verseEntry -> verseEntry.getKey()))
                                        .forEach(verseEntry -> {
                                            Integer verseNumber = verseEntry.getKey();
                                            String verseContent = verseEntry.getValue();
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
                                        });
                            });
                });
        try (FileWriter file = new FileWriter("c:\\test.json");) {
            file.write(bibleObject.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
