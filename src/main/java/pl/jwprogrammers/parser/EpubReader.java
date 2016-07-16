package pl.jwprogrammers.parser;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import pl.jwprogrammers.exceptions.NonExistingEpubFileException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class EpubReader {
    private final Path pathToFile;
    private final Map<String, String> entriesContent = Maps.newHashMap();

    public EpubReader(String pathToFile) {
        this.pathToFile = Paths.get(pathToFile);
    }

    public String getEntryContent(String entryName) throws NonExistingEpubFileException {
        unpack();
        return entriesContent.get(entryName);
    }

    private String readEntryToString(ZipInputStream zip, ZipEntry entry) throws IOException {
        byte[] content = new byte[(int) entry.getSize()];
        byte b;
        int index = 0;
        while ((b = (byte) zip.read()) != -1) {
            content[index] = b;
            index++;
            if (index >= entry.getSize()) {
                break;
            }
        }
        return new String(content, "UTF-8");
    }

    private void unpack() throws NonExistingEpubFileException {
        if (!entriesContent.isEmpty()) return;
        validate();
        try (InputStream input = new FileInputStream(pathToFile.toFile());
             ZipInputStream zip = new ZipInputStream(input, Charsets.UTF_8)) {
            ZipEntry entry;
            do {
                entry = zip.getNextEntry();
                if (entry != null)
                    entriesContent.put(entry.getName(), readEntryToString(zip, entry));
            } while (entry != null);
        } catch (IOException e) {
            System.out.println("Unpacking file unsuccessful");
            entriesContent.isEmpty();
        }

    }

    private void validate() throws NonExistingEpubFileException {
        if (!Files.exists(pathToFile)) throw new NonExistingEpubFileException();
    }
}
