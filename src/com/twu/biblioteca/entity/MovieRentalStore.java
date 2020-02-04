package com.twu.biblioteca.entity;

import java.util.List;

public class MovieRentalStore extends Store {
    public MovieRentalStore(List<Product> productList) {
        super(productList);
    }

    public boolean isMovieAvailable(String title) {
        return productList.stream().anyMatch(movie -> movie.getTitle().equalsIgnoreCase(title) && !movie.isCheckedOut());
    }

    public void checkoutMovie(String title) {
        productList.stream()
                .filter(movie -> movie.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .ifPresent(movie -> movie.setCheckedOut(true));
    }
}
