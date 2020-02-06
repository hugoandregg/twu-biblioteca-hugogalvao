package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.user.Costumer;
import com.twu.biblioteca.entity.product.Product;

import java.util.List;

public class LibraryService extends StoreService {

    public LibraryService(List<Product> bookList) {
        super(bookList);
    }

    public boolean isABookFromLibrary(String title) {
        return productList.stream().anyMatch(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public boolean isBookAvailable(String title) {
        return productList.stream().anyMatch(book -> book.getTitle().equalsIgnoreCase(title) && !book.isCheckedOut());
    }

    public boolean isBookCheckedOutByCostumer(String title, Costumer costumer) {
        return productList.stream()
                .anyMatch(book -> book.getTitle().equalsIgnoreCase(title)
                        && costumer.equals(book.getCheckedOutCostumer()));
    }

    public void checkoutBook(String title, Costumer costumer) {
        productList.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .ifPresent(book ->  {
                    book.setCheckedOut(true);
                    book.setCheckedOutCostumer(costumer);
                });
    }

    public void returnBook(String title) {
        productList.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .ifPresent(book -> {
                    book.setCheckedOut(false);
                    book.setCheckedOutCostumer(null);
                });
    }
}
