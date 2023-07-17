package com.hillel.lesson_04.ex;

import java.util.Arrays;

/*
 Заполнить массив N числами последовательности Фибоначчи
 F(n) = F(n - 1) + F(n - 2) //F(0) = 0; F(1) = 1;
 */
public class Fibonacci {
    public static void main(String[] args) {
        int n = 50;
        for (int i = 0; i <= n; i++){
            long start = System.nanoTime();
            System.out.print(" number : " + i +
                    " : result " + getFibonachiNumber(i) +
                    " , duration : " + (System.nanoTime() - start));
            System.out.println();
        }
    }

    private static int getFibonachiNumber(int number){
        if (number <= 1) return number;
        return getFibonachiNumber(number - 1) + getFibonachiNumber(number - 2);
    }

}
