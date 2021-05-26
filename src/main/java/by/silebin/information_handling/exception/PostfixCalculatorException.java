package by.silebin.information_handling.exception;

public class PostfixCalculatorException extends Exception {
    public PostfixCalculatorException() {
    }

    public PostfixCalculatorException(String message) {
        super(message);
    }

    public PostfixCalculatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public PostfixCalculatorException(Throwable cause) {
        super(cause);
    }
}
