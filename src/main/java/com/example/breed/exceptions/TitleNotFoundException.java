package com.example.breed.exceptions;

public class TitleNotFoundException extends RuntimeException{
    public TitleNotFoundException(String message) {
        super(message);
    }
}
