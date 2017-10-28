package ru.ilka.shuttles.exception;

/**
 * Here could be your advertisement +375 29 3880490
 */
public class DataBaseException extends Exception {
    public DataBaseException() {
    }

    public DataBaseException(String message) {
        super(message);
    }

    public DataBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataBaseException(Throwable cause) {
        super(cause);
    }
}
