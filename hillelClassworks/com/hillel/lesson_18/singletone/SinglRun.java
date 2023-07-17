package com.hillel.lesson_18.singletone;

public class SinglRun {
    public static void main(String[] args) {
        User u1 = new User("Alex");
        User u2 = new User("Alex");

        System.out.println(u1);
        System.out.println(u2);


        User u3 = UserSingletone.getUser("Alex");
        User u4 = UserSingletone.getUser("Alex11");
        User u5 = UserSingletone.getUser("Alex1123");

        System.out.println(u3);
        System.out.println(u4);
        System.out.println(u5);
    }
}
