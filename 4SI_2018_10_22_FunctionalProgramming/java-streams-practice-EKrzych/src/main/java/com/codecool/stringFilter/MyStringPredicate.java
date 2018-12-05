package com.codecool.stringFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MyStringPredicate {

    public Predicate<String> shoudStartWithA () {
        return n -> n.startsWith("a");
    }

    public Predicate<String> shoudEndsWithA () {
        return n -> n.endsWith("a");
    }

    public Predicate<String> shoudContainC () {
        return n -> n.contains("c");
    }

    public List<Predicate<String>> getPredicateList() {
        List<Predicate<String>> predicates = new ArrayList<>();
        predicates.add(this.shoudStartWithA());
        predicates.add(this.shoudEndsWithA());
        predicates.add(this.shoudContainC());

        return predicates;
    }
}
