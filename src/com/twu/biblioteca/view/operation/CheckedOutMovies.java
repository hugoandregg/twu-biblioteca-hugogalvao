package com.twu.biblioteca.view.operation;

import com.twu.biblioteca.constants.Messages;
import com.twu.biblioteca.controller.MovieRentalStoreController;
import com.twu.biblioteca.entity.product.Product;

import java.util.List;

public class CheckedOutMovies implements Operation {

    private MovieRentalStoreController movieRentalStoreController;

    public CheckedOutMovies(MovieRentalStoreController movieRentalStoreController) {
        this.movieRentalStoreController = movieRentalStoreController;
    }

    @Override
    public void execute() {
        List<Product> checkedOutMovies = movieRentalStoreController.getCheckedOutMovies();
        if (checkedOutMovies.isEmpty()) {
            System.out.println(Messages.EMPTY_PRODUCT_LIST);
        } else {
            checkedOutMovies.forEach(movie ->
                    System.out.println(movie.getTitle() + " -> " + movie.getCheckedOutCostumer().getName()));
        }
    }
}
