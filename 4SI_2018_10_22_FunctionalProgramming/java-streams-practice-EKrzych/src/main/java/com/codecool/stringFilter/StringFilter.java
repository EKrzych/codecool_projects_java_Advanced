package com.codecool.stringFilter;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringFilter {

    public List<String> filttr (List<Predicate<String>> rules, List<String> strings) {
        return strings.stream().filter(rules.stream().reduce(Predicate::and).orElse(x->true)).collect(Collectors.toList());
    }

    public List<String> filter(List<Predicate<String>> rules, List<String> strings, Double threshold) {
        int shouldBePassed = (int) Math.ceil(rules.size() * threshold/100);
        //strings.stream().filter(rules.stream())
        return null;
    }
}
