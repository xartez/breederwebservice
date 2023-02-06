package com.example.breed.exceptions;

public class DogNotFoundException extends RuntimeException{
    public DogNotFoundException(String message) {
        super(message);
    }
}
