package pl.jwprogrammers.parser;

import com.google.common.collect.Maps;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import pl.jwprogrammers.exceptions.InvalidFormatException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;

public class TOCParser {
    private final String toc;

    public TOCParser(String toc) {
        this.toc = toc;
    }

    public Map<String, Book> parse() throws InvalidFormatException {
        HashMap<String, Book> result = Maps.newHashMap();
        Document document = Jsoup.parse(toc);
        for (int i = 2; i < 68; i++) {
            ofNullable(document.getElementById("chapter" + i))
                    .map(e -> e.getElementsByTag("a"))
                    .filter(Objects::nonNull)
                    .filter(e -> !e.isEmpty())
                    .map(e -> e.get(0))
                    .filter(Objects::nonNull)
                    .ifPresent(e -> result.put(e.attr("href"), getBook(e.text())));
        }
        if (result.size() != 66) throw new InvalidFormatException("TOC");
        return result;
    }

    private Book getBook(String bookName) {
        return Stream.of(Book.values()).filter(b -> b.getPolishName().equals(bookName)).findAny().orElse(null);
    }
}
