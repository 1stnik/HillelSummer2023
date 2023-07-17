package com.hillel.lesson_20.logger;

public class FileMaxSizeReachedException extends RuntimeException{

    public FileMaxSizeReachedException(String message) {
        super(message);
    }
}
