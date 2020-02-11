package com.twu.biblioteca.view.operation;

import com.twu.biblioteca.entity.user.Costumer;

public class MyInformation implements Operation {
    private Costumer costumer;

    public MyInformation(Costumer costumer) {
        this.costumer = costumer;
    }

    @Override
    public void execute() {
        System.out.println(costumer);
    }
}
