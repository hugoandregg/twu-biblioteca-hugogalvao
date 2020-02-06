package com.twu.biblioteca.view;

import com.twu.biblioteca.constants.Messages;
import com.twu.biblioteca.constants.Operation;
import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.controller.MovieRentalStoreController;
import com.twu.biblioteca.controller.UserController;
import com.twu.biblioteca.entity.user.Costumer;
import com.twu.biblioteca.entity.user.Librarian;
import com.twu.biblioteca.entity.user.User;
import com.twu.biblioteca.exception.*;

import java.util.Scanner;

public class WelcomeView {

    private Scanner in = new Scanner(System.in);

    private LibraryController libraryController = new LibraryController();

    private MovieRentalStoreController movieRentalStoreController = new MovieRentalStoreController();

    private UserController userController = new UserController();

    private CustomerView customerView = new CustomerView(libraryController, movieRentalStoreController);

    private LibrarianView librarianView = new LibrarianView(libraryController, movieRentalStoreController);

    public void run() {
        System.out.println(Messages.WELCOME_MESSAGE);
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
                listBooks();
            } else if (Operation.LIST_MOVIES == operation) {
                listMovies();
            } else if (Operation.LOGIN == operation) {
                getCredentials();
            } else {
                System.out.println(Messages.INVALID_OPTION_MESSAGE);
            }
        }
    }

    public String displayMenu() {
        String menu = "1 - List available books\n" +
                "2 - List available movies\n" +
                "3 - Login\n" +
                "0 - Quit";
        return menu;
    }

    private void getCredentials() {
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
            librarianView.displayInteractiveMenu(user);
        } else {
            System.out.println("Try Again!");
            getCredentials();
        }
    }

    public void listBooks() {
        libraryController.getBooksList().forEach(System.out::println);
    }

    public void listMovies() {
        movieRentalStoreController.getMoviesList().forEach(System.out::println);
    }
}
