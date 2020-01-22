package com.twu.biblioteca.view;

public class WelcomeView {

    public void run() {
        System.out.println(welcomeMessage());
    }

    public String welcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!";
    }
}
