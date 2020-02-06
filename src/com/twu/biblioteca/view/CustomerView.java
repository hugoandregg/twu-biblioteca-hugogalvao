package com.twu.biblioteca.view;

import com.twu.biblioteca.constants.Messages;
import com.twu.biblioteca.constants.Operation;
import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.controller.MovieRentalStoreController;
import com.twu.biblioteca.entity.user.Costumer;
import com.twu.biblioteca.entity.user.User;
import com.twu.biblioteca.exception.BookIsNotAvailableException;
import com.twu.biblioteca.exception.MovieIsNotAvailableException;
import com.twu.biblioteca.exception.NotValidBookToReturn;

import java.util.Scanner;

public class CustomerView {

    private Scanner in = new Scanner(System.in);

    private LibraryController libraryController;

    private MovieRentalStoreController movieRentalStoreController;

    private Costumer costumer;

    public CustomerView(LibraryController libraryController, MovieRentalStoreController movieRentalStoreController) {
        this.libraryController = libraryController;
        this.movieRentalStoreController = movieRentalStoreController;
    }

    public void displayInteractiveMenu(User user) {
        costumer = (Costumer) user;
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
            } else if (Operation.CHECKOUT_BOOK == operation) {
                checkoutBook();
            } else if (Operation.RETURN_BOOK == operation) {
                returnBook();
            } else if (Operation.CHECKOUT_MOVIE == operation) {
                checkoutMovie();
            } else if (Operation.MY_INFORMATION == operation) {
                myInformation();
            } else {
                System.out.println(Messages.INVALID_OPTION_MESSAGE);
            }
        }
    }

    private String displayMenu() {
        String menu = "1 - List available books\n" +
                "2 - List available movies\n" +
                "3 - Checkout a book\n" +
                "4 - Return a book\n" +
                "5 - Checkout a movie\n" +
                "6 - Show my information\n" +
                "0 - Return to previous menu";
        return menu;
    }

    public void listBooks() {
        libraryController.getBooksList().forEach(System.out::println);
    }

    public void listMovies() {
        movieRentalStoreController.getMoviesList().forEach(System.out::println);
    }

    private void checkoutBook() {
        try {
            System.out.println("What book do you want to checkout? ");
            in.nextLine(); //if this line isn't here, the scanner will get a blank line
            String title = in.nextLine();
            System.out.println(libraryController.checkoutBookFromLibrary(title, costumer));
        } catch (BookIsNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }

    private void returnBook() {
        try {
            System.out.println("What book do you want to return? ");
            in.nextLine(); //if this line isn't here, the scanner will get a blank line
            String title = in.nextLine();
            System.out.println(libraryController.returnBookToLibrary(title, costumer));
        } catch (NotValidBookToReturn e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkoutMovie() {
        try {
            System.out.println("What movie do you want to checkout? ");
            in.nextLine(); //if this line isn't here, the scanner will get a blank line
            String title = in.nextLine();
            System.out.println(movieRentalStoreController.checkoutMovieFromRentalStore(title, costumer));
        } catch (MovieIsNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }

    private void myInformation() {
        System.out.println(costumer);
    }
}
