package com.hillel.lesson_04.ex;

import java.util.Locale;

public class Polindrom {

    private static final String TEXT = "А роза упала на лапу Азора";
    private static final String TEXT_F = "asddaa";

    public static void main(String[] args) {
        System.out.println(isPolindrom(TEXT));
        System.out.println(isPolindrom(TEXT_F));
    }

    public static boolean isPolindrom(String str) {
        char[] s = str.toLowerCase().replace(" ", "").toCharArray();
        for (int i = 0; i < s.length/2; i++){
            if (s[i] != s[s.length - 1 - i]) return false;
        }
        return true;
    }
}
