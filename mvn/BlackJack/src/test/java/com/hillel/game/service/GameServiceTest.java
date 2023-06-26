package com.hillel.game.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.hillel.game.dto.Card;
import com.hillel.game.dto.GameResult;
import com.hillel.game.dto.Rank;
import com.hillel.game.dto.Suit;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameServiceTest {

    @Test
    void calculateHandTest() {
        Card card = new Card(Rank.Five, Suit.Diamonds);
        Card card1 = new Card(Rank.Six, Suit.Diamonds);
        Card card2 = new Card(Rank.Seven, Suit.Diamonds);

        List<Card> hand = List.of(card1, card, card2);

        GameService gameService = new GameService();

        assertEquals(18, gameService.calculateHandScore(hand));
    }


    @Test
    @RepeatedTest(10)
    void computerHandTest(){
        CardDeck cd = new CardDeck();
        Stack<Card> deck = cd.getDeck();

        GameService gs = new GameService();
        List<Card> cards = gs.computerHand(deck);

        assertTrue(cards.size() > 0 && cards.size() <= 5);
        assertEquals(52 - cards.size(), deck.size());

    }

    @Test
    @RepeatedTest(10)
    void computerTurnResultTest() {
        GameService gameService = new GameService();
        Integer result = gameService.computerTurnResult();
        assertTrue(result > 16 && result < 26);
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void calculateResultTest(Integer pScore, Integer cScore, GameResult gameResult){
        GameService gs = new GameService();
        assertEquals(gameResult, gs.calculateResult(pScore, cScore));
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(20, 20, GameResult.DRAW),
                Arguments.of(22, 22, GameResult.LOSE),
                Arguments.of(21, 20, GameResult.PLAYER),
                Arguments.of(20, 21, GameResult.COMPUTER),
                Arguments.of(15, 19, GameResult.COMPUTER),
                Arguments.of(19, 16, GameResult.PLAYER),
                Arguments.of(24, 21, GameResult.COMPUTER),
                Arguments.of(21, 225, GameResult.PLAYER)
        );
    }
}

