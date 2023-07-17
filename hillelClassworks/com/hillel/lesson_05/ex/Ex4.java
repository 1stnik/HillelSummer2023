package com.hillel.lesson_05.ex;

public class Ex4 {
    static int method1(int i) {
        System.out.println("m1");
        return method2(i *= 11);
    }
    static int method2(int i) {
        System.out.println("m2");
        return method3(i /= 11);
    }
    static int method3(int i) {
        System.out.println("m3");
        return method4(i -= 11);
    }
    static int method4(int i) {
        System.out.println("m4");
        return i += 11;
    }
    public static void main(String[] args) {
        System.out.println(method1(11));
    }
}
