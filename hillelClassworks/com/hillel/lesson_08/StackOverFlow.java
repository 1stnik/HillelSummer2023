package com.hillel.lesson_08;

public class StackOverFlow {
    public static void main(String[] args) {
        int j = 0;
        req( j);
    }

    public static void req(int j){
        for(;;){
            System.out.println(j++);
            int i = 0;
            req(j);
        }
    }
}
