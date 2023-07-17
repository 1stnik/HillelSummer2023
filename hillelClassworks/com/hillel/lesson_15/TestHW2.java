package com.hillel.lesson_15;

import java.util.List;
import java.util.Locale;

public class TestHW2 {

    public static void main(String[] args) {
        class Pair{
            private String lCase;
            private String uCase;

            public Pair(String lCase, String uCase) {
                this.lCase = lCase;
                this.uCase = uCase;
            }

            @Override
            public String toString() {
                return "Pair{" +
                        "lCase='" + lCase + '\'' +
                        ", uCase='" + uCase + '\'' +
                        '}';
            }
        }

        List<String> list = List.of("a", "b" , "c", "d" , "e");

        List<Pair> pairs = list.stream()
                .map(c -> new Pair(c, c.toUpperCase(Locale.ROOT))).toList();

        pairs.forEach(System.out::println);

    }
}
