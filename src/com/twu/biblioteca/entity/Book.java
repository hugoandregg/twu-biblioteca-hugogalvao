package com.twu.biblioteca.entity;

import java.util.Objects;

public class Book {

    private String title;

    private String author;

    private int year;

    private boolean checkedOut;

    public Book(String title, String author, int year, boolean checkedOut) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.checkedOut = checkedOut;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    @Override
    public String toString() {
        return title + " | " + author + " | " + year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
