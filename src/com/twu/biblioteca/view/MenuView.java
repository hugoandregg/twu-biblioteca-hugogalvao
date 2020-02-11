package com.twu.biblioteca.view;

import com.twu.biblioteca.constants.Messages;
import com.twu.biblioteca.exception.CancelOperationException;
import com.twu.biblioteca.view.operation.Operation;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class MenuView {

    public static void display(String menu, Scanner in, Map<Integer, Operation> operationMap) {
        while (true) {
            System.out.println(menu);
            System.out.println(Messages.SELECT_OPERATION_MESSAGE);
            try {
                int operation = in.nextInt();
                if (operationMap.containsKey(operation)) {
                    operationMap.get(operation).execute();
                } else {
                    System.out.println(Messages.INVALID_OPTION_MESSAGE);
                }
            } catch (CancelOperationException e) {
                return;
            } catch (InputMismatchException e) {
                System.out.println(Messages.INVALID_OPTION_MESSAGE);
                in.nextLine();
            }
        }
    }
}
