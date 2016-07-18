package pl.jwprogrammers.parser;


import com.google.common.collect.Maps;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

import java.util.Map;

public class ChapterContentParser {

    private final String content;
    private Map<Integer, StringBuilder> verses = Maps.newHashMap();
    private Integer currentVerse = null;

    public ChapterContentParser(String content) {
        this.content = content;
    }


    public Map<Integer, String> parse() {
        Map<Integer, String> result = Maps.newHashMap();
        Document document = Jsoup.parse(content);
        document.getElementsByTag("p").stream()
                .filter(element -> !element.classNames().contains("w_navigation"))
                .forEach(element -> {
                    if (currentVerse != null && verses.get(currentVerse) != null) {
                        verses.get(currentVerse).append("\r\n");
                    }
                    for (Node node : element.childNodes()) {
                        if (node instanceof Element) {
                            Element element1 = (Element) node;
                            if (isNewVerseMarkingNode(element1)) {
                                currentVerse = Integer.parseInt(element1.attr("id").split("verse")[1]);
                                if (verses.get(currentVerse) == null) verses.put(currentVerse, new StringBuilder());
                            }
                        } else if (currentVerse == null) {
                        } else if (node instanceof TextNode) {
                            TextNode textNode = (TextNode) node;
                            verses.get(currentVerse).append(textNode.text().replace(String.valueOf((char) 160), " "));
                        }
                    }
                });
        verses.entrySet().stream().forEach(entry -> {
            result.put(entry.getKey(), entry.getValue().toString().trim());
        });
        return result;
    }

    private boolean isNewVerseMarkingNode(Element element1) {
        return element1.tag().getName().equals("span") && element1.attr("id").contains("chapter") && element1.attr("id").contains("_") && element1.attr("id").contains("verse");
    }
}
