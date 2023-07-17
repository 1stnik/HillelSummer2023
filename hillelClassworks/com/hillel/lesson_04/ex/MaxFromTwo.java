package com.hillel.lesson_04.ex;

public class MaxFromTwo {
    public static void main(String[] args) {
        System.out.println(new MaxFromTwo().max(10, 10));
        System.out.println(Integer.max(10, 10));
    }
    public Integer max(Integer a, Integer b) {
        return a > b ? a : b;
    }
}
