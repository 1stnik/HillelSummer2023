package com.hillel.lesson_25.reflection;

import java.lang.reflect.InvocationTargetException;

public class ClasExample {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        String str = new String();
        System.out.println(str.getClass()); // from Object

        Class strClass = Class.forName("java.lang.String"); // from class
        System.out.println(strClass);

        String s = (String) strClass.newInstance(); // create new object

        String str1 = (String) strClass.getDeclaredConstructor().newInstance(); // create new object

        System.out.println(s);
        System.out.println(str1);
    }
}
