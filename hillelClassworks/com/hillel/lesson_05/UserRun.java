package com.hillel.lesson_05;

public class UserRun {
    public static void main(String[] args) {
      User u1 = new User();
      User u2 = u1;

//        System.out.println(u1.hashCode());
//        System.out.println(u2.hashCode());
//
//        System.out.println(u1.equals(u2));
//
//        System.out.println(u1);
//        System.out.println(u2);

        update(u1);

        System.out.println(u1);
        System.out.println(u2);


        updateUser(u2);

        System.out.println(u1);
        System.out.println(u2);

    }

    static void update(User user){
        user.setId(1);
        user.setFullName("Alex");
    }

    static User updateUser(User user){
        user.setId(2);
        user.setFullName("Ivan");
        return user;
    }
}
