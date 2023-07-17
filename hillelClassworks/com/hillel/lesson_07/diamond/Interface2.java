package com.hillel.lesson_07.diamond;

public interface Interface2 {
    default void print() {
        System.out.println("Interface 2");
    }

    default void printDef2() {
        System.out.println("I2.print()");
    }
}
