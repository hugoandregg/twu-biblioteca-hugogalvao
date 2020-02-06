package com.twu.biblioteca.entity.product;

public class Movie extends Product {

    private RatingEnum rating;

    public Movie(String title, String creator, int year, boolean checkedOut, RatingEnum rating) {
        super(title, year, creator, checkedOut);
        this.rating = rating;
    }

    @Override
    public String toString() {
        return title + " | " + year + " | " + creator + " | " + rating.ordinal();
    }
}
