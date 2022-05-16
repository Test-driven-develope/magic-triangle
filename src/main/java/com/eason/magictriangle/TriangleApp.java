package com.eason.magictriangle;

import com.eason.magictriangle.domain.ExceptionTriangle;
import com.eason.magictriangle.domain.Triangle;
import org.javatuples.Triplet;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
                final Triangle triangle = new Triangle(parseInput(input));
                System.out.printf(OUTPUT_NORMAL, input, triangle.getType().typeName);
            } catch (ExceptionTriangle | NumberFormatException | InputException exception) {
                System.out.printf(OUTPUT_ERROR, input);
            }
        }
    }

    public static Triplet<Integer, Integer, Integer> parseInput(String input) throws InputException {
        List<Integer> sides = Arrays.stream(input.split(","))
                .map(Integer::valueOf).sorted().collect(Collectors.toList());
        if (sides.size() != 3 || sides.stream().anyMatch(side -> side < 0)) {
            throw new InputException();
        }
        return new Triplet<>(sides.get(0), sides.get(1), sides.get(2));
    }
}
