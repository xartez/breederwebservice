package com.example.breed.exceptions;

public class LitterNotFoundException extends RuntimeException{
    public LitterNotFoundException(String message) {
        super(message);
    }
}
