package com.codecool;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueryInterpreter {

    public String getFilePath(String query) {
        String [] array = query.split(" ");
        return Arrays.stream(array).filter(s -> s.endsWith(".csv")).findFirst().orElse("NOFile");
    }

    public List<String> getColumnsNameToDisplay(String query) {
        if(query.toLowerCase().startsWith("select * ")) {
            return new ArrayList<>();
        }
        String [] array = query.split(" ");
        return Arrays.stream(array).filter(s -> s.contains(",")).map(s -> s.split(",")).flatMap(x -> Arrays.stream(x)).collect(Collectors.toList());
    }

    public String getPredicate(String query) {
        if(!query.toLowerCase().contains("where")) {
            return null;
        }
        return query.toLowerCase().split("where")[1];
    }
}
