package com.eason.magictriangle;

import java.util.Scanner;

import org.javatuples.Triplet;

public class TriangleApp {
    private static final String MESSAGE = "欢迎使用魔幻三角小程序！\n" +
            "请您需要判断的三角形的三条整数边长(如2,3,4):";
    private static final String OUTPUT_NORMAL = "您输入的三条边长为[%s], 可构成%s";
    private static final String OUTPUT_ERROR = "您输入的三条边长为[%s], 不能构成三角形";

    public static void main(String[] args) {
        System.out.println(MESSAGE);
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.next();
            try {
                final Triplet<Integer, Integer, Integer> sides = ParseUtils.parseInput(input);
                // 如果实现了，请打开这个注释
//                final Triangle triangle = new Triangle(sides);
//                System.out.printf(OUTPUT_NORMAL, input, triangle.getType().typeName);
                // 打开上面的注释后，请注释掉这个注释
                if (input.equals("2,3,4")) {
                    System.out.printf(OUTPUT_NORMAL, input, "常规三角形");
                } else {
                    System.out.printf(OUTPUT_ERROR, input);
                }
            } catch (NumberFormatException | InputException exception) {
                System.out.printf(OUTPUT_ERROR, input);
            }
        }
    }
}
