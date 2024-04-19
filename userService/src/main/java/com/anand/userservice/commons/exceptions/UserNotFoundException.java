package com.anand.userservice.commons.exceptions;

public class UserNotFoundException extends IllegalCallerException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
