package com.codecool;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ConverterApplication {
    private static Path csvFilePath;
    private static OutputFormat outputFormat;

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("ConverterConfig.class");
        SimpleCsvConverter simpleCsvConverter = (SimpleCsvConverter) context.getBean("SimpleCsvConverter.class");

        if(args.length == 0) {
            System.out.println("No input file defined ");
        } else {
            csvFilePath = Paths.get(args[args.length-1]);
            if (args.length == 1) {

                simpleCsvConverter.convert(csvFilePath);

            } else if (args.length == 2) {
                outputFormat = OutputFormat.valueOf(args[args.length-2].toUpperCase());
                simpleCsvConverter.convert(csvFilePath,outputFormat);

            } else {

                System.out.println("To many parameters");
            }
        }
    }
}

//    PropertySource theSource = new SimpleCommandLinePropertySource(args);
//    AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        context.getEnvironment().getPropertySources().addFirst(theSource);
//        String[] nonOptionArgs = context.getEnvironment().getProperty("nonOptionArgs", String[].class);
//    SimpleCsvConverter simpleCsvConverter = (SimpleCsvConverter) context.getBean("simpleCsvConverter");

