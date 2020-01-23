package com.twu.biblioteca.controller;

import com.twu.biblioteca.constants.Messages;
import com.twu.biblioteca.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookController {

    private List<Book> booksList = new ArrayList<Book>() {{
        add(new Book("Harry Potter and the Sorcerer's stone", "J.K. Rowling", 2015));
        add(new Book("The Last Wish: Introducing the Witcher", "Andrzej Sapkowski", 2008));
        add(new Book("The Handmaid's tale", "Margaret Atwood", 1986));
    }};

    private List<Book> originalBookList = new ArrayList<>(booksList);

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

    public String returnBook(String title) {
        if (isABookFromLibrary(title) && !isBookAvailable(title)) {
            returnBookToList(title);
            return Messages.RETURN_VALID_BOOK_MESSAGE;
        }
        return Messages.RETURN_INVALID_BOOK_MESSAGE;
    }

    private void returnBookToList(String title) {
        Optional<Book> matchingBook = originalBookList.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title)).findFirst();
        Book returnedBook = matchingBook.get();
        booksList.add(returnedBook);
    }

    private boolean isABookFromLibrary(String title) {
        return originalBookList.stream().anyMatch(book -> book.getTitle().equalsIgnoreCase(title));
    }

    private boolean isBookAvailable(String title) {
        return booksList.stream().anyMatch(book -> book.getTitle().equalsIgnoreCase(title));
    }

    private boolean removeBookIfItsAvailable(String title) {
        return booksList.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }
}
