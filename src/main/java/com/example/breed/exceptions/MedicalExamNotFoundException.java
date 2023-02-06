package com.example.breed.exceptions;

public class MedicalExamNotFoundException extends RuntimeException{
    public MedicalExamNotFoundException(String message) {
        super(message);
    }
}
