package com.eason.magictriangle;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TriangleApp {
    public static void main(String[] args) {
        System.out.println("欢迎使用魔幻三角小程序！");
        System.out.println("请您需要判断的三角形的三条整数边长(如2,3,4):");
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.next();
            String output = "您输入的三条边长为[" + input + "], ";
            try {
                List<String> sides = Arrays.asList(input.split(","));
                final Triangle triangle = new Triangle(sides);
                System.out.println(output + "可构成" + triangle.getType().typeName);
            } catch (ExceptionTriangle exceptionTriangle) {
                System.out.println(output + "不能构成三角形");
            }
        }
    }
}
