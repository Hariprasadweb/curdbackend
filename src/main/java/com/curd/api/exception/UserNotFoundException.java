package com.curd.api.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(int id){
        super("Employ not found with id "+id);
    }
}
