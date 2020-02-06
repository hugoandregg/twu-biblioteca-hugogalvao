package com.twu.biblioteca.controller;

import com.twu.biblioteca.constants.Messages;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Costumer;
import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.entity.Product;
import com.twu.biblioteca.exception.BookIsNotAvailableException;
import com.twu.biblioteca.exception.NotValidBookToReturn;
import com.twu.biblioteca.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class LibraryController {

    private Library library = new Library(BookRepository.getBooks());

    public List<Product> getBooksList() {
        return library.getProductList()
                .stream()
                .filter(book -> !book.isCheckedOut())
                .collect(Collectors.toList());
    }

    public List<Product> getCheckedOutBooks() {
        return library.getProductList()
                .stream()
                .filter(book -> book.isCheckedOut())
                .collect(Collectors.toList());
    }

    public String checkoutBookFromLibrary(String title, Costumer costumer) {
        if (library.isBookAvailable(title)) {
            library.checkoutBook(title, costumer);
            return Messages.CHECKOUT_AVAILABLE_BOOK_MESSAGE;
        }
        throw new BookIsNotAvailableException(Messages.CHECKOUT_UNAVAILABLE_BOOK_MESSAGE);
    }

    public String returnBookToLibrary(String title, Costumer costumer) {
        if (library.isABookFromLibrary(title) && library.isBookCheckedOutByCostumer(title, costumer)) {
            library.returnBook(title);
            return Messages.RETURN_VALID_BOOK_MESSAGE;
        }
        throw new NotValidBookToReturn(Messages.RETURN_INVALID_BOOK_MESSAGE);
    }

    public Book getBook(String title) {
        return (Book) library.getProductByTitle(title);
    }
}
