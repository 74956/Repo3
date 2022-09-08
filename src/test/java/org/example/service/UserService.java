package org.example.service;

import org.example.object.User;

public class UserService {

    private static final String EMAIL = "7895264893aq@gmail.com";
    private static final String PASSWORD = "Rh5s59Qw";

    public User credentials() {
        return new User(EMAIL, PASSWORD);
    }
}
