package com.hillel.game.service;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoneyService {

    private static final Logger logger = LoggerFactory.getLogger("logger");
    // validate balance and put correct bet
    public static Integer validateBalance(Integer bet, Integer amount, Scanner sc){
        if (bet > amount){
            System.out.printf("You can put %s $. Continue [Y/N]%n", amount);

            String des = sc.nextLine();

            if (!des.equalsIgnoreCase("y")){
                logger.info("user put incorrect bet ....");
                System.out.println("Please put your new bet:");
                bet = sc.nextInt();
                sc.nextLine();
                validateBalance(bet, amount, sc);
            } else {
                bet = amount;
            }
        }
        return bet;
    }

}
