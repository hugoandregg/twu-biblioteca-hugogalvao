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
}
