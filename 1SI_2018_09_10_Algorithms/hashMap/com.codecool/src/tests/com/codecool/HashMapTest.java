package com.codecool;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {
    @Test
    public void shoudAddElement() {
        HashMap myMap = new HashMap();
        myMap.add("Ela", 1);
        assertEquals(1,(int)myMap.getValue("Ela"));
    }
}