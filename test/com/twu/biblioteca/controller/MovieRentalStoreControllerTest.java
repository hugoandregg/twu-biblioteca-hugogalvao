package com.twu.biblioteca.controller;

import com.twu.biblioteca.entity.Costumer;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.entity.Product;
import com.twu.biblioteca.entity.RatingEnum;
import com.twu.biblioteca.exception.MovieIsNotAvailableException;
import com.twu.biblioteca.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class MovieRentalStoreControllerTest {

    private MovieRentalStoreController movieRentalStoreController;

    private final Costumer COSTUMER = (Costumer) UserRepository.getUserByLibraryNumber("456-4567");

    private List<Product> LIST_OF_MOVIES = new ArrayList<Product>() {{
        add(new Movie("Looking for Dory", "Walt Disney", 2015, false, RatingEnum.EIGHT));
        add(new Movie("Where is Nemo?", "Walt Disney", 2008, false, RatingEnum.TEN));
        add(new Movie("Lion King", "Walt Disney", 1986, false, RatingEnum.NINE));
    }};

    private List<Product> LIST_OF_MOVIES_WITHOUT_LION_KING = new ArrayList<Product>() {{
        add(new Movie("Looking for Dory", "Walt Disney", 2015, false, RatingEnum.EIGHT));
        add(new Movie("Where is Nemo?", "Walt Disney", 2008, false, RatingEnum.TEN));
    }};

    @Before
    public void setUp() {
        movieRentalStoreController = new MovieRentalStoreController();
    }

    @Test
    public void checkoutAvailableMovie() {
        String expected = "Thank you! Enjoy the movie";
        assertThat(movieRentalStoreController.checkoutMovieFromRentalStore("Lion King", COSTUMER), is(expected));
        assertMovieListIsTheSame(movieRentalStoreController.getMoviesList(), LIST_OF_MOVIES_WITHOUT_LION_KING);
        assertThat(movieRentalStoreController.getMovie("Lion King").getCheckedOutCostumer(), is(COSTUMER));
    }

    @Test(expected = MovieIsNotAvailableException.class)
    public void checkoutWrongTitleMovie() {
        movieRentalStoreController.checkoutMovieFromRentalStore("Limon King", COSTUMER);
        assertMovieListIsTheSame(movieRentalStoreController.getMoviesList(), LIST_OF_MOVIES);
        assertThat(movieRentalStoreController.getMovie("Lion King").getCheckedOutCostumer(), is(nullValue()));
    }

    @Test(expected = MovieIsNotAvailableException.class)
    public void checkoutUnavailableMovie() {
        checkoutAvailableMovie();
        movieRentalStoreController.checkoutMovieFromRentalStore("Lion King", COSTUMER);
        assertMovieListIsTheSame(movieRentalStoreController.getMoviesList(), LIST_OF_MOVIES_WITHOUT_LION_KING);
        assertThat(movieRentalStoreController.getMovie("Lion King").getCheckedOutCostumer(), is(COSTUMER));
    }

    private void assertMovieListIsTheSame(List<Product> actualList, List<Product> expectedList) {
        assertThat(actualList.size() == expectedList.size() &&
                actualList.containsAll(expectedList) && expectedList.containsAll(actualList), is(true));
    }
}
