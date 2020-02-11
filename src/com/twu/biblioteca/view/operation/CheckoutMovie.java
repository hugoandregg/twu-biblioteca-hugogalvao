package com.twu.biblioteca.view.operation;

import com.twu.biblioteca.controller.MovieRentalStoreController;
import com.twu.biblioteca.entity.user.Costumer;
import com.twu.biblioteca.exception.MovieIsNotAvailableException;

import java.util.Scanner;

public class CheckoutMovie implements Operation {

    private Scanner in;

    private MovieRentalStoreController movieRentalStoreController;

    private Costumer costumer;

    public CheckoutMovie(Scanner in, MovieRentalStoreController movieRentalStoreController, Costumer costumer) {
        this.in = in;
        this.movieRentalStoreController = movieRentalStoreController;
        this.costumer = costumer;
    }

    @Override
    public void execute() {
        try {
            System.out.println("What movie do you want to checkout? ");
            in.nextLine(); //if this line isn't here, the scanner will get a blank line
            String title = in.nextLine();
            System.out.println(movieRentalStoreController.checkoutMovieFromRentalStore(title, costumer));
        } catch (MovieIsNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
