package com.hillel.lesson_07.task;

import java.util.Arrays;
import java.util.HashSet;

public class Number {
    /*
       Найти число, состоящее только из различных цифр.
     */
    public static void main(String[] args) {
        System.out.println(isDiff(122));
    }

    private static boolean isDiff(Integer value){
        String s = value.toString();
        String[] str = s.split("");
        System.out.println(str.length);
        System.out.println(new HashSet<>(Arrays.asList(str)).size());
        return str.length == new HashSet<>(Arrays.asList(str)).size();
    }
}
