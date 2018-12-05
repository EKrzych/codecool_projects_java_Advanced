package com.codecool;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    @Autowired
    FileReader fileReader;

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

}
