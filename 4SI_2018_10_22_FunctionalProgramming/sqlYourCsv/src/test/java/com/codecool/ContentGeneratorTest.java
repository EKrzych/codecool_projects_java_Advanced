package com.codecool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContentGeneratorTest {

    @Autowired
    QueryInterpreter queryInterpreter;

    @Autowired
    ContentGenerator contentGenerator;


    @Test
    public void shouldGenerateContentFromFile() throws Exception {
        String query = "Select name,age from /Users/elzbietakrzych/Documents/codecool/ADVANCED/2018_10_22_SI/sqlYourCsv/src/main/resources/students.csv";
        List<String[]> content = contentGenerator.generate(queryInterpreter.getFilePath(query), queryInterpreter.getColumnsNameToDisplay(query), queryInterpreter.getPredicate(query));

        assertEquals("Ela",content.get(0)[0]);
        assertEquals("12",content.get(0)[1]);
        assertEquals("Marcin",content.get(1)[0]);
        assertEquals("9",content.get(1)[1]);


    }
}