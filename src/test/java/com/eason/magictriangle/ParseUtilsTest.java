package com.eason.magictriangle;

import static org.junit.Assert.*;

import org.javatuples.Triplet;
import org.junit.Test;

public class ParseUtilsTest {
    @Test
    public void should_return_triplet_when_input_1_2_3() throws InputException {
        final Triplet<Integer, Integer, Integer> sides = ParseUtils.parseInput("1,2,3");
        assertEquals(sides, new Triplet<>(1, 2, 3));
    }

    @Test(expected = InputException.class)
    public void should_throw_input_exception_when_input_1_2() throws InputException {
        ParseUtils.parseInput("1,2");
    }

    @Test(expected = InputException.class)
    public void should_throw_input_exception_when_input_1_2_4_5() throws InputException {
        ParseUtils.parseInput("1,2,4,5");
    }

    @Test(expected = NumberFormatException.class)
    public void should_throw_input_exception_when_input_s_2_3() throws InputException {
        ParseUtils.parseInput("s,2,3");
    }

    @Test(expected = InputException.class)
    public void should_throw_input_exception_when_input_sides_contains_negative() throws InputException {
        ParseUtils.parseInput("2,3,-4");
    }

    @Test(expected = NumberFormatException.class)
    public void should_throw_input_exception_when_input_sides_contains_float() throws InputException {
        ParseUtils.parseInput("2,3,0.4");
    }
}
