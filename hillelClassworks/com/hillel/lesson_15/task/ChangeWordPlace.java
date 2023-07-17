package com.hillel.lesson_15.task;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ChangeWordPlace {
    //5. В каждом предложении текста поменять местами первое слово с последним, не изменяя
    //длины предложения.

    private static String EX = "1 2 3 4. 2 3 4. 3 4 5. 6 7. 1";
    private static String REZ = "4 2 3 1. 4 3 2. 5 4 3. 7 6. 1";

    public static void main(String[] args) {
        changeWordOrder(EX);
    }

    private static void changeWordOrder(String text) {
        System.out.println(Arrays.stream(text.split("\\. "))
                .map(ChangeWordPlace::swap)
                .collect(Collectors.joining(". ")));

    }

    private static String swap(String sent){
        String[] str = sent.split(" ");
        String tmp = str[0];
        str[0] = str[str.length - 1];
        str[str.length - 1] = tmp;

        return String.join(" ", str);
    }

}
