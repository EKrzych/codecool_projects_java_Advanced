package com.codecool;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class PredicateFactory {

    Predicate<String[]> generatePredicate(String predicatesInString, Map<String, Integer> header) {
        if (predicatesInString.contains("<>")) {
            String[] tocompare = predicatesInString.trim().split("<>");
            int index = header.get(tocompare[0]);
            return x -> !(Integer.valueOf(x[index]).equals(Integer.valueOf(tocompare[1])));
        } else if (predicatesInString.contains(">")) {
            String[] tocompare = predicatesInString.trim().split(">");
            int index = header.get(tocompare[0]);
            return x -> Integer.valueOf(x[index]) > Integer.valueOf(tocompare[1]);
        } else  if (predicatesInString.contains("<")) {
            String[] tocompare = predicatesInString.trim().split("<");
            int index = header.get(tocompare[0]);
            return x -> Integer.valueOf(x[index]) < Integer.valueOf(tocompare[1]);
        } else if (predicatesInString.contains("==")) {
            String[] tocompare = predicatesInString.trim().split("==");
            int index = header.get(tocompare[0]);
            return x -> Integer.valueOf(x[index]).equals(Integer.valueOf(tocompare[1]));
        } else if (predicatesInString.toLowerCase().contains("like")) {
            String[] tocompare = predicatesInString.trim().split(" like ");
            int index = header.get(tocompare[0]);
            return x -> x[index].toLowerCase().contains(tocompare[1].trim());
        }
        return null;
    }
    

    public Predicate<?> generatePredicatesWithAnd(String predicatesInString, Map<String,Integer> header) {
        List<String> predicatesStrings = Arrays.asList(predicatesInString.toLowerCase().split(" and "));
        List <Predicate<String[]>> predicates = predicatesStrings.stream().map((n) -> generatePredicate(n,header)).collect(Collectors.toList());
        return predicates.stream().reduce(Predicate::and).orElse(x->true);
    }

    public Predicate<?> generatePredicatesWithOr(String predicatesInString, Map<String,Integer> header) {
        List<String> predicatesStrings = Arrays.asList(predicatesInString.toLowerCase().split(" or "));
        List <Predicate<String[]>> predicates = predicatesStrings.stream().map((n) -> generatePredicate(n,header)).collect(Collectors.toList());
        return predicates.stream().reduce(Predicate::or).orElse(x->false);
    }

    public Predicate<?> generatePredicatesWithMultiplePredicates(String predicatesInString, Map<String,Integer> header) {
        //dwa filtry??
        if(predicatesInString.contains(" and ")) {
            return generatePredicatesWithAnd(predicatesInString, header);
        } else if(predicatesInString.contains(" or ")) {
            return generatePredicatesWithOr(predicatesInString, header);
        }
        return null;
    }
}
