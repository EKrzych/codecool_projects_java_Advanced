package com.codecool;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
@Component
public class FileReader {

    List<String> readData(Path path) {
        List<String> dataFromFile = new LinkedList<>();
        try(BufferedReader br = Files.newBufferedReader(path)) {
            String line = br.readLine();

            while (line != null) {
                dataFromFile.add(line);

                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataFromFile;
    }
}
