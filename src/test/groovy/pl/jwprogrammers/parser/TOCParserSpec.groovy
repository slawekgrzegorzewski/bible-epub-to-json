package pl.jwprogrammers.parser

import spock.lang.Specification
import spock.lang.Unroll;

@Unroll
class TOCParserSpec extends Specification {

    EpubReader epubReader = Mock(EpubReader)

    def setup() {
        epubReader.getEntryContent(_) >> "a";
    }

    def "something"() {
        setup()

        expect:
        TOCParser instance = new TOCParser(epubReader);
    }
}
