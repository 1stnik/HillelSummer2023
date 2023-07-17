package com.hillel.lesson_08;

public class RetTree extends Tree{

    String color;

    public RetTree(int age, String name, String color) {
        super(age, name);
        this.color = color;
    }


    @Override
    public String toString() {
        return "RetTree{" +
                "color='" + color + '\'' +
                ", age=" + age +
                ", Name='" + Name + '\'' +
                '}';
    }
}
