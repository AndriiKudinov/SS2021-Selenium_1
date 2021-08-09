package Exceptions;

public class BrowserIsNotSupportedException extends RuntimeException {
    public BrowserIsNotSupportedException(String errorMessage) {
        super(errorMessage);
    }
}
