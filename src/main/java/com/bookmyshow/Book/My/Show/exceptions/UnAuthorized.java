package com.bookmyshow.Book.My.Show.exceptions;

public class UnAuthorized extends RuntimeException{
    public UnAuthorized(String message){
        super(message);
    }
}
