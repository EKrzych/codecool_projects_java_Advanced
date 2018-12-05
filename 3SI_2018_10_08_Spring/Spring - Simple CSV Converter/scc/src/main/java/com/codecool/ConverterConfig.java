package com.codecool;

import com.codecool.formatter.JsonOutputFormatter;
import com.codecool.formatter.OutputFormatterFactory;
import com.codecool.formatter.TableOutputFormatter;
import com.codecool.formatter.XmlOutputFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.codecool")
@ComponentScan("formatter")
public class ConverterConfig {
    @Bean
    FileReader filereader() {
        return new FileReader();
    }
    @Bean
    SimpleCsvConverter simpleCsvConverter() {
        return new SimpleCsvConverter(filereader(), outputFormatterFactory());
    }
    @Bean
    OutputFormatterFactory outputFormatterFactory() {
         return new OutputFormatterFactory();
    }
    @Bean
    JsonOutputFormatter jsonOutputFormatter() {
        return new JsonOutputFormatter();
    }
    @Bean
    TableOutputFormatter tableOutputFormatter() {
        return new TableOutputFormatter();
    }
    @Bean
    XmlOutputFormatter xmlOutputFormatter() {
        return new XmlOutputFormatter();
    }
}
