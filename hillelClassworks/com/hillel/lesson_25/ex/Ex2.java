package com.hillel.lesson_25.ex;

class Helper {
   public int data;
   public Helper() {
        data = 5;
    }
}

public class Ex2 {
    public static void main(String[] args) {
        Helper help = new Helper();
        System.out.println(help.data);
    }
}
