package com.hillel.lesson_33.ex;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        System.out.println(map.put("q", "a"));
        System.out.println(map);

        System.out.println(map.put("q", "b"));
        System.out.println(map);
    }
}
