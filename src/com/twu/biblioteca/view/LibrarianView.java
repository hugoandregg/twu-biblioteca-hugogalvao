package com.twu.biblioteca.view;

import com.twu.biblioteca.constants.Operations;
import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.controller.MovieRentalStoreController;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.service.LibraryService;
import com.twu.biblioteca.service.MovieRentalStoreService;
import com.twu.biblioteca.view.operation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibrarianView {

    private Scanner in = new Scanner(System.in);

    private LibraryController libraryController =
            new LibraryController(new LibraryService(BookRepository.getInstance().getBooks()));

    private MovieRentalStoreController movieRentalStoreController =
            new MovieRentalStoreController(new MovieRentalStoreService(MovieRepository.getInstance().getMovies()));

    private Map<Integer, Operation> operationMap = new HashMap<>();

    private void fillOperations() {
        operationMap.put(Operations.QUIT, new Quit());
        operationMap.put(Operations.LIST_BOOKS, new ListBooks(libraryController));
        operationMap.put(Operations.LIST_MOVIES, new ListMovies(movieRentalStoreController));
        operationMap.put(Operations.CHECKED_OUT_BOOKS, new CheckedOutBooks(libraryController));
        operationMap.put(Operations.CHECKED_OUT_MOVIES, new CheckedOutMovies(movieRentalStoreController));
    }

    public void displayInteractiveMenu() {
        fillOperations();
        MenuView.display(getMenu(), in, operationMap);
    }

    public String getMenu() {
        return  "1 - List available books\n" +
                "2 - List available movies\n" +
                "3 - List checked out books\n" +
                "4 - List checked out movies\n" +
                "0 - Return to previous menu";
    }
}
