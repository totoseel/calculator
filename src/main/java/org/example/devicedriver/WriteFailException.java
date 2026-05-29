package org.example.devicedriver;

public class WriteFailException extends RuntimeException {
    public WriteFailException() {
    }

    public WriteFailException(String message) {
        super(message);
    }
}
