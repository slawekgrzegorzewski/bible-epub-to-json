package pl.jwprogrammers.parser;

import com.google.common.base.Charsets;
import pl.jwprogrammers.exceptions.NonExistingEpubFileException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class EpubReader {
    private final Path pathToFile;

    public EpubReader(String pathToFile) {
        this.pathToFile = Paths.get(pathToFile);
    }

    public String getEntryContent(String entryName) throws NonExistingEpubFileException {
        validate();
        String result = "";
        try (InputStream input = new FileInputStream(pathToFile.toFile());
             ZipInputStream zip = new ZipInputStream(input, Charsets.UTF_8)) {
            ZipEntry entry;
            do {
                entry = zip.getNextEntry();
                if (entry.getName().equals(entryName)) {
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
                    result = new String(content, "UTF-8");
                    break;
                }
            } while (entry != null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    private void validate() throws NonExistingEpubFileException {
        if (!Files.exists(pathToFile)) throw new NonExistingEpubFileException();
    }
}
