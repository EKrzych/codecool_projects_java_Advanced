package com.codecool;

import com.codecool.exception.EmptyFileException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    FileReader fileReader;

    @Autowired
    QueryInterpreter queryInterpreter;

    @Test
    public void shouldgetHeader() throws Exception {
        String path = "/Users/elzbietakrzych/Documents/codecool/ADVANCED/2018_10_22_SI/sqlYourCsv/src/main/resources/students.csv";



        assertEquals("name,surname,favouritePet,age", fileReader.readHeader(path));
    }

//    @Test(expected=EmptyFileException.class)
//    public void shouldThrowExceptionWhenEmptyFile() throws Exception{
//        String path = "/Users/elzbietakrzych/Documents/codecool/ADVANCED/2018_10_22_SI/sqlYourCsv/src/main/resources/empty.csv";
//        fileReader.readHeader(path);
//    }


}
