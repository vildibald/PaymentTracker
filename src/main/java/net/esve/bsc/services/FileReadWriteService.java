package net.esve.bsc.services;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Created by Viliam on 05-May-16.
 */

public class FileReadWriteService {

    public List<String> readFileLines(String path) {
        Path filePath = FileSystems.getDefault().getPath(path);
        try {
            return Files.readAllLines(filePath, Charset.defaultCharset());
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Something is wrong, we are continuing without payments file");
        }
        return null;
    }

    /*void writeFileBytes(String filename, String content) {
        try {
          Files.write(FileSystems.getDefault().getPath(filename),
                    content.getBytes(),
                    StandardOpenOption.CREATE);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    */

}
