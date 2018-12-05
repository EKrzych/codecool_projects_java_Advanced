package com.codecool.formatter;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TableOutputFormatter implements OutputFormatter {
    @Override
    public void printToConsole(List<String> data) {
       for(String d : data) {
           for(String s: d.split(",")) {
               System.out.format("|%25s", s);
           }
           System.out.println("|");
       }
    }
}