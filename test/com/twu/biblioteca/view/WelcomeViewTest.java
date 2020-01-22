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
    public void listBooksTest() {
        String expected = "Harry Potter and the Sorcerer's stone | J.K. Rowling | 2015\n" +
                "The Last Wish: Introducing the Witcher | Andrzej Sapkowski | 2008\n" +
                "The Handmaid's tale | Margaret Atwood | 1986\n";
        assertThat(welcomeView.listBooks(), is(expected));
    }
}
