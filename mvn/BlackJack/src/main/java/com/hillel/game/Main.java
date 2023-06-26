package com.hillel.game;

import com.hillel.game.dto.Card;
import com.hillel.game.dto.Player;
import com.hillel.game.service.CardDeck;
import com.hillel.game.service.GameService;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome Black Jack : 2023");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        Player pl = new Player(name);
        GameService gs = new GameService();
        CardDeck cardDeck = new CardDeck();

        cardDeck.getDeck();

        String nextCard = "Y";
        String stopGame = "Y";

        do {
            List<Card> hand = pl.getHand();
            hand.add(cardDeck.getCard());
            System.out.println("hand : " + hand);
            System.out.println("Next card ... [Y/N]");
            nextCard = sc.nextLine();
        } while (nextCard.equalsIgnoreCase("y"));

        Integer cScore = gs.computerTurnResult();
        Integer pScore = gs.calculateHandScore(pl.getHand());
        System.out.println("player hand score : " + pScore);
        System.out.println("computer hand score : " + cScore);
        System.out.println(gs.calculateResult(pScore, cScore));
        System.out.println("end game...");

    }
}
