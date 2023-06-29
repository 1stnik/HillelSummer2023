package com.hillel.game.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Player {
    private String name;
    private Integer amount;
    private Integer startAmount;
    private Integer numberOfGames = 0;
    private Integer numberOfWinGames = 0;
    private List<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void incrementNumberOfGames(){
        numberOfGames++;
    }

    public void incrementNumberOfWinGames(){
        numberOfWinGames++;
    }

    public String getPlayerResult(){
        return "Player " + name +  " win  " + numberOfWinGames + " games from " + numberOfGames +
                " \nplayer balance " + amount+ " and player earn " + (amount - startAmount) + " UAH";
    }

    public void add(Integer add){
        amount += add;
    }

    public void sub(Integer sub){
        amount -= sub;
    }
}
