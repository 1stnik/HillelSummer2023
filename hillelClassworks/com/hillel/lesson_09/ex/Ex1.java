package com.hillel.lesson_09.ex;

public class Ex1 {
    int x = 3;

    public static void main(String[] args) {
        new Ex1().go1();
    }

    void go1() {
//        int x = 0;
        go2(++x); // 4
    }

    void go2(int y) {
        int x = ++y; // 5
        System.out.println(x);
    }
}
