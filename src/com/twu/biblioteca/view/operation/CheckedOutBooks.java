package com.twu.biblioteca.view.operation;

import com.twu.biblioteca.constants.Messages;
import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.entity.product.Product;

import java.util.List;

public class CheckedOutBooks implements Operation {

    private LibraryController libraryController;

    public CheckedOutBooks(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    @Override
    public void execute() {
        List<Product> checkedOutBooks = libraryController.getCheckedOutBooks();
        if (checkedOutBooks.isEmpty()) {
            System.out.println(Messages.EMPTY_PRODUCT_LIST);
        } else {
            checkedOutBooks.forEach(book ->
                    System.out.println(book.getTitle() + " -> " + book.getCheckedOutCostumer().getName()));
        }
    }
}
