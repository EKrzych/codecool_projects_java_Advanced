package com.codecool.stringFilter;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class StringFilterTest {

    @Test
    public void shouldPassAllPredicates() {
        List<String> strings = Arrays.asList("aca", "aaa", "accccccccca");
        List<Predicate<String>> predicates = new MyStringPredicate().getPredicateList();
        assertEquals("aca", new StringFilter().filttr(predicates,strings).get(0));
        assertEquals("accccccccca", new StringFilter().filttr(predicates,strings).get(1));
        assertFalse(new StringFilter().filttr(predicates,strings).contains("aaa"));
    }

    @Test
    public void shouldPass50PercPredicates() {
        List<String> strings = Arrays.asList("aca", "aaa", "accccccccca");
        List<Predicate<String>> predicates = new MyStringPredicate().getPredicateList();
        assertEquals("aca", new StringFilter().filter(predicates,strings,50D).get(0));
        assertEquals("accccccccca", new StringFilter().filter(predicates,strings,50D).get(1));
        assertTrue(new StringFilter().filter(predicates,strings,50D).contains("aaa"));
    }

}