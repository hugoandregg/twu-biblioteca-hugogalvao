package com.twu.biblioteca.view;

import com.twu.biblioteca.constants.Messages;
import com.twu.biblioteca.constants.Operation;
import com.twu.biblioteca.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WelcomeView {

    private Scanner in = new Scanner(System.in);

    private List<Book> booksList = new ArrayList<Book>() {{
        add(new Book("Harry Potter and the Sorcerer's stone", "J.K. Rowling", 2015));
        add(new Book("The Last Wish: Introducing the Witcher", "Andrzej Sapkowski", 2008));
        add(new Book("The Handmaid's tale", "Margaret Atwood", 1986));
    }};

    public void run() {
        System.out.println(welcomeMessage());
        displayInteractiveMenu();
    }

    public void displayInteractiveMenu() {
        while (true) {
            System.out.println(displayMenu());
            System.out.println(Messages.SELECT_OPERATION_MESSAGE);
            int operation = in.nextInt();
            if (Operation.QUIT == operation) {
                return;
            } else if (Operation.LIST_BOOKS == operation) {
                System.out.println(listBooks());
            } else {
                System.out.println(Messages.INVALID_OPTION_MESSAGE);
            }
        }

    }

    public String displayMenu() {
        String menu = "1 - List all books\n" +
                "0 - Quit";
        return menu;
    }

    public String welcomeMessage() {
        return Messages.WELCOME_MESSAGE;
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
