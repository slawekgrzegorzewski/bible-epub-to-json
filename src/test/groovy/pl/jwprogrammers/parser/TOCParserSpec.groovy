package pl.jwprogrammers.parser

import pl.jwprogrammers.exceptions.InvalidTOCFormatException
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors

class TOCParserSpec extends Specification {

    @Shared
    Map<String, String> chapters = new TOCParser(Files.readAllLines(Paths.get("src/test/resources/toc.xhtml")).stream().collect(Collectors.joining("\r\n"))).parse()

    def "toc in incorrect format"() {

        given:
        TOCParser instance = new TOCParser("a")

        when:
        instance.parse()

        then:
        thrown InvalidTOCFormatException
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
        "biblechapternav1.xhtml"  | "Rodzaju"
        "biblechapternav2.xhtml"  | "Wyjścia"
        "biblechapternav3.xhtml"  | "Kapłańska"
        "biblechapternav4.xhtml"  | "Liczb"
        "biblechapternav5.xhtml"  | "Powtórzonego Prawa"
        "biblechapternav6.xhtml"  | "Jozuego"
        "biblechapternav7.xhtml"  | "Sędziów"
        "biblechapternav8.xhtml"  | "Rut"
        "biblechapternav9.xhtml"  | "1 Samuela"
        "biblechapternav10.xhtml" | "2 Samuela"
        "biblechapternav11.xhtml" | "1 Królów"
        "biblechapternav12.xhtml" | "2 Królów"
        "biblechapternav13.xhtml" | "1 Kronik"
        "biblechapternav14.xhtml" | "2 Kronik"
        "biblechapternav15.xhtml" | "Ezdrasza"
        "biblechapternav16.xhtml" | "Nehemiasza"
        "biblechapternav17.xhtml" | "Estery"
        "biblechapternav18.xhtml" | "Hioba"
        "biblechapternav19.xhtml" | "Psalmy"
        "biblechapternav20.xhtml" | "Przysłów"
        "biblechapternav21.xhtml" | "Kaznodziei"
        "biblechapternav22.xhtml" | "Pieśń nad Pieśniami"
        "biblechapternav23.xhtml" | "Izajasza"
        "biblechapternav24.xhtml" | "Jeremiasza"
        "biblechapternav25.xhtml" | "Lamentacje"
        "biblechapternav26.xhtml" | "Ezechiela"
        "biblechapternav27.xhtml" | "Daniela"
        "biblechapternav28.xhtml" | "Ozeasza"
        "biblechapternav29.xhtml" | "Joela"
        "biblechapternav30.xhtml" | "Amosa"
        "1001060432.xhtml"        | "Abdiasza"
        "biblechapternav32.xhtml" | "Jonasza"
        "biblechapternav33.xhtml" | "Micheasza"
        "biblechapternav34.xhtml" | "Nahuma"
        "biblechapternav35.xhtml" | "Habakuka"
        "biblechapternav36.xhtml" | "Sofoniasza"
        "biblechapternav37.xhtml" | "Aggeusza"
        "biblechapternav38.xhtml" | "Zachariasza"
        "biblechapternav39.xhtml" | "Malachiasza"
        "biblechapternav40.xhtml" | "Mateusza"
        "biblechapternav41.xhtml" | "Marka"
        "biblechapternav42.xhtml" | "Łukasza"
        "biblechapternav43.xhtml" | "Jana"
        "biblechapternav44.xhtml" | "Dzieje Apostolskie"
        "biblechapternav45.xhtml" | "Rzymian"
        "biblechapternav46.xhtml" | "1 Koryntian"
        "biblechapternav47.xhtml" | "2 Koryntian"
        "biblechapternav48.xhtml" | "Galatów"
        "biblechapternav49.xhtml" | "Efezjan"
        "biblechapternav50.xhtml" | "Filipian"
        "biblechapternav51.xhtml" | "Kolosan"
        "biblechapternav52.xhtml" | "1 Tesaloniczan"
        "biblechapternav53.xhtml" | "2 Tesaloniczan"
        "biblechapternav54.xhtml" | "1 Tymoteusza"
        "biblechapternav55.xhtml" | "2 Tymoteusza"
        "biblechapternav56.xhtml" | "Tytusa"
        "1001060458.xhtml"        | "Filemona"
        "biblechapternav58.xhtml" | "Hebrajczyków"
        "biblechapternav59.xhtml" | "Jakuba"
        "biblechapternav60.xhtml" | "1 Piotra"
        "biblechapternav61.xhtml" | "2 Piotra"
        "biblechapternav62.xhtml" | "1 Jana"
        "1001060464.xhtml"        | "2 Jana"
        "1001060465.xhtml"        | "3 Jana"
        "1001060466.xhtml"        | "Judy"
        "biblechapternav66.xhtml" | "Objawienie"
    }
}
