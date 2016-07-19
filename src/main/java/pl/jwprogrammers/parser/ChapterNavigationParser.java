package pl.jwprogrammers.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Map;
import java.util.stream.Collectors;

public class ChapterNavigationParser {
    private final String content;
    private String book;

    public ChapterNavigationParser(String content) {
        this.content = content;
    }

    public Map<Integer, String> parse() {
        Document document = Jsoup.parse(content);
        book = document
                .getElementsByTag("a")
                .stream()
                .filter(element -> element.attr("href").equals("biblebooknav.xhtml"))
                .map(Element::text)
                .findFirst()
                .orElse("");
        return document.getElementsByClass("w_navigation").stream()
                .filter(element -> element.tag().getName().equals("td"))
                .map(element -> element.getElementsByTag("a"))
                .flatMap(Elements::stream)
                .collect(Collectors.toMap(element -> Integer.parseInt(element.text()), element -> element.attr("href")));
    }

    public String getBook() {
        return book;
    }
}
