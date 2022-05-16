package com.eason.magictriangle.domain;

import java.util.Arrays;

import org.javatuples.Triplet;

public class Triangle {
    private TriangleType type;
    private final Triplet<Integer, Integer, Integer> sides;

    public Triangle(Triplet<Integer, Integer, Integer> sides) {
        assert sides.getValue0() <= sides.getValue1();
        assert sides.getValue1() <= sides.getValue2();
        this.sides = sides;
        setType();
    }

    public TriangleType getType() {
        return type;
    }

    public Triplet<Integer, Integer, Integer> getSides() {
        return sides;
    }

    private void setType() {
        type = Arrays.stream(TriangleType.values()).filter(triangleType -> triangleType.isCurrentType(this))
                .findFirst().orElseThrow(ExceptionTriangle::new);
    }
}
