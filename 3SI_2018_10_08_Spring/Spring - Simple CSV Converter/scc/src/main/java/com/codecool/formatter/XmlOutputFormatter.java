package com.codecool.formatter;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class XmlOutputFormatter implements OutputFormatter {
    @Override
    public void printToConsole(List<String> data) {
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        System.out.println("<root>");
        String[] header = data.get(0).split(",");
        for(int i = 1; i < data.size(); i++) {
            String[] row = data.get(i).split(",");
            System.out.print("\n<row>");
            for (int j = 0; j < header.length; j++) {
                System.out.format("\n\t<%1$s>%2$s</%1$s>", header[j], row[j]);

            }
            System.out.println("\n</row>");
        }
        System.out.println("\n</root>");
    }
}