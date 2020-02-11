package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.product.Book;
import com.twu.biblioteca.entity.product.Product;

import java.util.Arrays;
import java.util.List;

public class BookRepository {

    private static BookRepository bookRepository;

    private List<Product> bookList = Arrays.asList(
            new Book("Harry Potter and the Sorcerer's stone", "J.K. Rowling", 2015, false),
            new Book("The Last Wish: Introducing the Witcher", "Andrzej Sapkowski", 2008, false),
            new Book("The Handmaid's tale", "Margaret Atwood", 1986, false)
    );

    private BookRepository() {
    }

    public static BookRepository getInstance() {
        if (bookRepository == null) {
            bookRepository = new BookRepository();
        }
        return bookRepository;
    }

    public List<Product> getBooks() {
        return bookList;
    }
}
