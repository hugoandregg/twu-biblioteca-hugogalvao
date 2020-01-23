package com.twu.biblioteca.view;

import com.twu.biblioteca.constants.Messages;
import com.twu.biblioteca.constants.Operation;
import com.twu.biblioteca.controller.BookController;

import java.util.Scanner;

public class WelcomeView {

    private Scanner in = new Scanner(System.in);

    private BookController bookController = new BookController();

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
                System.out.println(bookController.listBooks());
            } else if (Operation.CHECKOUT_BOOK == operation) {
                System.out.println("What book do you want to checkout? ");
                in.nextLine(); //if this line isn't here, the scanner will get a blank line
                String title = in.nextLine();
                System.out.println(bookController.checkoutBook(title));
            } else if (Operation.RETURN_BOOK == operation) {
                System.out.println("What book do you want to return? ");
                in.nextLine(); //if this line isn't here, the scanner will get a blank line
                String title = in.nextLine();
                System.out.println(bookController.returnBook(title));
            } else {
                System.out.println(Messages.INVALID_OPTION_MESSAGE);
            }
        }
    }

    public String displayMenu() {
        String menu = "1 - List all books\n" +
                "2 - Checkout a book\n" +
                "3 - Return a book\n" +
                "0 - Quit";
        return menu;
    }

    public String welcomeMessage() {
        return Messages.WELCOME_MESSAGE;
    }
}
