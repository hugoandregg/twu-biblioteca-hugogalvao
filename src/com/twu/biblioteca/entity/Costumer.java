package com.twu.biblioteca.entity;

public class Costumer extends User {

    private String name;

    private String email;

    private String phoneNumber;

    public Costumer(String libraryNumber, String password, String name, String email, String phoneNumber) {
        super(libraryNumber, password);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " | " + email + " | " + phoneNumber;
    }
}
