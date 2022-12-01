package com.programming.techie.springtutorialblog.exception;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String message) {
        super(message);
    }

    public PostNotFoundException(String message, Exception exception) {
        super(message, exception);
    }
}
