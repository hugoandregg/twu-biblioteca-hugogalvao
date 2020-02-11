package com.twu.biblioteca.controller;

import com.twu.biblioteca.constants.Messages;
import com.twu.biblioteca.entity.user.User;
import com.twu.biblioteca.exception.InvalidLibraryNumber;
import com.twu.biblioteca.exception.InvalidPassword;
import com.twu.biblioteca.repository.UserRepository;

public class UserController {

    public User login(String libraryNumber, String password) {
        User currentUser = UserRepository.getInstance().getUserByLibraryNumber(libraryNumber);
        if (null != currentUser) {
            if (currentUser.getPassword().equals(password)) {
                return currentUser;
            }
            throw new InvalidPassword(Messages.INVALID_PASSWORD_MESSAGE);
        }
        throw new InvalidLibraryNumber(Messages.INVALID_LIBRARY_NUMBER_MESSAGE);
    }
}
