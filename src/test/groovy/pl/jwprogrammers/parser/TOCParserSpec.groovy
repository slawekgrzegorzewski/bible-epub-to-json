package pl.jwprogrammers.parser

import pl.jwprogrammers.bible.Book
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors

class TOCParserSpec extends Specification {

    @Shared
    Map<Book, String> chapters = new TOCParser(Files.readAllLines(Paths.get("src/test/resources/toc.xhtml")).stream().collect(Collectors.joining("\r\n"))).parse()

    @Unroll
    def "#a is defined in #b file"() {
        given:
        when:
        chapters

        then:
        noExceptionThrown()
        chapters.size() == 66

        expect:
        chapters.get(a) == b

        where:
        a                         | b
        Book.GENESIS              | "biblechapternav1.xhtml"
        Book.EXODUS               | "biblechapternav2.xhtml"
        Book.LEVITICUS            | "biblechapternav3.xhtml"
        Book.NUMBERS              | "biblechapternav4.xhtml"
        Book.DEUTERONOMY          | "biblechapternav5.xhtml"
        Book.JOSHUA               | "biblechapternav6.xhtml"
        Book.JUDGES               | "biblechapternav7.xhtml"
        Book.RUTH                 | "biblechapternav8.xhtml"
        Book.FIRST_SAMUEL         | "biblechapternav9.xhtml"
        Book.SECOND_SAMUEL        | "biblechapternav10.xhtml"
        Book.FIRST_KINGS          | "biblechapternav11.xhtml"
        Book.SECOND_KINGS         | "biblechapternav12.xhtml"
        Book.FIRST_CHRONICLES     | "biblechapternav13.xhtml"
        Book.SECOND_CHRONICLES    | "biblechapternav14.xhtml"
        Book.EZRA                 | "biblechapternav15.xhtml"
        Book.NEHEMIAH             | "biblechapternav16.xhtml"
        Book.ESTHER               | "biblechapternav17.xhtml"
        Book.JOB                  | "biblechapternav18.xhtml"
        Book.PSALMS               | "biblechapternav19.xhtml"
        Book.PROVERBS             | "biblechapternav20.xhtml"
        Book.ECCLESIASTES         | "biblechapternav21.xhtml"
        Book.SONG_OF_SOLOMON      | "biblechapternav22.xhtml"
        Book.ISAIAH               | "biblechapternav23.xhtml"
        Book.JEREMIAH             | "biblechapternav24.xhtml"
        Book.LAMENTATIONS         | "biblechapternav25.xhtml"
        Book.EZEKIEL              | "biblechapternav26.xhtml"
        Book.DANIEL               | "biblechapternav27.xhtml"
        Book.HOSEA                | "biblechapternav28.xhtml"
        Book.JOEL                 | "biblechapternav29.xhtml"
        Book.AMOS                 | "biblechapternav30.xhtml"
        Book.OBADIAH              | "1001060432.xhtml"
        Book.JONAH                | "biblechapternav32.xhtml"
        Book.MICAH                | "biblechapternav33.xhtml"
        Book.NAHUM                | "biblechapternav34.xhtml"
        Book.HABAKKUK             | "biblechapternav35.xhtml"
        Book.ZEPHANIAH            | "biblechapternav36.xhtml"
        Book.HAGGAI               | "biblechapternav37.xhtml"
        Book.ZECHARIAH            | "biblechapternav38.xhtml"
        Book.MALACHI              | "biblechapternav39.xhtml"
        Book.MATTHEW              | "biblechapternav40.xhtml"
        Book.MARK                 | "biblechapternav41.xhtml"
        Book.LUKE                 | "biblechapternav42.xhtml"
        Book.JOHN                 | "biblechapternav43.xhtml"
        Book.ACTS                 | "biblechapternav44.xhtml"
        Book.ROMANS               | "biblechapternav45.xhtml"
        Book.FIRST_CORINTHIANS    | "biblechapternav46.xhtml"
        Book.SECOND_CORINTHIANS   | "biblechapternav47.xhtml"
        Book.GALATIANS            | "biblechapternav48.xhtml"
        Book.EPHESIANS            | "biblechapternav49.xhtml"
        Book.PHILIPPIANS          | "biblechapternav50.xhtml"
        Book.COLOSSIANS           | "biblechapternav51.xhtml"
        Book.FIRST_THESSALONIANS  | "biblechapternav52.xhtml"
        Book.SECOND_THESSALONIANS | "biblechapternav53.xhtml"
        Book.FIRST_TIMOTHY        | "biblechapternav54.xhtml"
        Book.SECOND_TIMOTHY       | "biblechapternav55.xhtml"
        Book.TITUS                | "biblechapternav56.xhtml"
        Book.PHILEMON             | "1001060458.xhtml"
        Book.HEBREWS              | "biblechapternav58.xhtml"
        Book.JAMES                | "biblechapternav59.xhtml"
        Book.FIRST_PETER          | "biblechapternav60.xhtml"
        Book.SECOND_PETER         | "biblechapternav61.xhtml"
        Book.FIRST_JOHN           | "biblechapternav62.xhtml"
        Book.SECOND_JOHN          | "1001060464.xhtml"
        Book.THIRD_JOHN           | "1001060465.xhtml"
        Book.JUDE                 | "1001060466.xhtml"
        Book.REVELATION           | "biblechapternav66.xhtml"
    }
}
