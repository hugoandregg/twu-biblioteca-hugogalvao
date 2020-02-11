package com.twu.biblioteca.view.operation;

import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.entity.user.Costumer;
import com.twu.biblioteca.exception.BookIsNotAvailableException;

import java.util.Scanner;

public class CheckoutBook implements Operation {

    private Scanner in;

    private Costumer costumer;

    private LibraryController libraryController;

    public CheckoutBook(Scanner in, Costumer costumer, LibraryController libraryController) {
        this.in = in;
        this.costumer = costumer;
        this.libraryController = libraryController;
    }

    @Override
    public void execute() {
        try {
            System.out.println("What book do you want to checkout? ");
            in.nextLine(); //if this line isn't here, the scanner will get a blank line
            String title = in.nextLine();
            System.out.println(libraryController.checkoutBookFromLibrary(title, costumer));
        } catch (BookIsNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
