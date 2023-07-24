package com.hillel.lesson_24.ex;

public class Ex4 {
    public static void main(String[] args) {
//        String str = "BEVERAGEGREEFTE" ;
        String str = "BEVERAGE" ;
        String [] arr = str.split( "E", 2  );
        System. out .println(String. join ( "." , arr));
    }
}

