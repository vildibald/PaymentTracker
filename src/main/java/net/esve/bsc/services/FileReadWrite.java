package net.esve.bsc.services;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Created by Viliam on 05-May-16.
 * @author Mamak
 * @version $Revision: 1.0 $
 */

public class FileReadWrite {

    /**
     * Method readFileLines.
     * @param path String
     * @return List<String>
     */
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

}
