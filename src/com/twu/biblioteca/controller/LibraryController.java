package com.twu.biblioteca.controller;

import com.twu.biblioteca.constants.Messages;
import com.twu.biblioteca.entity.product.Book;
import com.twu.biblioteca.entity.user.Costumer;
import com.twu.biblioteca.service.LibraryService;
import com.twu.biblioteca.entity.product.Product;
import com.twu.biblioteca.exception.BookIsNotAvailableException;
import com.twu.biblioteca.exception.NotValidBookToReturn;
import com.twu.biblioteca.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class LibraryController {

    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public List<Product> getBooksList() {
        return libraryService.getProductList()
                .stream()
                .filter(book -> !book.isCheckedOut())
                .collect(Collectors.toList());
    }

    public List<Product> getCheckedOutBooks() {
        return libraryService.getProductList()
                .stream()
                .filter(book -> book.isCheckedOut())
                .collect(Collectors.toList());
    }

    public String checkoutBookFromLibrary(String title, Costumer costumer) {
        if (libraryService.isBookAvailable(title)) {
            libraryService.checkoutBook(title, costumer);
            return Messages.CHECKOUT_AVAILABLE_BOOK_MESSAGE;
        }
        throw new BookIsNotAvailableException(Messages.CHECKOUT_UNAVAILABLE_BOOK_MESSAGE);
    }

    public String returnBookToLibrary(String title, Costumer costumer) {
        if (libraryService.isABookFromLibrary(title) && libraryService.isBookCheckedOutByCostumer(title, costumer)) {
            libraryService.returnBook(title);
            return Messages.RETURN_VALID_BOOK_MESSAGE;
        }
        throw new NotValidBookToReturn(Messages.RETURN_INVALID_BOOK_MESSAGE);
    }

    public Book getBook(String title) {
        return (Book) libraryService.getProductByTitle(title);
    }
}
