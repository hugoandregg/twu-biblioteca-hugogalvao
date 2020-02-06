package com.twu.biblioteca.exception;

public class InvalidLibraryNumber extends RuntimeException {
    public InvalidLibraryNumber(String message) {
        super(message);
    }
}
