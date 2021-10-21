package com.eason.magictriangle.domain;

public enum TriangleType {
    NORMAL("常规三角形"), EQUILATERAL("等边三角形"), ISOSCELES("等腰三角形"), RIGHT("直角三角形");
    
    public final String typeName;
    
    TriangleType(String typeName) {
        this.typeName = typeName;
    }
}
