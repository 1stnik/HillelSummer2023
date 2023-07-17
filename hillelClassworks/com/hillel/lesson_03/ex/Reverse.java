package com.hillel.lesson_03.ex;


// reverse number 111112344 - 443211111
public class Reverse {
    public static void main(String[] args) {
        int value = 1122;
        System.out.println(value);
        System.out.println(reverse(value));
        System.out.println(reverse(reverse(value)));
    }

    private static int reverse(int value){
        String str = String.valueOf(value);
        char[] charArray = str.toCharArray();
        char tmp;
        for (int i = 0; i < charArray.length ; i++){
            tmp = charArray[i];
            charArray[i] = charArray[charArray.length  - i - 1];
            charArray[charArray.length - i - 1] = tmp;
        }
        return Integer.parseInt(String.copyValueOf(charArray));
    }
}
