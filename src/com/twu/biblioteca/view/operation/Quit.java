package com.twu.biblioteca.view.operation;

import com.twu.biblioteca.exception.CancelOperationException;

public class Quit implements Operation {
    @Override
    public void execute() {
        throw new CancelOperationException();
    }
}
