package com.twu.biblioteca.view.operation;

import com.twu.biblioteca.controller.LibraryController;

public class ListBooks implements Operation {
    LibraryController libraryController;

    public ListBooks(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    @Override
    public void execute() {
        libraryController.getBooksList().forEach(System.out::println);
    }
}
