package Exceptions;

public class InvalidPropertiesException extends RuntimeException {
    public InvalidPropertiesException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
