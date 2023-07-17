package com.hillel.lesson_08;

public class TreeRunner {

    public static void main(String[] args) {

        System.out.println(new Tree(1, "a"));
        System.out.println( new RetTree(1, "a", "red"));

        Tree tree = new RetTree(1, "a", "red");
//        RetTree tree1 = new Tree(1, "a");
        System.out.println(tree);
    }
}
