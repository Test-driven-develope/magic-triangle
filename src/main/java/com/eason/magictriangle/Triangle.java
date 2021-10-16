package com.eason.magictriangle;

import java.util.List;
import java.util.stream.Collectors;

public class Triangle {
    private String name;
    private int firstSideLength;
    private int secondSideLength;
    private int thirdSideLength;
    
    public Triangle(List<String> sides) {
        separateSides(sides);
        if (!isTriangle()) {
            throw new ExceptionTriangle();
        }
        this.name = "常规三角形";
    }
    
    public String getName() {
        return this.name;
    }
    
    private boolean isTriangle() {
        return (firstSideLength + secondSideLength > thirdSideLength) && (firstSideLength + thirdSideLength > secondSideLength) && (secondSideLength + thirdSideLength > firstSideLength);
    }
    
    private void separateSides(List<String> sides) {
        try {
            final List<Integer> sidesLength = sides.stream().map(Integer::valueOf).collect(Collectors.toList());
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
