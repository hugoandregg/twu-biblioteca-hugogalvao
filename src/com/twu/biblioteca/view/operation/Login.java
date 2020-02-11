package com.twu.biblioteca.view.operation;

import com.twu.biblioteca.controller.UserController;
import com.twu.biblioteca.entity.user.Costumer;
import com.twu.biblioteca.entity.user.Librarian;
import com.twu.biblioteca.entity.user.User;
import com.twu.biblioteca.exception.InvalidLibraryNumber;
import com.twu.biblioteca.exception.InvalidPassword;
import com.twu.biblioteca.view.CustomerView;
import com.twu.biblioteca.view.LibrarianView;

import java.util.Scanner;

public class Login implements Operation {

    private Scanner in;

    private UserController userController;

    private CustomerView customerView;

    private LibrarianView librarianView;

    public Login(Scanner in, UserController userController, CustomerView customerView, LibrarianView librarianView) {
        this.in = in;
        this.userController = userController;
        this.customerView = customerView;
        this.librarianView = librarianView;
    }

    @Override
    public void execute() {
        System.out.println("Library Number:");
        in.nextLine();
        String libraryNumber = in.nextLine();
        System.out.println("Password:");
        String password = in.nextLine();
        login(libraryNumber, password);
    }

    private void login(String libraryNumber, String password) {
        User user = null;
        try {
            user = userController.login(libraryNumber, password);
        } catch (InvalidLibraryNumber | InvalidPassword e) {
            System.out.println(e.getMessage());
        }
        redirect(user);
    }

    private void redirect(User user) {
        if (user instanceof Costumer) {
            customerView.displayInteractiveMenu(user);
        } else if (user instanceof Librarian) {
            librarianView.displayInteractiveMenu();
        } else {
            System.out.println("Try Again!");
            execute();
        }
    }
}
