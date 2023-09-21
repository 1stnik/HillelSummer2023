package com.telegram.example.exception;

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
            UserNotFoundException.class})
    public ResponseEntity<?> handleUserNotFoundException(Exception ex) {
        return new ResponseEntity("USER_NOT_REGISTRATED_INTO_BOT", HttpStatus.BAD_REQUEST);
    }
}
