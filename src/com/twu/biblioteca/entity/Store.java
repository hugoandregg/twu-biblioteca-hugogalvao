package com.twu.biblioteca.entity;

import java.util.List;

public abstract class Store {

    protected List<Product> productList;

    public Store(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }
}
