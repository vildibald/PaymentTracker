package net.esve.bsc.services;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Created by Viliam on 05-May-16.
 */
public class FileReadWriteService {

    private static Path filePath;

    public FileReadWriteService(String filename) {
        filePath = FileSystems.getDefault().getPath(".", filename);
    }

    public Path getFilePath() {
        return filePath;
    }

    public List<String> readFileLines() {
        try {
            return Files.readAllLines(filePath, Charset.defaultCharset());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    void writeFileBytes(String filename, String content) {
        try {
            Files.write(FileSystems.getDefault().getPath(".", filename),
                    content.getBytes(),
                    StandardOpenOption.CREATE);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
