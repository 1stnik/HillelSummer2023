package com.hillel.lesson_08;

public interface CCollection {
    boolean add(String o);
    boolean add(int index, String o);
    boolean delete (String o);
    String get(int index);
    boolean contain(String o);
    boolean equals (CCollection str);
    boolean clear();
    int size();
}
