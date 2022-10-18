package com.magerwa.exceptions;

public class CustomRequestException extends RuntimeException {
    public CustomRequestException() {
        super();
    }

    public CustomRequestException(String message) {
        super(message);
    }
}
