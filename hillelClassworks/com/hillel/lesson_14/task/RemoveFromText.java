package com.hillel.lesson_14.task;


import java.util.Arrays;

// Из текста удалить все слова заданной длины, начинающиеся c заданой буквы.
public class RemoveFromText {

    private final static String TEXT = "Скажите зачем эта маленькая княгиня сказал знязь Василий " +
            "зтихо Анне Павловне почему он особенно умного Мы зосле поговорим сказала Анна Павловна" +
            " улыбаясь";

    public static void main(String[] args) {

        int wordSize = 5;
        String startChar = "з";

        StringBuilder rezTest = new StringBuilder();

        Arrays.stream(TEXT.split(" "))
                .filter(w -> w.length() != wordSize && !w.startsWith(startChar))
                .toList()
                .forEach(w -> rezTest.append(w).append(" "));

        System.out.println(TEXT);
        System.out.println(rezTest);




    }


}
