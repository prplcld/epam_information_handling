package by.silebin.information_handling.reader;

import by.silebin.information_handling.exception.UnableToReadFileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextFileReader {
    public String readFromFile(String file) throws UnableToReadFileException {
        Path path = Path.of(file);
        try {
            return Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
            throw new UnableToReadFileException();
        }
    }
}
