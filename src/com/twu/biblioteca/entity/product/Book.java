package com.twu.biblioteca.entity.product;

public class Book extends Product {

    public Book(String title, String creator, int year, boolean checkedOut) {
        super(title, year, creator, checkedOut);
    }

    @Override
    public String toString() {
        return title + " | " + creator + " | " + year;
    }
}
