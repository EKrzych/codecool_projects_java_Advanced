package com.codecool.formatter;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class JsonOutputFormatter implements OutputFormatter {

    @Override
    public void printToConsole(List<String> data) {
        String[] header = data.get(0).split(",");
        JsonArray allData = new JsonArray();

        for(int i = 1; i < data.size(); i++) {
            JsonObject jsonObject = new JsonObject();
            String[] row = data.get(i).split(",");
            for(int j = 0; j < header.length; j++ ) {
                jsonObject.addProperty(header[j],row[j]);
            }
            allData.add(jsonObject);
        }
        System.out.println(allData);
    }
}
