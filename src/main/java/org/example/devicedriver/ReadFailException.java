package org.example.devicedriver;

public class ReadFailException extends RuntimeException {
    public ReadFailException() {
    }

    public ReadFailException(String message) {
        super(message);
    }
}
