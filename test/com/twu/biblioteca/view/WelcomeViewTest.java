package com.twu.biblioteca.view;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WelcomeViewTest {

    public WelcomeView welcomeView = new WelcomeView();

    @Test
    public void welcomeMessageTest() {
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!";
        assertThat(welcomeView.welcomeMessage(), is(expected));
    }

    @Test
    public void displayMenuTest() {
        String expected = "1 - List all books\n2 - Checkout a book\n3 - Return a book\n0 - Quit";
        assertThat(welcomeView.displayMenu(), is(expected));
    }
}
