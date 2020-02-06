package com.twu.biblioteca.controller;

import com.twu.biblioteca.entity.user.Costumer;
import com.twu.biblioteca.entity.user.Librarian;
import com.twu.biblioteca.exception.InvalidLibraryNumber;
import com.twu.biblioteca.exception.InvalidPassword;
import com.twu.biblioteca.repository.UserRepository;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserControllerTest {

    private UserController userController = new UserController();

    private final Costumer COSTUMER = (Costumer) UserRepository.getUserByLibraryNumber("456-4567");

    private final Librarian LIBRARIAN = (Librarian) UserRepository.getUserByLibraryNumber("123-4567");

    @Test
    public void loginWithCostumer() {
        assertThat(userController.login("456-4567", "456"), is(COSTUMER));
    }

    @Test
    public void loginWithLibrarian() {
        assertThat(userController.login("123-4567", "123"), is(LIBRARIAN));
    }

    @Test(expected = InvalidLibraryNumber.class)
    public void loginWithWrongLibraryNumber() {
        userController.login("1234-4567", "123");
    }

    @Test(expected = InvalidPassword.class)
    public void loginWithWrongPassword() {
        userController.login("123-4567", "1234");
    }
}
