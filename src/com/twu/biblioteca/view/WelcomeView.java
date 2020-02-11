package com.twu.biblioteca.view;

import com.twu.biblioteca.constants.Messages;
import com.twu.biblioteca.constants.Operations;
import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.controller.MovieRentalStoreController;
import com.twu.biblioteca.controller.UserController;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.service.LibraryService;
import com.twu.biblioteca.service.MovieRentalStoreService;
import com.twu.biblioteca.view.operation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WelcomeView {

    private Scanner in = new Scanner(System.in);

    private LibraryController libraryController =
            new LibraryController(new LibraryService(BookRepository.getInstance().getBooks()));

    private MovieRentalStoreController movieRentalStoreController =
            new MovieRentalStoreController(new MovieRentalStoreService(MovieRepository.getInstance().getMovies()));

    private UserController userController = new UserController();

    private CustomerView customerView = new CustomerView();

    private LibrarianView librarianView = new LibrarianView();

    private Map<Integer, Operation> operationMap = new HashMap<>();

    private void fillOperations() {
        operationMap.put(Operations.QUIT, new Quit());
        operationMap.put(Operations.LIST_BOOKS, new ListBooks(libraryController));
        operationMap.put(Operations.LIST_MOVIES, new ListMovies(movieRentalStoreController));
        operationMap.put(Operations.LOGIN, new Login(in, userController, customerView, librarianView));
    }

    public void run() {
        System.out.println(Messages.WELCOME_MESSAGE);
        displayInteractiveMenu();
    }

    public void displayInteractiveMenu() {
        fillOperations();
        MenuView.display(getMenu(), in, operationMap);
    }

    public String getMenu() {
        return  "1 - List available books\n" +
                "2 - List available movies\n" +
                "3 - Login\n" +
                "0 - Quit";
    }
}
