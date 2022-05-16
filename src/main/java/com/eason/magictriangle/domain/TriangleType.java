package com.eason.magictriangle.domain;

public enum TriangleType {
    EQUILATERAL("等边三角形") {
        @Override
        public boolean isCurrentType(Triangle triangle) {
            return triangle.firstSide == triangle.secondSide
                    && triangle.secondSide == triangle.thirdSide;
        }
    },
    ISOSCELES("等腰三角形") {
        @Override
        public boolean isCurrentType(Triangle triangle) {
            return triangle.firstSide == triangle.secondSide;
        }
    },
    RIGHT("直角三角形") {
        @Override
        public boolean isCurrentType(Triangle triangle) {
            return (Math.pow(triangle.firstSide, 2) + Math.pow(triangle.secondSide, 2))
                    == Math.pow(triangle.thirdSide, 2);
        }
    }, NORMAL("常规三角形");

    public final String typeName;

    TriangleType(String typeName) {
        this.typeName = typeName;
    }

    public boolean isCurrentType(Triangle triangle) {
        return triangle.firstSide + triangle.secondSide > triangle.thirdSide;
    }
}
