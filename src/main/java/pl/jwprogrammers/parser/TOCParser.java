package pl.jwprogrammers.parser;

import com.google.common.collect.Maps;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import pl.jwprogrammers.bible.Book;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;

public class TOCParser {
    private static final String MAIN_FOLDER = "OEBPS/";
    private final String content;

    public TOCParser(String content) {
        this.content = content;
    }

    public Map<Book, String> parse() {

        HashMap<Book, String> result = Maps.newHashMap();
        Document document = Jsoup.parse(content);
        for (int i = 2; i < 1000; i++) {
            ofNullable(document.getElementById("chapter" + i))
                    .map(e -> e.getElementsByTag("a"))
                    .filter(e -> !e.isEmpty())
                    .map(e -> e.get(0))
                    .map(e -> new AbstractMap.SimpleEntry<>(mapToBook(e.text()).orElse(null), MAIN_FOLDER + e.attr("href")))
                    .filter(entry -> entry.getKey() != null)
                    .ifPresent(entry -> result.put((entry.getKey()), entry.getValue()));
        }
        return result;
    }

    private Optional<Book> mapToBook(String bookName) {
        return Stream.of(Book.values()).filter(b -> b.getPolishName().equals(bookName) || b.getEnglishName().equals(bookName)).findAny();
    }
}
