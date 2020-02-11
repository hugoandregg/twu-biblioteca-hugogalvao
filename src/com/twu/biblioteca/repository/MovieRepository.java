package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.product.Movie;
import com.twu.biblioteca.entity.product.Product;
import com.twu.biblioteca.entity.product.RatingEnum;

import java.util.Arrays;
import java.util.List;

public class MovieRepository {

    private static MovieRepository movieRepository;

    private List<Product> movieList = Arrays.asList(
            new Movie("Looking for Dory", "Walt Disney", 2015, false, RatingEnum.EIGHT),
            new Movie("Where is Nemo?", "Walt Disney", 2008, false, RatingEnum.TEN),
            new Movie("Lion King", "Walt Disney", 1986, false, RatingEnum.NINE)
    );

    private MovieRepository() {
    }

    public static MovieRepository getInstance() {
        if (movieRepository == null) {
            movieRepository = new MovieRepository();
        }
        return movieRepository;
    }

    public List<Product> getMovies() {
        return movieList;
    }
}
