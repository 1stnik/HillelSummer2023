package lesson_11.ex;

import java.util.HashSet;
import java.util.TreeSet;

public class Ex5 {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>(); // alphabetic
//        HashSet<String> set = new HashSet<>(4);
        System.out.println(set.add("Java"));          // true
        System.out.println(set.add("The"));           // true
        System.out.println(set.add("Java"));          // false
        System.out.println(set.add("JavaTheBest"));   // true
        System.out.println("------------");
        for (String str : set) {
            System.out.print(str + " ");
        }
        System.out.println("\n");
    }
}
