package com.codecool;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    @Test
    public void shouldFind() {
        int [] sortedArray = {100,200,300,400,500,600,700,800,900,1000,1400,1600,1900,2500,3500,5600,9900};
        BinarySearch searcher = new BinarySearch();
        assertTrue(searcher.search(sortedArray,100));
        assertTrue(searcher.search(sortedArray,700));
        assertTrue(searcher.search(sortedArray,800));
        assertTrue(searcher.search(sortedArray,900));
        assertTrue(searcher.search(sortedArray,1000));
        assertTrue(searcher.search(sortedArray,9900));
   }

    @Test
    public void shouldNOTFind() {
        int [] sortedArray = {100,200,300,400,500,600,700,800,900,1000,1400,1600,1900,2500,3500,5600,9900};
        BinarySearch searcher = new BinarySearch();
        assertFalse(searcher.search(sortedArray,10009));
        assertFalse(searcher.search(sortedArray,0));
        assertFalse(searcher.search(sortedArray,8000));
        assertFalse(searcher.search(sortedArray,9));
        assertFalse(searcher.search(sortedArray,1));
        assertFalse(searcher.search(sortedArray,92));
    }

}