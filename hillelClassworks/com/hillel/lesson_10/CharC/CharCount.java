package com.hillel.lesson_10.CharC;

import java.util.HashMap;
import java.util.Map;

public class CharCount {

    public static void main(String[] args) {
        // map <K: char, V : count> - empty
        Map<String, Integer> charCount = new HashMap<>();
        // text to char array
        String[] testArr = Text.getText().toLowerCase().split("");
        // for by arr elements
        for (String s : testArr){
            // check is char present into map
            if (charCount.containsKey(s)){
                // increase count +1
                charCount.put(s, charCount.get(s) + 1);
            }
            else {
                // create new row into map
                charCount.put(s, 1);
            }
        }
        System.out.println(charCount.size());
        System.out.println(charCount);
    }


}
