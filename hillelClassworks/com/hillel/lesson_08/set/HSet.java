package com.hillel.lesson_08.set;

import java.util.HashSet;
import java.util.Set;

public class HSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(5);

        System.out.println(set.add("1sdgfghfsgh"));
        System.out.println(set.add("1sfdhfgh")); // false
        System.out.println(set.add("2dfghfgh"));
        System.out.println(set.add("3fghfgafsx"));
        System.out.println(set.add("4xcbfgg"));
        System.out.println(set.add("5"));
        System.out.println(set.add("6hfgcfhb"));
        System.out.println(set.add("7xcbfgh"));
        System.out.println(set.add("8cncvn"));

        System.out.println(set);



        int i = 1;
        int count = 0;
        String value = null;
        for (String s : set){
            if (count++ == i) value = s;
         }

        System.out.println(value);

    }
}
