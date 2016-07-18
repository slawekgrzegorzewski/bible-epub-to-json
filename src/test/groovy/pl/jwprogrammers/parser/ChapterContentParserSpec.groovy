package pl.jwprogrammers.parser

import spock.lang.Shared
import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors

public class ChapterContentParserSpec extends Specification {

    @Shared
    ChapterContentParser parser = new ChapterContentParser(
            Files.readAllLines(Paths.get("src/test/resources/1001060414.xhtml"))
                    .stream().collect(Collectors.joining("\r\n")))
    @Shared
    Map<String, String> verses = parser.parse()

    def "a"() {
        given:
        when:
        verses
        then:
        !verses.isEmpty()
        expect:
        verses.get(a).equals(b)
        where:
        a  | b
        1  | "Adam,\r\nSet,\r\nEnosz,"
        2  | "Kenan,\r\nMahalalel,\r\nJared,"
        3  | "Henoch,\r\nMetuszelach,\r\nLamech,"
        4  | "Noe,\r\nSem, Cham i Jafet."
        5  | "Synami Jafeta byli: Gomer i Magog, i Madaj, i Jawan, i Tubal, i Meszech, i Tiras."
        6  | "A synami Gomera byli: Aszkenaz i Rifat, i Togarma."
        7  | "A synami Jawana byli: Elisza i Tarszisz, Kittim i Rodanim."
        8  | "Synami Chama byli: Kusz i Micraim, Put i Kanaan."
        9  | "A synami Kusza byli: Seba i Chawila, i Sabta, i Rama, i Sabtecha.\r\nA synami Ramy byli: Szeba i Dedan."
        10 | "A Kusz został ojcem Nimroda. On pierwszy stał się mocarzem na ziemi."
        11 | "Micraimowi zaś urodzili się Ludim i Anamim, i Lehabim, i Naftuchim,"
        12 | "i Patrusim, i Kasluchim (od których wywodzą się Filistyni), i Kaftorim."
        13 | "A Kanaan został ojcem Sydona, swego pierworodnego, i Heta,"
        14 | "i Jebusyty, i Amoryty, i Girgaszyty,"
        15 | "i Chiwwity, i Arkity, i Synity,"
        16 | "i Arwadyty, i Cemaryty, i Chamatyty."
        17 | "Synami Sema byli: Elam i Aszszur, i Arpachszad, i Lud, i Aram\r\noraz Uc i Chul, i Geter, i Masz."
        18 | "Arpachszad zaś został ojcem Szelacha, a Szelach został ojcem Ebera."
        19 | "A Eberowi urodzili się dwaj synowie. Jeden miał na imię Peleg, gdyż za jego dni ziemia została podzielona; a jego brat miał na imię Joktan."
        20 | "Joktan zaś został ojcem Almodada i Szelefa, i Chacarmaweta, i Jaracha,"
        21 | "i Hadorama, i Uzala, i Dikli,"
        22 | "i Obala, i Abimaela, i Szeby,"
        23 | "i Ofira, i Chawili, i Jobaba; wszyscy oni byli synami Joktana."
        24 | "Sem,\r\nArpachszad,\r\nSzelach,"
        25 | "Eber,\r\nPeleg,\r\nReu,"
        26 | "Serug,\r\nNachor,\r\nTerach,"
        27 | "Abram, czyli Abraham."
        28 | "Synami Abrahama byli: Izaak i Ismael."
        29 | "Oto ich rodowody: pierworodny Ismaela, Nebajot, a także Kedar i Adbeel, i Mibsam,"
        30 | "Miszma i Duma, Massa, Chadad i Tema,"
        31 | "Jetur, Nafisz i Kedma. Byli oni synami Ismaela."
        32 | "A jeśli chodzi o synów Ketury, nałożnicy Abrahama, urodziła ona Zimrana i Jokszana, i Medana, i Midiana, i Jiszbaka, i Szuacha.\r\nA synami Jokszana byli: Szeba i Dedan."
        33 | "A synami Midiana byli: Efa i Efer, i Chanoch, i Abida, i Eldaa.\r\nWszyscy oni byli synami Ketury."
        34 | "Abraham został ojcem Izaaka. Synami Izaaka byli: Ezaw i Izrael."
        35 | "Synami Ezawa byli: Elifaz, Reuel i Jeusz, i Jalam, i Korach."
        36 | "Synami Elifaza byli: Teman i Omar, Cefo i Gatam, Kenaz, a poprzez Timnę — Amalek."
        37 | "Synami Reuela byli: Nachat, Zerach, Szamma i Mizza."
        38 | "A synami Seira byli: Lotan i Szobal, i Cibeon, i Ana, i Diszon, i Ecer, i Diszan."
        39 | "A synami Lotana byli: Chori i Homam. A siostrą Lotana była Timna."
        40 | "Synami Szobala byli: Alwan i Manachat, i Ebal, Szefo i Onam.\r\nA synami Cibeona byli: Aja i Ana."
        41 | "Synami Any: Diszon.\r\nA synami Diszona byli: Chemdan i Eszban, i Jitran, i Keran."
        42 | "Synami Ecera byli: Bilhan i Zaawan, i Akan.\r\nSynami Diszana byli: Uc i Aran."
        43 | "A oto królowie, którzy panowali w ziemi edomskiej, zanim jakikolwiek król zaczął panować nad synami Izraela: Bela, syn Beora, którego miasto nazywało się Dinhaba."
        44 | "Potem umarł Bela, a w jego miejsce zaczął panować Jobab, syn Zeracha z Bocry."
        45 | "Potem umarł Jobab, a w jego miejsce zaczął panować Chuszam z ziemi Temanitów."
        46 | "Potem umarł Chuszam, a w jego miejsce zaczął panować Hadad, syn Bedada, który zadał klęskę Midianowi na polu moabskim. A jego miasto nazywało się Awit."
        47 | "Potem umarł Hadad, a w jego miejsce zaczął panować Samla z Masreki."
        48 | "Potem umarł Samla, a w jego miejsce zaczął panować Szaul z Rechobot nad Rzeką."
        49 | "Potem umarł Szaul, a w jego miejsce zaczął panować Baal-Chanan, syn Achbora."
        50 | "Potem umarł Baal-Chanan, a w jego miejsce zaczął panować Hadad; a jego miasto nazywało się Pau, jego żona zaś miała na imię Mehetabel i była córką Matred, córki Mezahab."
        51 | "Potem umarł Hadad.\r\nA szejkami Edomu zostali: szejk Timna, szejk Alwa, szejk Jetet,"
        52 | "szejk Oholibama, szejk Ela, szejk Pinon,"
        53 | "szejk Kenaz, szejk Teman, szejk Mibcar,"
        54 | "szejk Magdiel, szejk Iram. Byli to szejkowie Edomu."

    }

}
