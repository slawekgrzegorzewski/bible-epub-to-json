package pl.jwprogrammers.parser;

import com.google.common.collect.Maps;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Map;

public class ChapterNavigationParser {
    private final String content;
    private String book;

    ChapterNavigationParser(String content) {
        this.content = content;
    }

    public Map<String, String> parse() {
        Map<String, String> result = Maps.newHashMap();
        Document document = Jsoup.parse(content);
        book = document.getElementsByTag("a").stream()
                .filter(element -> element.attr("href").equals("biblebooknav.xhtml"))
                .map(Element::text)
                .findFirst().orElse("");
        document.getElementsByClass("w_navigation").stream()
                .filter(element -> element.tag().getName().equals("td"))
                .map(element -> element.getElementsByTag("a"))
                .flatMap(Elements::stream)
                .forEach(element -> result.put(element.text(), element.attr("href")));
        return result;
    }

    public String getBook() {
        return book;
    }
}
