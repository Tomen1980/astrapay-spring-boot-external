package com.astrapay.exception;

public class ConflictException extends RuntimeException{
    public ConflictException(String message){
        super(message);
    }
}
