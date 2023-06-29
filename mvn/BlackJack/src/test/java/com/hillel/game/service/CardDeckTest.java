package com.hillel.game.service;

import static org.junit.jupiter.api.Assertions.*;

import com.hillel.game.dto.Card;
import com.hillel.game.exceptions.CardDeckEmptyException;
import java.util.Stack;
import org.junit.jupiter.api.Test;

class CardDeckTest {

    @Test
    void getDeckTest(){
        CardDeck cardDeck = new CardDeck();
        Stack<Card> deck = cardDeck.createDeck();
        assertEquals(52, deck.size());
        deck.pop();
        assertEquals(51, deck.size());
    }

    @Test
    void getCardTest(){
        CardDeck cardDeck = new CardDeck();
        cardDeck.createDeck();
        Card card = cardDeck.getCard();
        assertNotNull(card);
    }

    @Test
    void getCardEcxeptionTest(){
        CardDeck cardDeck = new CardDeck();
        assertThrows(CardDeckEmptyException.class, () -> cardDeck.getCard());
    }
}
