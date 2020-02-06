package com.twu.biblioteca.entity.user;

public abstract class User {

    protected String libraryNumber;

    protected String password;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }
}
