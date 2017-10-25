package ru.ilka.shuttles.exception;

public class ShuttleLogicException extends Exception {
    public ShuttleLogicException() {
    }

    public ShuttleLogicException(String message) {
        super(message);
    }

    public ShuttleLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShuttleLogicException(Throwable cause) {
        super(cause);
    }
}
