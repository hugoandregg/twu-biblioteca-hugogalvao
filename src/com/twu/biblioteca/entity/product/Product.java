package com.twu.biblioteca.entity.product;

import com.twu.biblioteca.entity.user.Costumer;

import java.util.Objects;

public abstract class Product {

    protected String title;

    protected int year;

    protected String creator;

    protected boolean checkedOut;

    protected Costumer checkedOutCostumer;

    public Product(String title, int year, String creator, boolean checkedOut) {
        this.title = title;
        this.year = year;
        this.creator = creator;
        this.checkedOut = checkedOut;
        this.checkedOutCostumer = null;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public void setCheckedOutCostumer(Costumer checkedOutCostumer) {
        this.checkedOutCostumer = checkedOutCostumer;
    }

    public Costumer getCheckedOutCostumer() {
        return checkedOutCostumer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return year == product.year &&
                checkedOut == product.checkedOut &&
                Objects.equals(title, product.title) &&
                Objects.equals(creator, product.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, creator, checkedOut);
    }
}
