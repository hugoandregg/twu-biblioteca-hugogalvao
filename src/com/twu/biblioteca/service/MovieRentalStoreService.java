package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.user.Costumer;
import com.twu.biblioteca.entity.product.Product;

import java.util.List;

public class MovieRentalStoreService extends StoreService {
    public MovieRentalStoreService(List<Product> productList) {
        super(productList);
    }

    public boolean isMovieAvailable(String title) {
        return productList.stream().anyMatch(movie -> movie.getTitle().equalsIgnoreCase(title) && !movie.isCheckedOut());
    }

    public void checkoutMovie(String title, Costumer costumer) {
        productList.stream()
                .filter(movie -> movie.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .ifPresent(movie -> {
                    movie.setCheckedOut(true);
                    movie.setCheckedOutCostumer(costumer);
                });
    }
}
