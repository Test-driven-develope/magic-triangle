package com.eason.magictriangle.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Triangle {
    private TriangleType type;
    private int firstSideLength;
    private int secondSideLength;
    private int thirdSideLength;
    
    public Triangle(List<String> sides) {
        separateSides(sides);
        if (!isTriangle()) {
            throw new ExceptionTriangle();
        }
        this.type = judgeType();
    }
    
    public TriangleType getType() {
        return type;
    }
    
    private TriangleType judgeType() {
        if (isEquilateral()) {
            return TriangleType.EQUILATERAL;
        }
        
        if (isIsosceles()) {
            return TriangleType.ISOSCELES;
        }
        
        if (isRight()) {
            return TriangleType.RIGHT;
        }
        
        return TriangleType.NORMAL;
    }
    
    private boolean isRight() {
        return (firstSideLength * firstSideLength + secondSideLength * secondSideLength) == thirdSideLength * thirdSideLength;
    }
    
    private boolean isIsosceles() {
        return firstSideLength == secondSideLength || secondSideLength == thirdSideLength || firstSideLength == thirdSideLength;
    }
    
    private boolean isEquilateral() {
        return firstSideLength == secondSideLength && secondSideLength == thirdSideLength;
    }
    
    private boolean isTriangle() {
        return (firstSideLength + secondSideLength > thirdSideLength) && (firstSideLength + thirdSideLength > secondSideLength) && (secondSideLength + thirdSideLength > firstSideLength);
    }
    
    private void separateSides(List<String> sides) {
        try {
            final List<Integer> sidesLength = sides.stream().map(Integer::valueOf).sorted().collect(Collectors.toList());
            if (sidesLength.size() != 3) {
                throw new ExceptionTriangle();
            }
            this.firstSideLength = sidesLength.get(0);
            this.secondSideLength = sidesLength.get(1);
            this.thirdSideLength = sidesLength.get(2);
        } catch (NumberFormatException e) {
            throw new ExceptionTriangle();
        }
    }
    
}
