package com.ayudaencasa.app.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User was not found");
    }

    public UserNotFoundException(String msg) {
        super(msg);
    }
}
