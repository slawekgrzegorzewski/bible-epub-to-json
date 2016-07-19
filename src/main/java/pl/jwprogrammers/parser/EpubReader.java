package pl.jwprogrammers.parser;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class EpubReader {
    private final Path file;
    private final Map<String, String> entriesContent = Maps.newHashMap();

    public EpubReader(Path file) throws IOException {
        this.file = file;
        unpack();
    }

    private void unpack() throws IOException {
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream(file.toFile()), Charsets.UTF_8)) {
            ZipEntry entry;
            while ((entry = zip.getNextEntry()) != null) {
                entriesContent.put(entry.getName(), getEntryContent(zip, entry));
            }
        } catch (IOException e) {
            entriesContent.clear();
            throw e;
        }
    }

    private String getEntryContent(ZipInputStream zip, ZipEntry entry) throws IOException {
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

    public String getEntryContent(String entryName) {
        return entriesContent.get(entryName);
    }
}
