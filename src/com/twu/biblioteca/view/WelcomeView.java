package com.twu.biblioteca.view;

import com.twu.biblioteca.constants.Messages;
import com.twu.biblioteca.constants.Operation;
import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.controller.MovieRentalStoreController;
import com.twu.biblioteca.exception.BookIsNotAvailableException;
import com.twu.biblioteca.exception.MovieIsNotAvailableException;
import com.twu.biblioteca.exception.NotValidBookToReturn;

import java.util.Scanner;

public class WelcomeView {

    private Scanner in = new Scanner(System.in);

    private LibraryController libraryController = new LibraryController();

    private MovieRentalStoreController movieRentalStoreController = new MovieRentalStoreController();

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
            } else if (Operation.CHECKOUT_BOOK == operation) {
                checkoutBook();
            } else if (Operation.RETURN_BOOK == operation) {
                returnBook();
            } else if (Operation.LIST_MOVIES == operation) {
                listMovies();
            } else if (Operation.CHECKOUT_MOVIE == operation) {
                checkoutMovie();
            } else {
                System.out.println(Messages.INVALID_OPTION_MESSAGE);
            }
        }
    }

    private void returnBook() {
        try {
            System.out.println("What book do you want to return? ");
            in.nextLine(); //if this line isn't here, the scanner will get a blank line
            String title = in.nextLine();
            System.out.println(libraryController.returnBookToLibrary(title));
        } catch (NotValidBookToReturn e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkoutBook() {
        try {
            System.out.println("What book do you want to checkout? ");
            in.nextLine(); //if this line isn't here, the scanner will get a blank line
            String title = in.nextLine();
            System.out.println(libraryController.checkoutBookFromLibrary(title));
        } catch (BookIsNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }

    private void listBooks() {
        libraryController.getBooksList().forEach(System.out::println);
    }

    private void listMovies() {
        movieRentalStoreController.getMoviesList().forEach(System.out::println);
    }

    private void checkoutMovie() {
        try {
            System.out.println("What movie do you want to checkout? ");
            in.nextLine(); //if this line isn't here, the scanner will get a blank line
            String title = in.nextLine();
            System.out.println(movieRentalStoreController.checkoutMovieFromRentalStore(title));
        } catch (MovieIsNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }

    public String displayMenu() {
        String menu = "1 - List all books\n" +
                "2 - Checkout a book\n" +
                "3 - Return a book\n" +
                "4 - List all movies\n" +
                "5 - Checkout a movie\n" +
                "0 - Quit";
        return menu;
    }
}
