package com.twu.biblioteca.entity;

import java.util.List;

public class Library {

    private List<Book> bookList;

    public Library(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public boolean isABookFromLibrary(String title) {
        return bookList.stream().anyMatch(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public boolean isBookAvailable(String title) {
        return bookList.stream().anyMatch(book -> book.getTitle().equalsIgnoreCase(title) && !book.isCheckedOut());
    }

    public void checkoutBook(String title) {
        bookList.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .ifPresent(book -> book.setCheckedOut(true));
    }

    public void returnBook(String title) {
        bookList.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .ifPresent(book -> book.setCheckedOut(false));

    }
}
