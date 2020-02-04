package com.twu.biblioteca.controller;

import com.twu.biblioteca.constants.Messages;
import com.twu.biblioteca.entity.MovieRentalStore;
import com.twu.biblioteca.entity.Product;
import com.twu.biblioteca.exception.MovieIsNotAvailableException;
import com.twu.biblioteca.repository.MovieRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MovieRentalStoreController {

    private MovieRentalStore movieRentalStore = new MovieRentalStore(MovieRepository.getMovies());

    public List<Product> getMoviesList() {
        return movieRentalStore.getProductList()
                .stream()
                .filter(movie -> !movie.isCheckedOut())
                .collect(Collectors.toList());
    }

    public String checkoutMovieFromRentalStore(String movie) {
        if (movieRentalStore.isMovieAvailable(movie)) {
            movieRentalStore.checkoutMovie(movie);
            return Messages.CHECKOUT_AVAILABLE_MOVIE_MESSAGE;
        }
        throw new MovieIsNotAvailableException(Messages.CHECKOUT_UNAVAILABLE_MOVIE_MESSAGE);
    }
}
