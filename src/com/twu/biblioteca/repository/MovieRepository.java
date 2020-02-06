package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.product.Movie;
import com.twu.biblioteca.entity.product.Product;
import com.twu.biblioteca.entity.product.RatingEnum;

import java.util.Arrays;
import java.util.List;

public class MovieRepository {
    public static List<Product> getMovies() {
        return Arrays.asList(
                new Movie("Looking for Dory", "Walt Disney", 2015, false, RatingEnum.EIGHT),
                new Movie("Where is Nemo?", "Walt Disney", 2008, false, RatingEnum.TEN),
                new Movie("Lion King", "Walt Disney", 1986, false, RatingEnum.NINE)
        );
    }
}
