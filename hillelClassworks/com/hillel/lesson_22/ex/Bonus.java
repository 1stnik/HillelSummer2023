package com.hillel.lesson_22.ex;

import java.util.Arrays;

public class Bonus {
    public static void main(String[] args) {
        String[] str = new String[10]; // null null null ... (10)
        str[0] = "FIRST";
        System.out.println(Arrays.asList(str).size()); // 10
        System.out.println(Arrays.asList(str)); // FIRST null null null ... (9)
    }
}
