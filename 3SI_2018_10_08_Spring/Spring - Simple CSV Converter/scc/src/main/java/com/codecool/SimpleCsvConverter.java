package com.codecool;

import com.codecool.formatter.OutputFormatter;
import com.codecool.formatter.OutputFormatterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Component
public class SimpleCsvConverter {
    @Autowired
    private FileReader fileReader;
    @Autowired
    private OutputFormatterFactory outputFormatterFactory;
    @Autowired
    private OutputFormatter outputFormatter;

    public SimpleCsvConverter(FileReader fileReader, OutputFormatterFactory outputFormatterFactory) {
        this.fileReader = fileReader;
        this.outputFormatterFactory = outputFormatterFactory;
    }

    void convert(Path path, OutputFormat outputFormat) {
        outputFormatterFactory.setOutputFormat(outputFormat);
        setOutputFormatter();
        outputFormatter.printToConsole(fileReader.readData(path));
    }

    void convert(Path path) {
        convert(path, OutputFormat.TABLE);
    }

    @Autowired
    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Autowired
    public void setOutputFormatterFactory(OutputFormatterFactory outputFormatterFactory) {
        this.outputFormatterFactory = outputFormatterFactory;
    }

    private void setOutputFormatter() {
        this.outputFormatter = this.outputFormatterFactory.createByFormat();
    }
}
