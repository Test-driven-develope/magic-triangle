package com.eason.magictriangle.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TriangleTest {
    
    @Test
    public void should_be_normal_triangle_when_three_sides_are_2_3_4() {
        Triangle triangle = new Triangle(Arrays.asList("2", "3", "4"));
        assertEquals(triangle.getType(), TriangleType.NORMAL);
    }

    @Test
    public void should_be_normal_triangle_when_three_sides_are_4_5_6() {
        Triangle triangle = new Triangle(Arrays.asList("4", "5", "6"));
        assertEquals(triangle.getType(), TriangleType.NORMAL);
    }

    @Test(expected = ExceptionTriangle.class)
    public void should_throw_exception_when_three_sides_are_1_2_3() {
        new Triangle(Arrays.asList("1", "2", "3"));
    }

    @Test(expected = ExceptionTriangle.class)
    public void should_throw_exception_when_sides_are_2_3() {
        new Triangle(Arrays.asList("2", "3"));
    }

    @Test(expected = ExceptionTriangle.class)
    public void should_throw_exception_when_sides_are_2_3_4_5() {
        new Triangle(Arrays.asList("2", "3", "4", "5"));
    }
    
    @Test(expected = ExceptionTriangle.class)
    public void should_throw_exception_when_sides_are_not_int() {
        new Triangle(Arrays.asList("2_3_4"));
    }
    
    @Test(expected = ExceptionTriangle.class)
    public void should_throw_exception_when_sides_are_negative() {
        new Triangle(Arrays.asList("-2", "-3", "-4"));
    }
    
    @Test(expected = ExceptionTriangle.class)
    public void should_throw_exception_when_sides_are_float() {
        new Triangle(Arrays.asList("2.1", "3.2", "4"));
    }
    
    @Test
    public void should_be_equilateral_triangle_when_three_sides_are_2_2_2() {
        Triangle triangle = new Triangle(Arrays.asList("2", "2", "2"));
        assertEquals(triangle.getType(), TriangleType.EQUILATERAL);
    }
    
    @Test
    public void should_be_isosceles_triangle_when_three_sides_are_2_2_3() {
        Triangle triangle = new Triangle(Arrays.asList("2", "2", "3"));
        assertEquals(triangle.getType(), TriangleType.ISOSCELES);
    }
    
    @Test
    public void should_be_right_triangle_when_three_sides_are_3_4_5() {
        Triangle triangle = new Triangle(Arrays.asList("3", "4", "5"));
        assertEquals(triangle.getType(), TriangleType.RIGHT);
    }
}