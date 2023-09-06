package com.hillel.lesson_31;

public class Test1 {
    public static void main(String[] args) {
        int i = 0;

        for (foo('A'); foo('B') && i < 3; foo('C')){
            i++;
            foo('D');
        }
    }

    private static boolean foo(char c){
        System.out.println(c);
        return true;
    }
}

