package com.twu.biblioteca.view;

import com.twu.biblioteca.entity.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WelcomeView {

    private List<Book> booksList = new ArrayList<Book>() {{
        add(new Book("Harry Potter and the Sorcerer's stone", "J.K. Rowling", 2015));
        add(new Book("The Last Wish: Introducing the Witcher", "Andrzej Sapkowski", 2008));
        add(new Book("The Handmaid's tale", "Margaret Atwood", 1986));
    }};

    public void run() {
        System.out.println(welcomeMessage());
        System.out.println(listBooks());
    }

    public String welcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!";
    }

    public String listBooks() {
        StringBuilder booksListStr = new StringBuilder();
        for (Book book : booksList) {
            booksListStr.append(book.toString());
            booksListStr.append(System.getProperty("line.separator"));
        }
        return booksListStr.toString();
    }
}
