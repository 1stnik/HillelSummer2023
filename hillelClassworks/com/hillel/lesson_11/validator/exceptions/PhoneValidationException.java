package com.hillel.lesson_11.validator.exceptions;

public class PhoneValidationException extends RuntimeException{
    public PhoneValidationException(String message) {
        super(message);
    }
}
