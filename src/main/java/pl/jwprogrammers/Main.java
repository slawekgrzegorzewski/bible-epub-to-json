package pl.jwprogrammers;

import pl.jwprogrammers.exceptions.InvalidFormatException;
import pl.jwprogrammers.exceptions.NonExistingEpubFileException;
import pl.jwprogrammers.parser.EpubReader;
import pl.jwprogrammers.parser.TOCParser;

import java.util.Map;

public class Main {
    public static void main(String[] args) throws NonExistingEpubFileException, InvalidFormatException {
        EpubReader reader = new EpubReader(args[0]);
        Map<String, String> parser = new TOCParser(reader.getEntryContent("OEBPS/toc.xhtml")).parse();
        System.out.println("a");
    }
}
