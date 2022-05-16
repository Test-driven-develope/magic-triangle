package com.eason.magictriangle;

import com.eason.magictriangle.domain.ExceptionTriangle;
import com.eason.magictriangle.domain.Triangle;
import org.javatuples.Triplet;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TriangleApp {
    public static void main(String[] args) {
        System.out.println("欢迎使用魔幻三角小程序！");
        System.out.println("请您需要判断的三角形的三条整数边长(如2,3,4):");
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.next();
            String output = "您输入的三条边长为[" + input + "], ";
            try {
                List<Integer> sides = Arrays.stream(input.split(","))
                        .map(Integer::valueOf).sorted().collect(Collectors.toList());
                if (sides.size() == 3 && sides.stream().noneMatch(side -> side < 0)) {
                    final Triangle triangle = new Triangle(new Triplet<>(sides.get(0), sides.get(1), sides.get(2)));
                    System.out.println(output + "可构成" + triangle.getType().typeName);
                } else {
                    throw new ExceptionTriangle();
                }
            } catch (ExceptionTriangle | NumberFormatException exception) {
                System.out.println(output + "不能构成三角形");
            }
        }
    }
}
