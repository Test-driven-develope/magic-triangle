package com.eason.magictriangle.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Triangle {
    private final TriangleType type;
    public int firstSide;
    public int secondSide;
    public int thirdSide;

    public Triangle(List<String> sides) {
        separateSides(sides);

        type = getTriangleType();
    }

    public TriangleType getType() {
        return type;
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
            this.firstSide = sidesLength.get(0);
            this.secondSide = sidesLength.get(1);
            this.thirdSide = sidesLength.get(2);
        } catch (NumberFormatException e) {
            throw new ExceptionTriangle();
        }
    }
}
