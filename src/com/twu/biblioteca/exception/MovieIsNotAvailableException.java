package com.twu.biblioteca.exception;

public class MovieIsNotAvailableException extends RuntimeException {
    public MovieIsNotAvailableException(String message) {
        super(message);
    }
}
