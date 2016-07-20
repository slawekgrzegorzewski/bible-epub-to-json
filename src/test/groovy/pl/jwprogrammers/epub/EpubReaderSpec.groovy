package pl.jwprogrammers.epub

import pl.jwprogrammers.epub.EpubReader
import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors

public class EpubReaderSpec extends Specification {

    def "not existing file"() throws IOException {
        given:
        when:
        new EpubReader(Paths.get("test/bi12_P.epub"));
        then:
        thrown IOException
    }

    def "existing file"() {
        given:
        EpubReader reader = new EpubReader(Paths.get("src/test/resources/bi12_P.epub"));
        when:
        reader.getEntryContent("a");
        then:
        noExceptionThrown()
    }

    def "read entry"() {
        given:
        EpubReader reader = new EpubReader(Paths.get("src/test/resources/bi12_P.epub"));
        String expectedContent = Files.readAllLines(Paths.get("src/test/resources/toc.xhtml")).stream().collect(Collectors.joining("\r\n"))
        expectedContent += "\r\n"
        when:
        String result = reader.getEntryContent("OEBPS/toc.xhtml");
        then:
        expectedContent == result
    }

}
