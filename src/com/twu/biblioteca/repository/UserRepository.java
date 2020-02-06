package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.user.Costumer;
import com.twu.biblioteca.entity.user.Librarian;
import com.twu.biblioteca.entity.user.User;

import java.util.Arrays;
import java.util.List;

public class UserRepository {

    private static List<User> userList = Arrays.asList(
            new Librarian("123-4567", "123"),
            new Costumer("456-4567", "456", "Tom", "tom@email.com", "99456-1234"),
            new Costumer("789-4567", "789", "Jerry", "jerry@email.com", "99789-1234")
    );

    public static User getUserByLibraryNumber(String libraryNumber) {
        return userList
                .stream()
                .filter(user -> user.getLibraryNumber().equals(libraryNumber))
                .findAny()
                .orElse(null);
    }
}
