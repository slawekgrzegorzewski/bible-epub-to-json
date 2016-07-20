package pl.jwprogrammers.parser;

import com.google.common.collect.Maps;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import pl.jwprogrammers.bible.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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
        for (int i = 2; i < 68; i++) {
            ofNullable(document.getElementById("chapter" + i))
                    .map(e -> e.getElementsByTag("a"))
                    .filter(Objects::nonNull)
                    .filter(e -> !e.isEmpty())
                    .map(e -> e.get(0))
                    .filter(Objects::nonNull)
                    .ifPresent(e -> result.put(mapToBook(e.text()).orElse(null), MAIN_FOLDER + e.attr("href")));
        }
        return result;
    }

    private Optional<Book> mapToBook(String bookName) {
        return Stream.of(Book.values()).filter(b -> b.getPolishName().equals(bookName) || b.getEnglishName().equals(bookName)).findAny();
    }
}
