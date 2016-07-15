package pl.jwprogrammers.parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EpubReaderTest {

    @Test(expected = NonExistingEpubFileException.class)
    public void notExistingFile() throws NonExistingEpubFileException {
        EpubReader reader = new EpubReader("test/bi12_P.epub");
        reader.getEntryContent("a");
    }

    @Test
    public void existingFile() {
        EpubReader reader = new EpubReader("src/test/resources/bi12_P.epub");
        try {
            reader.getEntryContent("a");
        } catch (NonExistingEpubFileException e) {
            fail("Exception not allowed here");
        }
    }

    @Test
    public void readEntry() throws NonExistingEpubFileException {
        EpubReader reader = new EpubReader("src/test/resources/bi12_P.epub");
        String result = reader.getEntryContent("OEBPS/toc.xhtml");
        assertEquals(entryContent, result);
    }

    private final String entryContent = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:epub=\"http://www.idpf.org/2007/ops\">\r\n" +
            "<head>\r\n" +
            "<title>Przekład Nowego Świata (bi12-P)</title>\r\n" +
            "<link rel=\"stylesheet\" href=\"css/epub2toc.css\" type=\"text/css\" />\r\n" +
            "</head>\r\n" +
            "<body>\r\n" +
            "<section epub:type=\"frontmatter toc\">\r\n" +
            "<nav epub:type=\"toc\" id=\"toc\">\r\n" +
            "<ol>\r\n" +
            "<li id=\"chapter1\">\r\n" +
            "<a href=\"biblebooknav.xhtml\">Nawigacja po Biblii</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter2\">\r\n" +
            "<a href=\"biblechapternav1.xhtml\">Rodzaju</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter3\">\r\n" +
            "<a href=\"biblechapternav2.xhtml\">Wyjścia</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter4\">\r\n" +
            "<a href=\"biblechapternav3.xhtml\">Kapłańska</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter5\">\r\n" +
            "<a href=\"biblechapternav4.xhtml\">Liczb</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter6\">\r\n" +
            "<a href=\"biblechapternav5.xhtml\">Powtórzonego Prawa</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter7\">\r\n" +
            "<a href=\"biblechapternav6.xhtml\">Jozuego</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter8\">\r\n" +
            "<a href=\"biblechapternav7.xhtml\">Sędziów</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter9\">\r\n" +
            "<a href=\"biblechapternav8.xhtml\">Rut</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter10\">\r\n" +
            "<a href=\"biblechapternav9.xhtml\">1 Samuela</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter11\">\r\n" +
            "<a href=\"biblechapternav10.xhtml\">2 Samuela</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter12\">\r\n" +
            "<a href=\"biblechapternav11.xhtml\">1 Królów</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter13\">\r\n" +
            "<a href=\"biblechapternav12.xhtml\">2 Królów</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter14\">\r\n" +
            "<a href=\"biblechapternav13.xhtml\">1 Kronik</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter15\">\r\n" +
            "<a href=\"biblechapternav14.xhtml\">2 Kronik</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter16\">\r\n" +
            "<a href=\"biblechapternav15.xhtml\">Ezdrasza</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter17\">\r\n" +
            "<a href=\"biblechapternav16.xhtml\">Nehemiasza</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter18\">\r\n" +
            "<a href=\"biblechapternav17.xhtml\">Estery</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter19\">\r\n" +
            "<a href=\"biblechapternav18.xhtml\">Hioba</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter20\">\r\n" +
            "<a href=\"biblechapternav19.xhtml\">Psalmy</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter21\">\r\n" +
            "<a href=\"biblechapternav20.xhtml\">Przysłów</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter22\">\r\n" +
            "<a href=\"biblechapternav21.xhtml\">Kaznodziei</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter23\">\r\n" +
            "<a href=\"biblechapternav22.xhtml\">Pieśń nad Pieśniami</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter24\">\r\n" +
            "<a href=\"biblechapternav23.xhtml\">Izajasza</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter25\">\r\n" +
            "<a href=\"biblechapternav24.xhtml\">Jeremiasza</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter26\">\r\n" +
            "<a href=\"biblechapternav25.xhtml\">Lamentacje</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter27\">\r\n" +
            "<a href=\"biblechapternav26.xhtml\">Ezechiela</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter28\">\r\n" +
            "<a href=\"biblechapternav27.xhtml\">Daniela</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter29\">\r\n" +
            "<a href=\"biblechapternav28.xhtml\">Ozeasza</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter30\">\r\n" +
            "<a href=\"biblechapternav29.xhtml\">Joela</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter31\">\r\n" +
            "<a href=\"biblechapternav30.xhtml\">Amosa</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter32\">\r\n" +
            "<a href=\"1001060432.xhtml\">Abdiasza</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter33\">\r\n" +
            "<a href=\"biblechapternav32.xhtml\">Jonasza</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter34\">\r\n" +
            "<a href=\"biblechapternav33.xhtml\">Micheasza</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter35\">\r\n" +
            "<a href=\"biblechapternav34.xhtml\">Nahuma</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter36\">\r\n" +
            "<a href=\"biblechapternav35.xhtml\">Habakuka</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter37\">\r\n" +
            "<a href=\"biblechapternav36.xhtml\">Sofoniasza</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter38\">\r\n" +
            "<a href=\"biblechapternav37.xhtml\">Aggeusza</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter39\">\r\n" +
            "<a href=\"biblechapternav38.xhtml\">Zachariasza</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter40\">\r\n" +
            "<a href=\"biblechapternav39.xhtml\">Malachiasza</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter41\">\r\n" +
            "<a href=\"biblechapternav40.xhtml\">Mateusza</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter42\">\r\n" +
            "<a href=\"biblechapternav41.xhtml\">Marka</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter43\">\r\n" +
            "<a href=\"biblechapternav42.xhtml\">Łukasza</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter44\">\r\n" +
            "<a href=\"biblechapternav43.xhtml\">Jana</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter45\">\r\n" +
            "<a href=\"biblechapternav44.xhtml\">Dzieje Apostolskie</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter46\">\r\n" +
            "<a href=\"biblechapternav45.xhtml\">Rzymian</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter47\">\r\n" +
            "<a href=\"biblechapternav46.xhtml\">1 Koryntian</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter48\">\r\n" +
            "<a href=\"biblechapternav47.xhtml\">2 Koryntian</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter49\">\r\n" +
            "<a href=\"biblechapternav48.xhtml\">Galatów</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter50\">\r\n" +
            "<a href=\"biblechapternav49.xhtml\">Efezjan</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter51\">\r\n" +
            "<a href=\"biblechapternav50.xhtml\">Filipian</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter52\">\r\n" +
            "<a href=\"biblechapternav51.xhtml\">Kolosan</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter53\">\r\n" +
            "<a href=\"biblechapternav52.xhtml\">1 Tesaloniczan</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter54\">\r\n" +
            "<a href=\"biblechapternav53.xhtml\">2 Tesaloniczan</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter55\">\r\n" +
            "<a href=\"biblechapternav54.xhtml\">1 Tymoteusza</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter56\">\r\n" +
            "<a href=\"biblechapternav55.xhtml\">2 Tymoteusza</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter57\">\r\n" +
            "<a href=\"biblechapternav56.xhtml\">Tytusa</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter58\">\r\n" +
            "<a href=\"1001060458.xhtml\">Filemona</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter59\">\r\n" +
            "<a href=\"biblechapternav58.xhtml\">Hebrajczyków</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter60\">\r\n" +
            "<a href=\"biblechapternav59.xhtml\">Jakuba</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter61\">\r\n" +
            "<a href=\"biblechapternav60.xhtml\">1 Piotra</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter62\">\r\n" +
            "<a href=\"biblechapternav61.xhtml\">2 Piotra</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter63\">\r\n" +
            "<a href=\"biblechapternav62.xhtml\">1 Jana</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter64\">\r\n" +
            "<a href=\"1001060464.xhtml\">2 Jana</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter65\">\r\n" +
            "<a href=\"1001060465.xhtml\">3 Jana</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter66\">\r\n" +
            "<a href=\"1001060466.xhtml\">Judy</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter67\">\r\n" +
            "<a href=\"biblechapternav66.xhtml\">Objawienie</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter68\">\r\n" +
            "<a href=\"1001060547.xhtml\">Pismo Święte w Przekładzie Nowego Świata</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter69\">\r\n" +
            "<a href=\"1001060479.xhtml\">Przednia wyklejka</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter70\">\r\n" +
            "<a href=\"1001060480.xhtml\">Strony tytułowa i redakcyjna</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter71\">\r\n" +
            "<a href=\"1001060400.xhtml\">Przedmowa</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter72\">\r\n" +
            "<a href=\"1001060401.xhtml\">Nazwy i kolejność ksiąg</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter73\">\r\n" +
            "<a href=\"1001060468.xhtml\">Zestawienie ksiąg biblijnych</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter74\">\r\n" +
            "<a href=\"1001060469.xhtml\">Skorowidz</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter75\">\r\n" +
            "<a href=\"1001060470.xhtml\">1 Imię Boże w Pismach Hebrajskich i Chrześcijańskich Pismach Greckich</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter76\">\r\n" +
            "<a href=\"1001060471.xhtml\">2 „Gehenna” — symbol całkowitej zagłady</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter77\">\r\n" +
            "<a href=\"1001060472.xhtml\">3 „Dusza” — żywe stworzenie, człowiek lub zwierzę; życie osoby</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter78\">\r\n" +
            "<a href=\"1001060473.xhtml\">4 „Szeol”, „Hades” — powszechny grób ludzkości</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter79\">\r\n" +
            "<a href=\"1001060474.xhtml\">5 Mapa do Księgi Rodzaju — rejon Kanaanu</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter80\">\r\n" +
            "<a href=\"1001060475.xhtml\">6 Terytorium plemion Izraela</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter81\">\r\n" +
            "<a href=\"1001060476.xhtml\">7 Królestwo Saula, Dawida i Salomona</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter82\">\r\n" +
            "<a href=\"1001060477.xhtml\">8 Palestyna w czasach służby Jezusa</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter83\">\r\n" +
            "<a href=\"1001060478.xhtml\">Biblijne tematy do rozmów</a>\r\n" +
            "</li>\r\n" +
            "<li id=\"chapter84\">\r\n" +
            "<a href=\"1001060481.xhtml\">Tylna wyklejka</a>\r\n" +
            "</li>\r\n" +
            "</ol>\r\n" +
            "</nav>\r\n" +
            "<nav epub:type=\"page-list\">\r\n" +
            "<ol>\r\n" +
            "\r\n" +
            "<li><a href=\"1001060480.xhtml#page3\">3</a></li>\r\n" +
            "<li><a href=\"1001060480.xhtml#page4\">4</a></li>\r\n" +
            "<li><a href=\"1001060400.xhtml#page5\">5</a></li>\r\n" +
            "<li><a href=\"1001060401.xhtml#page6\">6</a></li>\r\n" +
            "<li><a href=\"1001060468.xhtml#page1561\">1561</a></li>\r\n" +
            "<li><a href=\"1001060468.xhtml#page1562\">1562</a></li>\r\n" +
            "<li><a href=\"1001060469.xhtml#page1563\">1563</a></li>\r\n" +
            "<li><a href=\"1001060469-split3.xhtml#page1564\">1564</a></li>\r\n" +
            "<li><a href=\"1001060469-split3.xhtml#page1565\">1565</a></li>\r\n" +
            "<li><a href=\"1001060469-split3.xhtml#page1566\">1566</a></li>\r\n" +
            "<li><a href=\"1001060469-split4.xhtml#page1567\">1567</a></li>\r\n" +
            "<li><a href=\"1001060469-split4.xhtml#page1568\">1568</a></li>\r\n" +
            "<li><a href=\"1001060469-split4.xhtml#page1569\">1569</a></li>\r\n" +
            "<li><a href=\"1001060469-split6.xhtml#page1570\">1570</a></li>\r\n" +
            "<li><a href=\"1001060469-split6.xhtml#page1571\">1571</a></li>\r\n" +
            "<li><a href=\"1001060469-split6.xhtml#page1572\">1572</a></li>\r\n" +
            "<li><a href=\"1001060469-split6.xhtml#page1573\">1573</a></li>\r\n" +
            "<li><a href=\"1001060469-split9.xhtml#page1574\">1574</a></li>\r\n" +
            "<li><a href=\"1001060469-split9.xhtml#page1575\">1575</a></li>\r\n" +
            "<li><a href=\"1001060469-split9.xhtml#page1576\">1576</a></li>\r\n" +
            "<li><a href=\"1001060469-split11.xhtml#page1577\">1577</a></li>\r\n" +
            "<li><a href=\"1001060469-split12.xhtml#page1578\">1578</a></li>\r\n" +
            "<li><a href=\"1001060469-split13.xhtml#page1579\">1579</a></li>\r\n" +
            "<li><a href=\"1001060469-split13.xhtml#page1580\">1580</a></li>\r\n" +
            "<li><a href=\"1001060469-split13.xhtml#page1581\">1581</a></li>\r\n" +
            "<li><a href=\"1001060469-split14.xhtml#page1582\">1582</a></li>\r\n" +
            "<li><a href=\"1001060469-split16.xhtml#page1583\">1583</a></li>\r\n" +
            "<li><a href=\"1001060469-split16.xhtml#page1584\">1584</a></li>\r\n" +
            "<li><a href=\"1001060469-split16.xhtml#page1585\">1585</a></li>\r\n" +
            "<li><a href=\"1001060469-split17.xhtml#page1586\">1586</a></li>\r\n" +
            "<li><a href=\"1001060469-split17.xhtml#page1587\">1587</a></li>\r\n" +
            "<li><a href=\"1001060469-split17.xhtml#page1588\">1588</a></li>\r\n" +
            "<li><a href=\"1001060469-split17.xhtml#page1589\">1589</a></li>\r\n" +
            "<li><a href=\"1001060469-split17.xhtml#page1590\">1590</a></li>\r\n" +
            "<li><a href=\"1001060469-split17.xhtml#page1591\">1591</a></li>\r\n" +
            "<li><a href=\"1001060469-split18.xhtml#page1592\">1592</a></li>\r\n" +
            "<li><a href=\"1001060469-split18.xhtml#page1593\">1593</a></li>\r\n" +
            "<li><a href=\"1001060469-split18.xhtml#page1594\">1594</a></li>\r\n" +
            "<li><a href=\"1001060469-split18.xhtml#page1595\">1595</a></li>\r\n" +
            "<li><a href=\"1001060469-split18.xhtml#page1596\">1596</a></li>\r\n" +
            "<li><a href=\"1001060469-split19.xhtml#page1597\">1597</a></li>\r\n" +
            "<li><a href=\"1001060469-split19.xhtml#page1598\">1598</a></li>\r\n" +
            "<li><a href=\"1001060469-split19.xhtml#page1599\">1599</a></li>\r\n" +
            "<li><a href=\"1001060469-split19.xhtml#page1600\">1600</a></li>\r\n" +
            "<li><a href=\"1001060469-split19.xhtml#page1601\">1601</a></li>\r\n" +
            "<li><a href=\"1001060469-split19.xhtml#page1602\">1602</a></li>\r\n" +
            "<li><a href=\"1001060469-split19.xhtml#page1603\">1603</a></li>\r\n" +
            "<li><a href=\"1001060469-split19.xhtml#page1604\">1604</a></li>\r\n" +
            "<li><a href=\"1001060469-split19.xhtml#page1605\">1605</a></li>\r\n" +
            "<li><a href=\"1001060469-split19.xhtml#page1606\">1606</a></li>\r\n" +
            "<li><a href=\"1001060469-split19.xhtml#page1607\">1607</a></li>\r\n" +
            "<li><a href=\"1001060469-split19.xhtml#page1608\">1608</a></li>\r\n" +
            "<li><a href=\"1001060469-split20.xhtml#page1609\">1609</a></li>\r\n" +
            "<li><a href=\"1001060469-split20.xhtml#page1610\">1610</a></li>\r\n" +
            "<li><a href=\"1001060469-split20.xhtml#page1611\">1611</a></li>\r\n" +
            "<li><a href=\"1001060469-split21.xhtml#page1612\">1612</a></li>\r\n" +
            "<li><a href=\"1001060469-split21.xhtml#page1613\">1613</a></li>\r\n" +
            "<li><a href=\"1001060469-split21.xhtml#page1614\">1614</a></li>\r\n" +
            "<li><a href=\"1001060469-split21.xhtml#page1615\">1615</a></li>\r\n" +
            "<li><a href=\"1001060469-split21.xhtml#page1616\">1616</a></li>\r\n" +
            "<li><a href=\"1001060469-split21.xhtml#page1617\">1617</a></li>\r\n" +
            "<li><a href=\"1001060469-split21.xhtml#page1618\">1618</a></li>\r\n" +
            "<li><a href=\"1001060469-split22.xhtml#page1619\">1619</a></li>\r\n" +
            "<li><a href=\"1001060469-split22.xhtml#page1620\">1620</a></li>\r\n" +
            "<li><a href=\"1001060469-split23.xhtml#page1621\">1621</a></li>\r\n" +
            "<li><a href=\"1001060469-split24.xhtml#page1622\">1622</a></li>\r\n" +
            "<li><a href=\"1001060469-split24.xhtml#page1623\">1623</a></li>\r\n" +
            "<li><a href=\"1001060469-split24.xhtml#page1624\">1624</a></li>\r\n" +
            "<li><a href=\"1001060469-split24.xhtml#page1625\">1625</a></li>\r\n" +
            "<li><a href=\"1001060469-split25.xhtml#page1626\">1626</a></li>\r\n" +
            "<li><a href=\"1001060469-split25.xhtml#page1627\">1627</a></li>\r\n" +
            "<li><a href=\"1001060469-split25.xhtml#page1628\">1628</a></li>\r\n" +
            "<li><a href=\"1001060469-split25.xhtml#page1629\">1629</a></li>\r\n" +
            "<li><a href=\"1001060469-split25.xhtml#page1630\">1630</a></li>\r\n" +
            "<li><a href=\"1001060469-split25.xhtml#page1631\">1631</a></li>\r\n" +
            "<li><a href=\"1001060469-split25.xhtml#page1632\">1632</a></li>\r\n" +
            "<li><a href=\"1001060469-split25.xhtml#page1633\">1633</a></li>\r\n" +
            "<li><a href=\"1001060469-split26.xhtml#page1634\">1634</a></li>\r\n" +
            "<li><a href=\"1001060469-split26.xhtml#page1635\">1635</a></li>\r\n" +
            "<li><a href=\"1001060469-split26.xhtml#page1636\">1636</a></li>\r\n" +
            "<li><a href=\"1001060469-split26.xhtml#page1637\">1637</a></li>\r\n" +
            "<li><a href=\"1001060469-split26.xhtml#page1638\">1638</a></li>\r\n" +
            "<li><a href=\"1001060469-split26.xhtml#page1639\">1639</a></li>\r\n" +
            "<li><a href=\"1001060469-split26.xhtml#page1640\">1640</a></li>\r\n" +
            "<li><a href=\"1001060469-split26.xhtml#page1641\">1641</a></li>\r\n" +
            "<li><a href=\"1001060469-split28.xhtml#page1642\">1642</a></li>\r\n" +
            "<li><a href=\"1001060470.xhtml#page1643\">1643</a></li>\r\n" +
            "<li><a href=\"1001060471.xhtml#page1644\">1644</a></li>\r\n" +
            "<li><a href=\"1001060473.xhtml#page1645\">1645</a></li>\r\n" +
            "<li><a href=\"1001060474.xhtml#page1646\">1646</a></li>\r\n" +
            "<li><a href=\"1001060475.xhtml#page1647\">1647</a></li>\r\n" +
            "<li><a href=\"1001060476.xhtml#page1648\">1648</a></li>\r\n" +
            "<li><a href=\"1001060477.xhtml#page1649\">1649</a></li>\r\n" +
            "<li><a href=\"1001060478.xhtml#page1650\">1650</a></li>\r\n" +
            "<li><a href=\"1001060478.xhtml#page1651\">1651</a></li>\r\n" +
            "<li><a href=\"1001060478.xhtml#page1652\">1652</a></li>\r\n" +
            "<li><a href=\"1001060478.xhtml#page1653\">1653</a></li>\r\n" +
            "<li><a href=\"1001060478.xhtml#page1654\">1654</a></li>\r\n" +
            "<li><a href=\"1001060478.xhtml#page1655\">1655</a></li>\r\n" +
            "<li><a href=\"1001060478.xhtml#page1656\">1656</a></li>\r\n" +
            "<li><a href=\"1001060478.xhtml#page1657\">1657</a></li>\r\n" +
            "<li><a href=\"1001060478.xhtml#page1658\">1658</a></li>\r\n" +
            "<li><a href=\"1001060478.xhtml#page1659\">1659</a></li>\r\n" +
            "<li><a href=\"1001060478.xhtml#page1660\">1660</a></li>\r\n" +
            "<li><a href=\"1001060478.xhtml#page1661\">1661</a></li>\r\n" +
            "</ol>\r\n" +
            "</nav>\r\n" +
            "</section>\r\n" +
            "</body>\r\n" +
            "</html>\r\n";
}
