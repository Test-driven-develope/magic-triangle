package com.eason.magictriangle.domain;

import static org.junit.Assert.assertEquals;

import org.javatuples.Triplet;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void should_be_normal_triangle_when_three_sides_are_2_3_4() {
        Triangle triangle = new Triangle(new Triplet<>(2, 3, 4));
        assertEquals(triangle.getType(), TriangleType.NORMAL);
    }

    @Test
    public void should_be_normal_triangle_when_three_sides_are_4_5_6() {
        Triangle triangle = new Triangle(new Triplet<>(4, 5, 6));
        assertEquals(triangle.getType(), TriangleType.NORMAL);
    }

    @Test(expected = ExceptionTriangle.class)
    public void should_throw_exception_when_three_sides_are_1_2_3() {
        new Triangle(new Triplet<>(1, 2, 3));
    }

    @Test
    public void should_be_equilateral_triangle_when_three_sides_are_2_2_2() {
        Triangle triangle = new Triangle(new Triplet<>(2, 2, 2));
        assertEquals(triangle.getType(), TriangleType.EQUILATERAL);
    }

    @Test
    public void should_be_isosceles_triangle_when_three_sides_are_2_2_3() {
        Triangle triangle = new Triangle(new Triplet<>(2, 2, 3));
        assertEquals(triangle.getType(), TriangleType.ISOSCELES);
    }

    @Test
    public void should_be_right_triangle_when_three_sides_are_3_4_5() {
        Triangle triangle = new Triangle(new Triplet<>(3, 4, 5));
        assertEquals(triangle.getType(), TriangleType.RIGHT);
    }
}
