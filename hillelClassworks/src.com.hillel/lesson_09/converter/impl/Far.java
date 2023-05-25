package lesson_09.converter.impl;


import lesson_09.converter.Converter;

public class Far implements Converter {
    @Override
    public int convert(int value) {
        return (int) (value * 1.8) + 32;
    }
}
