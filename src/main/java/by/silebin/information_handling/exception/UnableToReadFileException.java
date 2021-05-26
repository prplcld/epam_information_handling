package by.silebin.information_handling.exception;

public class UnableToReadFileException extends Exception {
    public UnableToReadFileException() {
    }

    public UnableToReadFileException(String message) {
        super(message);
    }

    public UnableToReadFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnableToReadFileException(Throwable cause) {
        super(cause);
    }
}
