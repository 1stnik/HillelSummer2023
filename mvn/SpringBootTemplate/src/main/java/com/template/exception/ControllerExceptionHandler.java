package com.template.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {
            Exception.class})
    public ResponseEntity<?> handleInvalidTopUpTypeException(Exception ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {
            KeyNotFoundException.class})
    public ResponseEntity<?> handleKeyNotFound(Exception ex) {
        return new ResponseEntity("KEY_NOT_FOUND", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {
            CacheNotFoundException.class})
    public ResponseEntity<?> handleCacheNotFound(Exception ex) {
        return new ResponseEntity("CACHE_NOT_FOUND", HttpStatus.BAD_REQUEST);
    }
}
