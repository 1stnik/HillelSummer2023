package com.hillel.game.service;

import com.hillel.game.dto.Card;
import com.hillel.game.dto.Rank;
import com.hillel.game.dto.Suit;
import com.hillel.game.exceptions.CardDeckEmptyException;
import java.util.Collections;
import java.util.Stack;


public class CardDeck {

    Stack<Card> deck = new Stack<>();

    public Stack<Card> getDeck(){
        for(Suit suit : Suit.values()){
            for (Rank rank : Rank.values()){
                deck.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(deck);
        return deck;
    }

    public Card getCard(){
        if (deck.isEmpty())
            throw new CardDeckEmptyException("No available card ...");
        return deck.pop();
    }

}
