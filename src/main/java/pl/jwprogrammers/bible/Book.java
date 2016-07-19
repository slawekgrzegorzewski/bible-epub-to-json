package pl.jwprogrammers.bible;

import com.google.common.collect.ImmutableList;

public enum Book {
    GENESIS(1, "Genesis", "Rodzaju", "RODZAJU", ImmutableList.of(0)),
    EXODUS(2, "Exodus", "Wyjścia", "WYJŚCIA", ImmutableList.of(0)),
    LEVITICUS(3, "Leviticus", "Kapłańska", "KAPŁAŃSKA", ImmutableList.of(0)),
    NUMBERS(4, "Numbers", "Liczb", "LICZB", ImmutableList.of(0)),
    DEUTERONOMY(5, "Deuteronomy", "Powtórzonego Prawa", "POWTÓRZONEGO_PRAWA", ImmutableList.of(0)),
    JOSHUA(6, "Joshua", "Jozuego", "JOZUEGO", ImmutableList.of(0)),
    JUDGES(7, "Judges", "Sędziów", "SĘDZIÓW", ImmutableList.of(0)),
    RUTH(8, "Ruth", "Rut", "RUT", ImmutableList.of(0)),
    FIRST_SAMUEL(9, "1 Samuel", "1 Samuela", "1_SAMUELA", ImmutableList.of(0)),
    SECOND_SAMUEL(10, "2 Samuel", "2 Samuela", "2_SAMUELA", ImmutableList.of(0)),
    FIRST_KINGS(11, "1 Kings", "1 Królów", "1_KRÓLÓW", ImmutableList.of(0)),
    SECOND_KINGS(12, "2 Kings", "2 Królów", "2_KRÓLÓW", ImmutableList.of(0)),
    FIRST_CHRONICLES(13, "1 Chronicles", "1 Kronik", "1_KRONIK", ImmutableList.of(0)),
    SECOND_CHRONICLES(14, "2 Chronicles", "2 Kronik", "2_KRONIK", ImmutableList.of(0)),
    EZRA(15, "Ezra", "Ezdrasza", "EZDRASZA", ImmutableList.of(0)),
    NEHEMIAH(16, "Nehemiah", "Nehemiasza", "NEHEMIASZA", ImmutableList.of(0)),
    ESTHER(17, "Esther", "Estery", "ESTERY", ImmutableList.of(0)),
    JOB(18, "Job", "Hioba", "HIOBA", ImmutableList.of(0)),
    PSALMS(19, "Psalms", "Psalmy", "PSALM", ImmutableList.of(0)),
    PROVERBS(20, "Proverbs", "Przysłów", "PRZYSŁÓW", ImmutableList.of(0)),
    ECCLESIASTES(21, "Ecclesiastes", "Kaznodziei", "KAZNODZIEI", ImmutableList.of(0)),
    SONG_OF_SOLOMON(22, "Song of Solomon", "Pieśń nad Pieśniami", "PIEŚŃ_NAD_PIEŚNIAMI", ImmutableList.of(0)),
    ISAIAH(23, "Isiah", "Izajasza", "IZAJASZA", ImmutableList.of(0)),
    JEREMIAH(24, "Jeremiah", "Jeremiasza", "JEREMIASZA", ImmutableList.of(0)),
    LAMENTATIONS(25, "Lamentations", "Lamentacje", "LAMENTACJE", ImmutableList.of(0)),
    EZEKIEL(26, "Ezekiel", "Ezechiela", "EZECHIELA", ImmutableList.of(0)),
    DANIEL(27, "Daniel", "Daniela", "DANIELA", ImmutableList.of(0)),
    HOSEA(28, "Hoshea", "Ozeasza", "OZEASZA", ImmutableList.of(0)),
    JOEL(29, "Joel", "Joela", "JOELA", ImmutableList.of(0)),
    AMOS(30, "Amos", "Amosa", "AMOSA", ImmutableList.of(0)),
    OBADIAH(31, "Obadiah", "Abdiasza", "ABDIASZA", ImmutableList.of(0)),
    JONAH(32, "Jonah", "Jonasza", "JONASZA", ImmutableList.of(0)),
    MICAH(33, "Micah", "Micheasza", "MICHEASZA", ImmutableList.of(0)),
    NAHUM(34, "Nahum", "Nahuma", "NAHUMA", ImmutableList.of(0)),
    HABAKKUK(35, "Habakkuk", "Habakuka", "HABAKUKA", ImmutableList.of(0)),
    ZEPHANIAH(36, "Zephaniah", "Sofoniasza", "SOFONIASZA", ImmutableList.of(0)),
    HAGGAI(37, "Haggai", "Aggeusza", "AGGEUSZA", ImmutableList.of(0)),
    ZECHARIAH(38, "Zechariah", "Zachariasza", "ZACHARIASZA", ImmutableList.of(0)),
    MALACHI(39, "Malachi", "Malachiasza", "MALACHIASZA", ImmutableList.of(0)),
    MATTHEW(40, "Matthew", "Mateusza", "MATEUSZA", ImmutableList.of(0)),
    MARK(41, "Mark", "Marka", "MARKA", ImmutableList.of(0)),
    LUKE(42, "Luke", "Łukasza", "ŁUKASZA", ImmutableList.of(0)),
    JOHN(43, "John", "Jana", "JANA", ImmutableList.of(0)),
    ACTS(44, "Acts", "Dzieje Apostolskie", "DZIEJE", ImmutableList.of(0)),
    ROMANS(45, "Romans", "Rzymian", "RZYMIAN", ImmutableList.of(0)),
    FIRST_CORINTHIANS(46, "1 Corinthians", "1 Koryntian", "1_KORYNTIAN", ImmutableList.of(0)),
    SECOND_CORINTHIANS(47, "2 Corinthians", "2 Koryntian", "2_KORYNTIAN", ImmutableList.of(0)),
    GALATIANS(48, "Galatians", "Galatów", "GALATÓW", ImmutableList.of(0)),
    EPHESIANS(49, "Ephesians", "Efezjan", "EFEZJAN", ImmutableList.of(0)),
    PHILIPPIANS(50, "Philippians", "Filipian", "FILIPIAN", ImmutableList.of(0)),
    COLOSSIANS(51, "Colossians", "Kolosan", "KOLOSAN", ImmutableList.of(0)),
    FIRST_THESSALONIANS(52, "1 Thessalonians", "1 Tesaloniczan", "1_TESALONICZAN", ImmutableList.of(0)),
    SECOND_THESSALONIANS(53, "2 Thessalonians", "2 Tesaloniczan", "2_TESALONICZAN", ImmutableList.of(0)),
    FIRST_TIMOTHY(54, "1 Timothy", "1 Tymoteusza", "1_TYMOTEUSZA", ImmutableList.of(0)),
    SECOND_TIMOTHY(55, "2 Timothy", "2 Tymoteusza", "2_TYMOTEUSZA", ImmutableList.of(0)),
    TITUS(56, "Titus", "Tytusa", "TYTUSA", ImmutableList.of(0)),
    PHILEMON(57, "Philemon", "Filemona", "FILEMONA", ImmutableList.of(0)),
    HEBREWS(58, "Hebrews", "Hebrajczyków", "HEBRAJCZYKÓW", ImmutableList.of(0)),
    JAMES(59, "James", "Jakuba", "JAKUBA", ImmutableList.of(0)),
    FIRST_PETER(60, "1 Peter", "1 Piotra", "1_PIOTRA", ImmutableList.of(0)),
    SECOND_PETER(61, "2 Peter", "2 Piotra", "2_PIOTRA", ImmutableList.of(0)),
    FIRST_JOHN(62, "1 John", "1 Jana", "1_JANA", ImmutableList.of(0)),
    SECOND_JOHN(63, "2 John", "2 Jana", "2_JANA", ImmutableList.of(0)),
    THIRD_JOHN(64, "3 John", "3 Jana", "3_JANA", ImmutableList.of(0)),
    JUDE(65, "Jude", "Judy", "JUDY", ImmutableList.of(0)),
    REVELATION(66, "Revelation", "Objawienie", "OBJAWIENIE", ImmutableList.of(0));

    private final int order;
    private final String englishName;
    private final String polishName;
    private final String verseInFileName;
    private final ImmutableList<Integer> verses;

    Book(int order, String englishName, String polishName, String verseInFileName, ImmutableList<Integer> verses) {
        this.order = order;
        this.englishName = englishName;
        this.polishName = polishName;
        this.verseInFileName = verseInFileName;
        this.verses = verses;
    }

    public int getOrder() {
        return order;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getPolishName() {
        return polishName;
    }

    public String getVerseInFileName() {
        return verseInFileName;
    }
}
