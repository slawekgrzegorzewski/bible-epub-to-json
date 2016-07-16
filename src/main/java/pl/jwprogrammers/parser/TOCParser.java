package pl.jwprogrammers.parser;

import com.google.common.collect.Maps;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import pl.jwprogrammers.exceptions.InvalidTOCFormatException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.util.Optional.ofNullable;

public class TOCParser {
    private final String toc;

    public TOCParser(String toc) {
        this.toc = toc;
    }

    public Map<String, String> parse() throws InvalidTOCFormatException {
        HashMap<String, String> result = Maps.newHashMap();
        Document document = Jsoup.parse(toc);
        for (int i = 2; i < 68; i++) {
            ofNullable(document.getElementById("chapter" + i))
                    .map(e -> e.getElementsByTag("a"))
                    .filter(Objects::nonNull)
                    .filter(e -> !e.isEmpty())
                    .map(e -> e.get(0))
                    .filter(Objects::nonNull)
                    .ifPresent(e -> result.put(e.attr("href"), e.text()));
        }
        if (result.size() != 66) throw new InvalidTOCFormatException();
        return result;
    }
}
