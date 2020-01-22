package com.twu.biblioteca.controller;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookControllerTest {

    private BookController bookController;

    private final String LIST_OF_BOOKS = "Harry Potter and the Sorcerer's stone | J.K. Rowling | 2015\n" +
            "The Last Wish: Introducing the Witcher | Andrzej Sapkowski | 2008\n" +
            "The Handmaid's tale | Margaret Atwood | 1986\n";

    @Before
    public void setUp() {
        bookController = new BookController();
    }

    @Test
    public void listBooksTest() {
        assertThat(bookController.listBooks(), is(LIST_OF_BOOKS));
    }

    @Test
    public void checkoutAvailableBook(){
        String expected = "Thank you! Enjoy the book";
        assertThat(bookController.checkoutBook("The Last Wish: Introducing the Witcher"), is(expected));
    }

    @Test
    public void checkoutWrongTitleBook() {
        String expected = "Sorry that book is not available";
        assertThat(bookController.checkoutBook("Happy Potter and the Sorcerer's stone"), is(expected));
    }

    @Test
    public void checkoutUnavailableBook() {
        String expected = "Thank you! Enjoy the book";
        assertThat(bookController.checkoutBook("The Last Wish: Introducing the Witcher"), is(expected));
        expected = "Sorry that book is not available";
        assertThat(bookController.checkoutBook("The Last Wish: Introducing the Witcher"), is(expected));
    }
}
