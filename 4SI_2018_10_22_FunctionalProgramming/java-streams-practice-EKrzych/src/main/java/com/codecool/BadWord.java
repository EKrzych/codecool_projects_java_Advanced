package com.codecool;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BadWord {
    String[] array = {"badWord", "evenWorseWord"};
    List<String> badWords = Arrays.asList(array);

    public String censorship(String forCensorship) {
        String[] splittedString = forCensorship.split(" ");
        return Arrays.stream(splittedString).map(s -> badWords.contains(s)? "peeep " : s + " ").collect(Collectors.joining());
    }

    public static void main(String[] args) {
        BadWord bd = new BadWord();
        String toChange = "ale ela ma badWord badWord badWord evenWorseWord evenWorseWord Ale ea mama";
        System.out.println(bd.censorship(toChange));
    }
}
