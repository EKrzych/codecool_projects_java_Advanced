package com.codecool.formatter;

import com.codecool.OutputFormat;
import org.springframework.stereotype.Component;

@Component
public class OutputFormatterFactory {
    private OutputFormat outputFormat;

    public void setOutputFormat(OutputFormat outputFormat) {
        this.outputFormat = outputFormat;
    }

    public OutputFormatter createByFormat() {
        switch(outputFormat) {
            case TABLE:
                return new TableOutputFormatter();
            case XML:
                return new XmlOutputFormatter();
            case JSON:
                return new JsonOutputFormatter();
        }
        return null;
    }

}
