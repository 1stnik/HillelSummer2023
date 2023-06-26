package com.hillel.game.exceptions;

public class CardDeckEmptyException extends RuntimeException{
    public CardDeckEmptyException(String message) {
        super(message);
    }
}
