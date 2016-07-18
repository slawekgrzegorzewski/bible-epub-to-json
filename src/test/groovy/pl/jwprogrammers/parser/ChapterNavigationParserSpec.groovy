package pl.jwprogrammers.parser

import spock.lang.Shared
import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors

public class ChapterNavigationParserSpec extends Specification {

    @Shared
    ChapterNavigationParser parser = new ChapterNavigationParser(
            Files.readAllLines(Paths.get("src/test/resources/biblechapternav13.xhtml"))
                    .stream().collect(Collectors.joining("\r\n")))
    @Shared
    Map<String, String> chaptersLocations = parser.parse()

    def "a"() {
        given:
        when:
        chaptersLocations
        then:
        parser.getBook() == "1 Kronik"
        expect:
        chaptersLocations.get(a).equals(b)
        where:
        a    | b
        "1"  | "1001060414.xhtml"
        "2"  | "1001060414-split2.xhtml"
        "3"  | "1001060414-split3.xhtml"
        "4"  | "1001060414-split4.xhtml"
        "5"  | "1001060414-split5.xhtml"
        "6"  | "1001060414-split6.xhtml"
        "7"  | "1001060414-split7.xhtml"
        "8"  | "1001060414-split8.xhtml"
        "9"  | "1001060414-split9.xhtml"
        "10" | "1001060414-split10.xhtml"
        "11" | "1001060414-split11.xhtml"
        "12" | "1001060414-split12.xhtml"
        "13" | "1001060414-split13.xhtml"
        "14" | "1001060414-split14.xhtml"
        "15" | "1001060414-split15.xhtml"
        "16" | "1001060414-split16.xhtml"
        "17" | "1001060414-split17.xhtml"
        "18" | "1001060414-split18.xhtml"
        "19" | "1001060414-split19.xhtml"
        "20" | "1001060414-split20.xhtml"
        "21" | "1001060414-split21.xhtml"
        "22" | "1001060414-split22.xhtml"
        "23" | "1001060414-split23.xhtml"
        "24" | "1001060414-split24.xhtml"
        "25" | "1001060414-split25.xhtml"
        "26" | "1001060414-split26.xhtml"
        "27" | "1001060414-split27.xhtml"
        "28" | "1001060414-split28.xhtml"
        "29" | "1001060414-split29.xhtml"
    }

}
