package com.twu.biblioteca.view;

import com.twu.biblioteca.constants.Messages;
import com.twu.biblioteca.constants.Operation;
import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.controller.MovieRentalStoreController;
import com.twu.biblioteca.entity.Product;
import com.twu.biblioteca.entity.User;

import java.util.List;
import java.util.Scanner;

public class LibrarianView {

    private Scanner in = new Scanner(System.in);

    private LibraryController libraryController;

    private MovieRentalStoreController movieRentalStoreController;

    public LibrarianView(LibraryController libraryController, MovieRentalStoreController movieRentalStoreController) {
        this.libraryController = libraryController;
        this.movieRentalStoreController = movieRentalStoreController;
    }

    public void displayInteractiveMenu(User user) {
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
            } else if (Operation.CHECKED_OUT_BOOKS == operation) {
                checkedOutBooks();
            } else if (Operation.CHECKED_OUT_MOVIES == operation) {
                checkedOutMovies();
            } else {
                System.out.println(Messages.INVALID_OPTION_MESSAGE);
            }
        }
    }

    public String displayMenu() {
        String menu = "1 - List available books\n" +
                "2 - List available movies\n" +
                "3 - List checked out books\n" +
                "4 - List checked out movies\n" +
                "0 - Return to previous menu";
        return menu;
    }

    public void listBooks() {
        libraryController.getBooksList().forEach(System.out::println);
    }

    public void listMovies() {
        movieRentalStoreController.getMoviesList().forEach(System.out::println);
    }

    private void checkedOutBooks() {
        List<Product> checkedOutBooks = libraryController.getCheckedOutBooks();
        if (checkedOutBooks.isEmpty()) {
            System.out.println(Messages.EMPTY_PRODUCT_LIST);
        } else {
            checkedOutBooks.forEach(book ->
                    System.out.println(book.getTitle() + " -> " + book.getCheckedOutCostumer().getName()));
        }
    }

    private void checkedOutMovies() {
        List<Product> checkedOutMovies = movieRentalStoreController.getCheckedOutMovies();
        if (checkedOutMovies.isEmpty()) {
            System.out.println(Messages.EMPTY_PRODUCT_LIST);
        } else {
            checkedOutMovies.forEach(movie ->
                    System.out.println(movie.getTitle() + " -> " + movie.getCheckedOutCostumer().getName()));
        }
    }
}
