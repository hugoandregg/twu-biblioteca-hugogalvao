package com.twu.biblioteca.view.operation;

import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.entity.user.Costumer;
import com.twu.biblioteca.exception.NotValidBookToReturn;

import java.util.Scanner;

public class ReturnBook implements Operation {

    private Scanner in;

    private LibraryController libraryController;

    private Costumer costumer;

    public ReturnBook(Scanner in, LibraryController libraryController, Costumer costumer) {
        this.in = in;
        this.libraryController = libraryController;
        this.costumer = costumer;
    }

    @Override
    public void execute() {
        try {
            System.out.println("What book do you want to return? ");
            in.nextLine(); //if this line isn't here, the scanner will get a blank line
            String title = in.nextLine();
            System.out.println(libraryController.returnBookToLibrary(title, costumer));
        } catch (NotValidBookToReturn e) {
            System.out.println(e.getMessage());
        }
    }
}
