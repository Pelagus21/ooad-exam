package com.example.ooadexam.exceptions;

public class UserBlockedException extends RuntimeException {

    public UserBlockedException(Long id) {
        super("User with id=" + id + " has been blocked");
    }
}
