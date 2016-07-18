    package pl.jwprogrammers.parser

import pl.jwprogrammers.exceptions.NonExistingEpubFileException
import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors

public class ChapterNavigationParserSpec extends Specification {

    def "a"() throws NonExistingEpubFileException {
        given:
        ChapterNavigationParser reader = new ChapterNavigationParser("test/bi12_P.epub");
        when:
        reader.getEntryContent("a");
        then:
        thrown NonExistingEpubFileException
    }

}
