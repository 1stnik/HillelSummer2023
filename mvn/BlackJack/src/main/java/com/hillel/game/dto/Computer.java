package com.hillel.game.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;


@Data
public class Computer {
    private List<Card> hand = new ArrayList<>();
}
