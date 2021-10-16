package com.eason.magictriangle;

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
            try {
                List<Integer> sides = Arrays.asList(input.split(",")).stream().map(Integer::valueOf).collect(Collectors.toList());
                if (sides.size() != 3) {
                    System.out.println("您输入的三条边长为[" + input + "], 不能构成三角形");
                } else {
                    int firstLength = sides.get(0);
                    int secondLength = sides.get(1);
                    int thirdLength = sides.get(2);
                    if ((firstLength + secondLength > thirdLength) && (firstLength + thirdLength > secondLength) && (secondLength + thirdLength > firstLength)) {
                        System.out.println("您输入的三条边长为[" + input + "], 可构成常规三角形");
                    } else {
                        System.out.println("您输入的三条边长为[" + input + "], 不能构成三角形");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("您输入的三条边长为[" + input + "], 不能构成三角形");
            }
        }
    }
}
