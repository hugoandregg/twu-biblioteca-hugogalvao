package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Product;

import java.util.Arrays;
import java.util.List;

public class BookRepository {
    public static List<Product> getBooks() {
        return Arrays.asList(
                new Book("Harry Potter and the Sorcerer's stone", "J.K. Rowling", 2015, false),
                new Book("The Last Wish: Introducing the Witcher", "Andrzej Sapkowski", 2008, false),
                new Book("The Handmaid's tale", "Margaret Atwood", 1986, false)
        );
    }
}
