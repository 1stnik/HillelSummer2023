package com.hillel.validator;

import static org.junit.jupiter.api.Assertions.*;

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


}
