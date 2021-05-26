package by.silebin.information_handling.exception;

public class WrongCompositeTypeException extends Exception {
    public WrongCompositeTypeException() {
    }

    public WrongCompositeTypeException(String message) {
        super(message);
    }

    public WrongCompositeTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongCompositeTypeException(Throwable cause) {
        super(cause);
    }
}
