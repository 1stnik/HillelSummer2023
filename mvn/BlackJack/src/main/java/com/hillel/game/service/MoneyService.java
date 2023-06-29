package com.hillel.game.service;

import java.util.Scanner;

public class MoneyService {

    // validate balance and put correct bet
    public static Integer validateBalance(Integer bet, Integer amount, Scanner sc){
        if (bet > amount){
            System.out.printf("You can put %s $. Continue [Y/N]%n", amount);
            String des = sc.nextLine();

            if (!des.equalsIgnoreCase("y")){
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
