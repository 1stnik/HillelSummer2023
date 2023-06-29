package com.hillel.game;

import com.hillel.game.dto.Card;
import com.hillel.game.dto.Computer;
import com.hillel.game.dto.GameResult;
import com.hillel.game.dto.Player;
import com.hillel.game.service.CardDeck;
import com.hillel.game.service.GameService;
import com.hillel.game.service.MoneyService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome Black Jack : 2023");
        Scanner sc = new Scanner(System.in);

        // config our game set player name, amount and game quantity

        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Put money ... ");
        Integer amount = sc.nextInt();
        System.out.println("Enter number of games [more then 0]: ");
        Integer gameCount = sc.nextInt();
        sc.nextLine();

        // create all necessary objects

        Player pl = new Player(name);
        pl.setAmount(amount);
        pl.setStartAmount(amount);
        Computer computer = new Computer();
        GameService gs = new GameService();
        CardDeck cardDeck = new CardDeck();
        // create new deck from game (every game new deck)
        cardDeck.createDeck();

        // variables for continue games
        String nextCard = "Y";
        String nextGame = "Y";

        int game = 1;


        // loop for numbers of games
        do {
            System.out.println("---------------------->>>>>");
            System.out.println("Game " + game + " from " + gameCount);

            // set bet functionality
            System.out.println("Please put your bet:");
            int bet =  sc.nextInt();
            sc.nextLine();

            bet = MoneyService.validateBalance(bet, pl.getAmount(), sc);

            // loop for hand
            do {
                List<Card> hand = pl.getHand();

                // first time give 2 cards
                if (pl.getHand().size() == 0){
                    hand.add(cardDeck.getCard());
                }
                hand.add(cardDeck.getCard());

                // show hand and calculate score
                int score = gs.calculateHandScore(pl.getHand());
                System.out.println("player hand : " + hand + " >>>> score: " + score);
                if (score < 21) {
                    System.out.println("Next card ... [Y/N]");
                    nextCard = sc.nextLine();
                } else {
                    break;
                }
                //check will we continue get card from deck
            } while (nextCard.equalsIgnoreCase("y"));

            // computer turn
            computer.setHand(gs.computerHand(cardDeck.getDeck()));

            int cScore = gs.calculateHandScore(computer.getHand());
            int pScore = gs.calculateHandScore(pl.getHand());

            // print hands and scores
            System.out.println("===========");
            System.out.println("player hand : " + pl.getHand() + " >>>> score: " + pScore);
            System.out.println("computer hand : " + computer.getHand() + " >>>> score: " + cScore);


            // run method calculate winner
            GameResult gameResult = gs.calculateResult(pScore, cScore);
            System.out.println(gameResult);
            // update player game statistic
            pl.incrementNumberOfGames();
            if (gameResult.equals(GameResult.PLAYER)) {
                pl.incrementNumberOfWinGames();
                pl.add(bet);
            } else if (!gameResult.equals(GameResult.DRAW)) {
                pl.sub(bet);
            }

            // prevent negative balance
            if (pl.getAmount() == 0) break;

            // take new deck + remove card from hand
            cardDeck.createDeck();
            pl.setHand(new ArrayList<>());

            // exit if end numbers of games
            if (game++ != gameCount) {
                System.out.println("Next game ... [Y/N]");
                nextGame = sc.nextLine();
            } else {
                break;
            }

        } while (nextGame.equalsIgnoreCase("y"));

        // show game result
        System.out.println(pl.getPlayerResult());
    }
}
