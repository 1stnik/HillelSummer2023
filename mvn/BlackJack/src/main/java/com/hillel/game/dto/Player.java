package com.hillel.game.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Player {
    private String name;
    private Integer numberOfGames = 0;
    private Integer numberOfGamesWinGames = 0;
    private List<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

}
