package com.template.exception;

public class CacheNotFoundException extends RuntimeException {

    public CacheNotFoundException(String message) {
        super(message);
    }
}
