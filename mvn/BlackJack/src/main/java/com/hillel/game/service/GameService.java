package com.hillel.game.service;

import com.hillel.game.dto.Card;
import com.hillel.game.dto.GameResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class GameService {

    public Integer calculateHandScore(List<Card> hand) {
        return hand.stream().mapToInt(Card::getCost).sum();
    }

    public void printHand(List<Card> hand) {
        hand.forEach(System.out::print);
    }

    public Integer computerTurnResult() {
        return new Random().nextInt(25 - 17) + 17; // 17 - 25
    }

    public List<Card> computerHand(Stack<Card> cardDeck){
        Integer numberOfCards = new Random().nextInt(5) + 1;
        List<Card> computerHand = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++){
            computerHand.add(cardDeck.pop());
        }
        return  computerHand;
    }


    public GameResult calculateResult(Integer playerScore, Integer computerScore) {
        if (playerScore > 21 && computerScore > 21) {
            return GameResult.LOSE;
        } else if (computerScore > 21) {
            return GameResult.PLAYER;
        } else if (playerScore > 21) {
            return GameResult.COMPUTER;
        } else if (playerScore > computerScore) {
            return GameResult.PLAYER;
        } else if (playerScore < computerScore) {
            return GameResult.COMPUTER;
        } else {
            return GameResult.DRAW;
        }
    }


}
