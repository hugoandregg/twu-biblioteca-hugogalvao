package com.twu.biblioteca.controller;

import com.twu.biblioteca.constants.Messages;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.exception.BookIsNotAvailableException;
import com.twu.biblioteca.exception.NotValidBookToReturn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookController {

    private List<Book> booksList = new ArrayList<Book>() {{
        add(new Book("Harry Potter and the Sorcerer's stone", "J.K. Rowling", 2015, false));
        add(new Book("The Last Wish: Introducing the Witcher", "Andrzej Sapkowski", 2008, false));
        add(new Book("The Handmaid's tale", "Margaret Atwood", 1986, false));
    }};

    public List<Book> getBooksList() {
        return booksList.stream()
                .filter(book -> !book.isCheckedOut())
                .collect(Collectors.toList());
    }

    public String checkoutBookFromLibrary(String title) {
        if (isBookAvailable(title)) {
            checkoutBook(title);
            return Messages.CHECKOUT_AVAILABLE_BOOK_MESSAGE;
        }
        throw new BookIsNotAvailableException(Messages.CHECKOUT_UNAVAILABLE_BOOK_MESSAGE);
    }

    public String returnBookToLibrary(String title) {
        if (isABookFromLibrary(title) && !isBookAvailable(title)) {
            returnBook(title);
            return Messages.RETURN_VALID_BOOK_MESSAGE;
        }
        throw new NotValidBookToReturn(Messages.RETURN_INVALID_BOOK_MESSAGE);
    }

    private boolean isABookFromLibrary(String title) {
        return booksList.stream().anyMatch(book -> book.getTitle().equalsIgnoreCase(title));
    }

    private boolean isBookAvailable(String title) {
        return booksList.stream().anyMatch(book -> book.getTitle().equalsIgnoreCase(title) && !book.isCheckedOut());
    }

    private void checkoutBook(String title) {
        booksList.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .ifPresent(book -> book.setCheckedOut(true));
    }

    private void returnBook(String title) {
        booksList.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .ifPresent(book -> book.setCheckedOut(false));

    }
}
