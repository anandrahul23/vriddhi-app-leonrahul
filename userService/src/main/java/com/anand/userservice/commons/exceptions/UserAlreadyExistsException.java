package com.anand.userservice.commons.exceptions;

public class UserAlreadyExistsException extends IllegalArgumentException{
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
