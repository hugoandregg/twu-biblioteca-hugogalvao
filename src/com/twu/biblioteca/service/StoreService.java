package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.product.Product;

import java.util.List;

public abstract class StoreService {

    protected List<Product> productList;

    public StoreService(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product getProductByTitle(String title) {
        return productList.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .get();
    }
}
