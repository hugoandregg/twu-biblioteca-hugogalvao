package com.twu.biblioteca.controller;

import com.twu.biblioteca.constants.Messages;
import com.twu.biblioteca.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookController {

    private List<Book> booksList = new ArrayList<Book>() {{
        add(new Book("Harry Potter and the Sorcerer's stone", "J.K. Rowling", 2015));
        add(new Book("The Last Wish: Introducing the Witcher", "Andrzej Sapkowski", 2008));
        add(new Book("The Handmaid's tale", "Margaret Atwood", 1986));
    }};

    public String listBooks() {
        StringBuilder booksListStr = new StringBuilder();
        for (Book book : booksList) {
            booksListStr.append(book.toString());
            booksListStr.append(System.getProperty("line.separator"));
        }
        return booksListStr.toString();
    }

    public String checkoutBook(String title) {
        if (removeBookIfItsAvailable(title)) {
            return Messages.CHECKOUT_AVAILABLE_BOOK_MESSAGE;
        }
        return Messages.CHECKOUT_UNAVAILABLE_BOOK_MESSAGE;
    }

    private boolean removeBookIfItsAvailable(String title) {
        return booksList.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public List<Book> getBooksList() {
        return booksList;
    }
}
