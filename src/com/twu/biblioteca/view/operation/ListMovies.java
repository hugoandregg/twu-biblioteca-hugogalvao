package com.twu.biblioteca.view.operation;

import com.twu.biblioteca.controller.MovieRentalStoreController;

public class ListMovies implements Operation {

    private MovieRentalStoreController movieRentalStoreController;

    public ListMovies(MovieRentalStoreController movieRentalStoreController) {
        this.movieRentalStoreController = movieRentalStoreController;
    }

    @Override
    public void execute() {
        movieRentalStoreController.getMoviesList().forEach(System.out::println);
    }
}
