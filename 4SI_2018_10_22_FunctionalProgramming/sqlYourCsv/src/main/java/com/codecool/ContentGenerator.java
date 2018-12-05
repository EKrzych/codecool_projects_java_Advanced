package com.codecool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ContentGenerator {
    FileReader fileReader;
    PredicateFactory predicateFactory;

    @Autowired
    public ContentGenerator(FileReader fileReader, PredicateFactory predicateFactory) {
        this.fileReader = fileReader;
        this.predicateFactory = predicateFactory;
    }



    public List<String[]> generate(String path, List<String> collumnsToDisplay, String predicatesInString) {
        Map<String, Integer> header = getHeaderMap(path);
        List<String> wholeList = fileReader.readFile(path);
        List<String[]> filteredData;
        if (predicatesInString == null) {
            filteredData = wholeList.stream().map(n -> n.split(",")).map(x -> chooseDataFromRow(collumnsToDisplay, x, header)).collect(Collectors.toList());
            return filteredData;
        } else if (predicatesInString.toLowerCase().contains(" and ") || predicatesInString.toLowerCase().contains(" or ")){
            Predicate<?> predicate = predicateFactory.generatePredicatesWithMultiplePredicates(predicatesInString, header);
            filteredData = wholeList.stream().map(n -> n.split(",")).filter((Predicate<? super String[]>) predicate).map(x -> chooseDataFromRow(collumnsToDisplay, x, header)).collect(Collectors.toList());
            return filteredData;
        } else {
            Predicate<?> predicate = predicateFactory.generatePredicate(predicatesInString, header);
            filteredData = wholeList.stream().map(n -> n.split(",")).filter((Predicate<? super String[]>) predicate).map(x -> chooseDataFromRow(collumnsToDisplay, x, header)).collect(Collectors.toList());
            return filteredData;
        }

    }


    private String[] chooseDataFromRow(List<String> columns, String[] x, Map<String, Integer> header) {
        if(columns.isEmpty()) {
            return x;
        }

        String[] temp = new String [columns.size()];
        for(int i = 0; i < columns.size(); i++) {
            temp[i] = x[header.get(columns.get(i))];
        }
       // return IntStream.range(0, columns.size()).map(i -> temp[i] = x[header.get(columns.get(i))]));
        return temp;
    }


    private Map<String,Integer> getHeaderMap(String path){
        final List<String> arrayList = Arrays.asList(fileReader.readHeader(path).split(","));
        return arrayList.stream().collect(Collectors.toMap(i->i, i -> arrayList.indexOf(i)));
    }

}
