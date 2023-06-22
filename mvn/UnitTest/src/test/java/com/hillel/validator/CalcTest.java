package com.hillel.validator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CalcTest {

    @Test
    void add() {
        assertEquals(4, new Calc().add(2, 2));
    }

    @Test
    void sub() {
        assertEquals(0, new Calc().sub(2, 2));
    }

    @Test
    void div() {
        assertEquals(1, new Calc().div(2, 2));
    }

    @Test
    void divByZero() {
        assertThrows(ArithmeticException.class, () -> new Calc().div(1, 0));
    }

    @Test
    void divZero() {
        assertEquals(0, new Calc().div(0, 2));
    }

    @Test
    void compareList() {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");

        List<String> list2 = new ArrayList<>(Arrays.asList("1", "2", "3"));


        assertTrue(list1.equals(list2));
        assertEquals(3, list2.size());
        assertEquals(list1.get(0), list2.get(0));
    }
}
