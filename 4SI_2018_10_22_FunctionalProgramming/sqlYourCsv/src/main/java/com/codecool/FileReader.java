package com.codecool;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FileReader {

    public FileReader() {
    }


    public List<String> readFile(String path) {
        List<String> lineList = new ArrayList<>();
        try{
            File file = new File(path);
            InputStream inputFS = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            // skip the header of the csv
            lineList = br.lines().skip(1).collect(Collectors.toList());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineList;
    }

    public String readHeader(String path)  {
       String header = null;
        try{
            File file = new File(path);
            InputStream inputFS = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            // skip the header of the csv
            header = br.lines().findFirst().orElse("NoFile");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return header;
    }
}
