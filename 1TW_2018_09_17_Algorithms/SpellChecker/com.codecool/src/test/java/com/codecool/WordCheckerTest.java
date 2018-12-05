package com.codecool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class WordCheckerTest {
    @Mock
    WordChecker wordChecker;

    @Test
    public void shoudSwapLetters() {

        when(wordChecker.wordExists("rowe")).thenReturn(true);
        when(wordChecker.wordExists("wero")).thenReturn(false);
        System.out.println("Hello");
        System.out.println(wordChecker.getSuggestions("wero").get(0));

        assertEquals("rowe", wordChecker.getSuggestions("wero").get(0));

    }

}