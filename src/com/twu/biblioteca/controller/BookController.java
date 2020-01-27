package com.twu.biblioteca.controller;

import com.twu.biblioteca.constants.Messages;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.exception.BookIsNotAvailableException;
import com.twu.biblioteca.exception.NotValidBookToReturn;
import com.twu.biblioteca.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BookController {

    private Library library = new Library(BookRepository.getBooks());

    public List<Book> getBooksList() {
        return library.getBookList()
                .stream()
                .filter(book -> !book.isCheckedOut())
                .collect(Collectors.toList());
    }

    public String checkoutBookFromLibrary(String title) {
        if (library.isBookAvailable(title)) {
            library.checkoutBook(title);
            return Messages.CHECKOUT_AVAILABLE_BOOK_MESSAGE;
        }
        throw new BookIsNotAvailableException(Messages.CHECKOUT_UNAVAILABLE_BOOK_MESSAGE);
    }

    public String returnBookToLibrary(String title) {
        if (library.isABookFromLibrary(title) && !library.isBookAvailable(title)) {
            library.returnBook(title);
            return Messages.RETURN_VALID_BOOK_MESSAGE;
        }
        throw new NotValidBookToReturn(Messages.RETURN_INVALID_BOOK_MESSAGE);
    }
}
