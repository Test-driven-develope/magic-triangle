package com.eason.magictriangle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.javatuples.Triplet;

public class ParseUtils {
    public static Triplet<Integer, Integer, Integer> parseInput(String input) throws InputException {
        List<Integer> sides = Arrays.stream(input.split(","))
                .map(Integer::valueOf).sorted().collect(Collectors.toList());
        if (sides.size() != 3 || sides.stream().anyMatch(side -> side < 0)) {
            throw new InputException();
        }
        return new Triplet<>(sides.get(0), sides.get(1), sides.get(2));
    }
}
