package com.hillel.lesson_07.diamond;

public interface Interface1 {
    default void print() {
        System.out.println("Interface 1");
    }

    default void printDef1(){
        System.out.println("I1.print()");
    };
}
