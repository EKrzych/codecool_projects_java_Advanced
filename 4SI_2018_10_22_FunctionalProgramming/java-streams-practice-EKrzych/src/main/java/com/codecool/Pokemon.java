package com.codecool;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pokemon {
    public String pOkEmOnCase(String word) {
        String[] letters = word.split("");
        String newWord = IntStream.range(0, letters.length)
                .mapToObj(i -> i % 2 != 0 ? letters[i].toUpperCase() : letters[i])
                .collect(Collectors.joining());
        return newWord;
    }

    public static void main(String[] args) {
        System.out.println(new Pokemon().pOkEmOnCase("pokemon"));
    }
}
