package com.hillel.lesson_08;

public class Tree {

    int age;
    String Name;

    public Tree(int age, String name) {
        this.age = age;
        Name = name;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "age=" + age +
                ", Name='" + Name + '\'' +
                '}';
    }
}
