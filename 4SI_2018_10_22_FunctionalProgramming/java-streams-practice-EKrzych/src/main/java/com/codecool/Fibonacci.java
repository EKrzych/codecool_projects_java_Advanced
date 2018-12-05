package com.codecool;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Fibonacci implements Supplier<Integer> {

    Stream<Integer> generate() {
        return Stream.iterate(new int []{0,1} , s -> new int[]{s[1], s[0] + s[1]})
                .map(n -> n[0]);
    }

    @Override
    public Integer get() {
        return null;
    }
}
