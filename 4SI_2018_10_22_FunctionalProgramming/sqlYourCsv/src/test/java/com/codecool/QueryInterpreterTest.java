package com.codecool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QueryInterpreterTest {

    @Autowired
    QueryInterpreter queryInterpreter;


    @Test
    public void shoudFindFileName() throws Exception {
        String query = "Select * From test.csv";
        assertEquals("test.csv", queryInterpreter.getFilePath(query));
    }

//    @Test(expected=NoFileNameException.class)
////    public void shouldThrowNoFileNameException() throws Exception{
////        String query = "Select * From ";
////        queryInterpreter.getFilePath(query);
////    }

    @Test
    public void shouldFindcolumns() throws Exception {
        String query = "Select name,surname From test.csv";
        List<String> columnListFromQuery = queryInterpreter.getColumnsNameToDisplay(query);
        List<String> columnList = Arrays.asList("name", "surname");
        assertEquals("name", columnListFromQuery.get(0));
        assertEquals("surname", columnListFromQuery.get(1));
    }



}