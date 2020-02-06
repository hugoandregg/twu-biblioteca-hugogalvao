package com.twu.biblioteca.controller;

import com.twu.biblioteca.constants.Messages;
import com.twu.biblioteca.entity.user.Costumer;
import com.twu.biblioteca.entity.product.Movie;
import com.twu.biblioteca.service.MovieRentalStoreService;
import com.twu.biblioteca.entity.product.Product;
import com.twu.biblioteca.exception.MovieIsNotAvailableException;
import com.twu.biblioteca.repository.MovieRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MovieRentalStoreController {

    private MovieRentalStoreService movieRentalStoreService = new MovieRentalStoreService(MovieRepository.getMovies());

    public List<Product> getMoviesList() {
        return movieRentalStoreService.getProductList()
                .stream()
                .filter(movie -> !movie.isCheckedOut())
                .collect(Collectors.toList());
    }

    public List<Product> getCheckedOutMovies() {
        return movieRentalStoreService.getProductList()
                .stream()
                .filter(movie -> movie.isCheckedOut())
                .collect(Collectors.toList());
    }

    public String checkoutMovieFromRentalStore(String movie, Costumer costumer) {
        if (movieRentalStoreService.isMovieAvailable(movie)) {
            movieRentalStoreService.checkoutMovie(movie, costumer);
            return Messages.CHECKOUT_AVAILABLE_MOVIE_MESSAGE;
        }
        throw new MovieIsNotAvailableException(Messages.CHECKOUT_UNAVAILABLE_MOVIE_MESSAGE);
    }

    public Movie getMovie(String title) {
        return (Movie) movieRentalStoreService.getProductByTitle(title);
    }
}
