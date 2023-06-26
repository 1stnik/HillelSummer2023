package com.hillel.game.dto;

public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    public int getCost() {
        return rank.getCost();
    }

    @Override
    public String toString() {
        return String.format("%s%s", rank.getName(), suit.getSymbol());
    }

}
