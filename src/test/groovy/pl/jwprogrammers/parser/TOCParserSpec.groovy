package pl.jwprogrammers.parser

import pl.jwprogrammers.exceptions.InvalidFormatException
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors

class TOCParserSpec extends Specification {

    @Shared
    Map<String, Book> chapters = new TOCParser(Files.readAllLines(Paths.get("src/test/resources/toc.xhtml")).stream().collect(Collectors.joining("\r\n"))).parse()

    def "toc in incorrect format"() {

        given:
        TOCParser instance = new TOCParser("a")

        when:
        instance.parse()

        then:
        thrown InvalidFormatException
    }

    @Unroll
    def "#b is defined in #a file"() {
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
        "biblechapternav1.xhtml"  | Book.GENESIS
        "biblechapternav2.xhtml"  | Book.EXODUS
        "biblechapternav3.xhtml"  | Book.LEVITICUS
        "biblechapternav4.xhtml"  | Book.NUMBERS
        "biblechapternav5.xhtml"  | Book.DEUTERONOMY
        "biblechapternav6.xhtml"  | Book.JOSHUA
        "biblechapternav7.xhtml"  | Book.JUDGES
        "biblechapternav8.xhtml"  | Book.RUTH
        "biblechapternav9.xhtml"  | Book.FIRST_SAMUEL
        "biblechapternav10.xhtml" | Book.SECOND_SAMUEL
        "biblechapternav11.xhtml" | Book.FIRST_KINGS
        "biblechapternav12.xhtml" | Book.SECOND_KINGS
        "biblechapternav13.xhtml" | Book.FIRST_CHRONICLES
        "biblechapternav14.xhtml" | Book.SECOND_CHRONICLES
        "biblechapternav15.xhtml" | Book.EZRA
        "biblechapternav16.xhtml" | Book.NEHEMIAH
        "biblechapternav17.xhtml" | Book.ESTHER
        "biblechapternav18.xhtml" | Book.JOB
        "biblechapternav19.xhtml" | Book.PSALMS
        "biblechapternav20.xhtml" | Book.PROVERBS
        "biblechapternav21.xhtml" | Book.ECCLESIASTES
        "biblechapternav22.xhtml" | Book.SONG_OF_SOLOMON
        "biblechapternav23.xhtml" | Book.ISAIAH
        "biblechapternav24.xhtml" | Book.JEREMIAH
        "biblechapternav25.xhtml" | Book.LAMENTATIONS
        "biblechapternav26.xhtml" | Book.EZEKIEL
        "biblechapternav27.xhtml" | Book.DANIEL
        "biblechapternav28.xhtml" | Book.HOSEA
        "biblechapternav29.xhtml" | Book.JOEL
        "biblechapternav30.xhtml" | Book.AMOS
        "1001060432.xhtml"        | Book.OBADIAH
        "biblechapternav32.xhtml" | Book.JONAH
        "biblechapternav33.xhtml" | Book.MICAH
        "biblechapternav34.xhtml" | Book.NAHUM
        "biblechapternav35.xhtml" | Book.HABAKKUK
        "biblechapternav36.xhtml" | Book.ZEPHANIAH
        "biblechapternav37.xhtml" | Book.HAGGAI
        "biblechapternav38.xhtml" | Book.ZECHARIAH
        "biblechapternav39.xhtml" | Book.MALACHI
        "biblechapternav40.xhtml" | Book.MATTHEW
        "biblechapternav41.xhtml" | Book.MARK
        "biblechapternav42.xhtml" | Book.LUKE
        "biblechapternav43.xhtml" | Book.JOHN
        "biblechapternav44.xhtml" | Book.ACTS
        "biblechapternav45.xhtml" | Book.ROMANS
        "biblechapternav46.xhtml" | Book.FIRST_CORINTHIANS
        "biblechapternav47.xhtml" | Book.SECOND_CORINTHIANS
        "biblechapternav48.xhtml" | Book.GALATIANS
        "biblechapternav49.xhtml" | Book.EPHESIANS
        "biblechapternav50.xhtml" | Book.PHILIPPIANS
        "biblechapternav51.xhtml" | Book.COLOSSIANS
        "biblechapternav52.xhtml" | Book.FIRST_THESSALONIANS
        "biblechapternav53.xhtml" | Book.SECOND_THESSALONIANS
        "biblechapternav54.xhtml" | Book.FIRST_TIMOTHY
        "biblechapternav55.xhtml" | Book.SECOND_TIMOTHY
        "biblechapternav56.xhtml" | Book.TITUS
        "1001060458.xhtml"        | Book.PHILEMON
        "biblechapternav58.xhtml" | Book.HEBREWS
        "biblechapternav59.xhtml" | Book.JAMES
        "biblechapternav60.xhtml" | Book.FIRST_PETER
        "biblechapternav61.xhtml" | Book.SECOND_PETER
        "biblechapternav62.xhtml" | Book.FIRST_JOHN
        "1001060464.xhtml"        | Book.SECOND_JOHN
        "1001060465.xhtml"        | Book.THIRD_JOHN
        "1001060466.xhtml"        | Book.JUDE
        "biblechapternav66.xhtml" | Book.REVELATION
    }
}
