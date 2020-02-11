package com.twu.biblioteca.view;

import com.twu.biblioteca.constants.Operations;
import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.controller.MovieRentalStoreController;
import com.twu.biblioteca.entity.user.Costumer;
import com.twu.biblioteca.entity.user.User;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.service.LibraryService;
import com.twu.biblioteca.service.MovieRentalStoreService;
import com.twu.biblioteca.view.operation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerView {

    private Scanner in = new Scanner(System.in);

    private LibraryController libraryController =
            new LibraryController(new LibraryService(BookRepository.getInstance().getBooks()));

    private MovieRentalStoreController movieRentalStoreController =
            new MovieRentalStoreController(new MovieRentalStoreService(MovieRepository.getInstance().getMovies()));

    private Costumer costumer;

    private Map<Integer, Operation> operationMap = new HashMap<>();

    private void fillOperations() {
        operationMap.put(Operations.QUIT, new Quit());
        operationMap.put(Operations.LIST_BOOKS, new ListBooks(libraryController));
        operationMap.put(Operations.LIST_MOVIES, new ListMovies(movieRentalStoreController));
        operationMap.put(Operations.CHECKOUT_BOOK, new CheckoutBook(in, costumer, libraryController));
        operationMap.put(Operations.RETURN_BOOK, new ReturnBook(in, libraryController, costumer));
        operationMap.put(Operations.CHECKOUT_MOVIE, new CheckoutMovie(in, movieRentalStoreController, costumer));
        operationMap.put(Operations.MY_INFORMATION, new MyInformation(costumer));
    }

    public void displayInteractiveMenu(User user) {
        costumer = (Costumer) user;
        fillOperations();
        MenuView.display(getMenu(), in, operationMap);
    }

    private String getMenu() {
        return  "1 - List available books\n" +
                "2 - List available movies\n" +
                "3 - Checkout a book\n" +
                "4 - Return a book\n" +
                "5 - Checkout a movie\n" +
                "6 - Show my information\n" +
                "0 - Return to previous menu";
    }
}
