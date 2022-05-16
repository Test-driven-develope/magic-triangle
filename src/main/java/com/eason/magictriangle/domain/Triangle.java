package com.eason.magictriangle.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.javatuples.Triplet;

public class Triangle {
    private final TriangleType type;
    private Triplet<Integer, Integer, Integer> sides;

    public Triangle(List<String> sides) {
        separateSides(sides);

        type = getTriangleType();
    }

    public TriangleType getType() {
        return type;
    }

    public Triplet<Integer, Integer, Integer> getSides() {
        return sides;
    }

    private TriangleType getTriangleType() {
        return Arrays.stream(TriangleType.values()).filter(triangleType -> triangleType.isCurrentType(this))
                .findFirst().orElseThrow(ExceptionTriangle::new);
    }

    private void separateSides(List<String> sides) {
        try {
            final List<Integer> sidesLength = sides.stream()
                    .map(Integer::valueOf).sorted().collect(Collectors.toList());
            if (sidesLength.size() != 3) {
                throw new ExceptionTriangle();
            }
            this.sides = new Triplet<>(sidesLength.get(0), sidesLength.get(1), sidesLength.get(2));
        } catch (NumberFormatException e) {
            throw new ExceptionTriangle();
        }
    }
}
