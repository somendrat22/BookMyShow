package com.bookmyshow.Book.My.Show.exceptions;

public class UserDoesNotExistException extends RuntimeException{
    public UserDoesNotExistException(String message){
        super(message);
    }
}
