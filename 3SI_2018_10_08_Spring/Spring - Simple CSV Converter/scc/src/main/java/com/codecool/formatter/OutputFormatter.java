package com.codecool.formatter;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface OutputFormatter {
    void printToConsole(List<String> data);
}
