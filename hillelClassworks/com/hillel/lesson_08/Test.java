package com.hillel.lesson_08;

public class Test {

    public static boolean aMoreThanB(int a, int b){
        if (a > b) {
            System.out.println("run");
            return true;
        }
        // ------>
        return false;
    }

    public static void main(String[] args) {
        boolean result = aMoreThanB(6, 5);
        if (result) {
            System.out.println(result);
        }
    }
}
