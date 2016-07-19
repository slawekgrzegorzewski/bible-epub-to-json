package pl.jwprogrammers.parser;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChapterContentParser {

    public static final String NON_BREAKING_SPACE = String.valueOf((char) 160);
    private final String content;
    private Map<Integer, List<String>> verses = Maps.newHashMap();
    private Integer currentVerse = null;

    public ChapterContentParser(String content) {
        this.content = content;
    }


    public Map<Integer, String> parse() {
        Jsoup.parse(content)
                .getElementsByTag("p")
                .stream()
                .filter(this::isParagraphWithVerse)
                .forEach(this::readParagraph);
        return verses
                .entrySet()
                .stream()
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue().stream().collect(Collectors.joining(" "))));
    }

    private boolean isParagraphWithVerse(Element element) {
        return !element.classNames().contains("w_navigation");
    }

    private void readParagraph(Element paragraph) {
        paragraph.childNodes().forEach(this::readNode);
    }

    private void readNode(Node node) {
        if (node instanceof Element) {
            checkForNewVerse((Element) node);
        } else if (node instanceof TextNode) {
            readVerseContent((TextNode) node);
        }
    }


    private void checkForNewVerse(Element element1) {
        if (isNewVerseMarkingNode(element1)) {
            currentVerse = Integer.parseInt(element1.attr("id").split("verse")[1]);
            if (verses.get(currentVerse) == null) verses.put(currentVerse, Lists.newArrayList());
        }
    }

    private boolean isNewVerseMarkingNode(Element element1) {
        String tag = element1.tag().getName();
        String id = element1.attr("id");
        return tag.equals("span")
                && id.contains("chapter")
                && id.contains("_")
                && id.contains("verse");
    }

    private void readVerseContent(TextNode node) {
        if (currentVerse == null) return;
        String text = node.text().replace(NON_BREAKING_SPACE, " ").trim();
        if (text != null && !text.isEmpty()) {
            verses.get(currentVerse).add(text);
        }
    }
}
