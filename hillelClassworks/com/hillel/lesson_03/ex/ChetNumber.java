package com.hillel.lesson_03.ex;

import java.util.Scanner;

// count sum of odd numbers 12235 - 1 + 3 + 5 = 9
public class ChetNumber {

    public static void main(String[] args) {
        int number = 1_111_111_111;
        System.out.println(calculate(number));
    }

    private static int calculate(int value){
        char[] charArray = String.valueOf(value).toCharArray();
        int result = 0;
        for (char c : charArray) {
            int v = Integer.parseInt(String.valueOf(c));
            if (v % 2 == 1) {
                result += v;
            }
        }
        return result;
    }
}
