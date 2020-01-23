package com.twu.biblioteca.exception;

public class NotValidBookToReturn extends RuntimeException {
    public NotValidBookToReturn(String message) {
        super(message);
    }
}
