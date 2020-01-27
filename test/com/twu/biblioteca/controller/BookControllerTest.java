package com.twu.biblioteca.controller;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.exception.BookIsNotAvailableException;
import com.twu.biblioteca.exception.NotValidBookToReturn;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookControllerTest {

    private BookController bookController;

    private final List<Book> LIST_OF_BOOKS = new ArrayList<Book>() {{
        add(new Book("Harry Potter and the Sorcerer's stone", "J.K. Rowling", 2015, false));
        add(new Book("The Last Wish: Introducing the Witcher", "Andrzej Sapkowski", 2008, false));
        add(new Book("The Handmaid's tale", "Margaret Atwood", 1986, false));
    }};

    private final List<Book> LIST_OF_BOOKS_WITHOUT_THE_WITCHER = new ArrayList<Book>() {{
        add(new Book("Harry Potter and the Sorcerer's stone", "J.K. Rowling", 2015, false));
        add(new Book("The Handmaid's tale", "Margaret Atwood", 1986, false));
    }};

    @Before
    public void setUp() {
        bookController = new BookController();
    }

    @Test
    public void checkoutAvailableBook(){
        String expected = "Thank you! Enjoy the book";
        assertThat(bookController.checkoutBookFromLibrary("The Last Wish: Introducing the Witcher"), is(expected));
        assertBookListIsTheSame(bookController.getBooksList(), LIST_OF_BOOKS_WITHOUT_THE_WITCHER);
    }

    @Test(expected = BookIsNotAvailableException.class)
    public void checkoutWrongTitleBook() {
        bookController.checkoutBookFromLibrary("Happy Potter and the Sorcerer's stone");
        assertBookListIsTheSame(bookController.getBooksList(), LIST_OF_BOOKS);
    }

    @Test(expected = BookIsNotAvailableException.class)
    public void checkoutUnavailableBook() {
        checkoutAvailableBook();
        bookController.checkoutBookFromLibrary("The Last Wish: Introducing the Witcher");
        assertBookListIsTheSame(bookController.getBooksList(), LIST_OF_BOOKS_WITHOUT_THE_WITCHER);
    }

    @Test
    public void returnABookFromLibrary() {
        checkoutAvailableBook();
        String expected = "Thank you for returning the book";
        assertThat(bookController.returnBookToLibrary("The Last Wish: Introducing the Witcher"), is(expected));
        assertBookListIsTheSame(bookController.getBooksList(), LIST_OF_BOOKS);
    }

    @Test(expected = NotValidBookToReturn.class)
    public void returnABookAvailableOnLibrary() {
        bookController.returnBookToLibrary("Harry Potter and the Sorcerer's stone");
        assertBookListIsTheSame(bookController.getBooksList(), LIST_OF_BOOKS);
    }

    @Test(expected = NotValidBookToReturn.class)
    public void returnABookWithWrongTitle() {
        bookController.returnBookToLibrary("Happy Potter and the Sorcerer's stone");
        assertBookListIsTheSame(bookController.getBooksList(), LIST_OF_BOOKS);
    }

    private void assertBookListIsTheSame(List<Book> actualList, List<Book> expectedList) {
        assertThat(actualList.size() == expectedList.size() &&
                actualList.containsAll(expectedList) && expectedList.containsAll(actualList), is(true));
    }
}
