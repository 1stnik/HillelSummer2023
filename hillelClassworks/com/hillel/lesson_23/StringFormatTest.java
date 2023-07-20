package com.hillel.lesson_23;

public class StringFormatTest {

    public static void main(String[] args) {
        String s = "select * from student s where s.last_name like '%s';";
        System.out.println(String.format(s, "S"+"%"));

    }

}
