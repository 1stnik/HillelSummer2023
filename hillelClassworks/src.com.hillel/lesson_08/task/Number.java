package lesson_08.task;

import java.util.Arrays;
import java.util.HashSet;

public class Number {
    /*
       Найти число, состоящее только из различных цифр.
     */
    public static void main(String[] args) {
        System.out.println(isDiff(1324567));
    }

    private static boolean isDiff(Integer value){ // 1 2 3 4 5 6 7 8 9 0
        String[] val = value.toString().split("");
        if (val.length > 11) return false;
        int inArr = val.length;
        int outArr = new HashSet<>(Arrays.asList(val)).size();

        return inArr == outArr;
    }
}
