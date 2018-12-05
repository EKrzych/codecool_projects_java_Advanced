package com.codecool.controllers;

import com.codecool.ContentGenerator;
import com.codecool.QueryInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;

@RestController
@RequestMapping("/query")
public class QueryController {
    @Autowired
    QueryInterpreter queryInterpreter;

    @Autowired
    ContentGenerator contentGenerator;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<String[]> interpretQuery(@RequestBody String query) {

        return contentGenerator.generate(queryInterpreter.getFilePath(query), queryInterpreter.getColumnsNameToDisplay(query), queryInterpreter.getPredicate(query));

    }


}
