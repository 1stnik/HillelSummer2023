package com.hillel.lesson_05;

public class Inc {
    public void print(String str1, String str2) {
        System.out.println(concat(str1, str2));
    }

    private String concat(String str1, String str2) {
        return str1 + " " + str2;
    }
}

class RunInc{
    public static void main(String[] args) {
        new Inc().print("2", "3");
    }
}
