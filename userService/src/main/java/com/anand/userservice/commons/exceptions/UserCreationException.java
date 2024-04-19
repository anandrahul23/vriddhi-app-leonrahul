package com.anand.userservice.commons.exceptions;

public class UserCreationException extends RuntimeException{
    public UserCreationException(String message) {
        super(message);
    }
}
