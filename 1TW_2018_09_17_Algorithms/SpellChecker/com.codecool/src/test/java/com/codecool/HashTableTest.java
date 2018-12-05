package com.codecool;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

    @Test
    public void shouldAddElement() {
        HashTable hashTable = new HashTable(10, new BetterStringHasher());
        hashTable.add("first");
        assertTrue(hashTable.lookup("first"));
    }

    @Test
    public void shouldNOTfindElement() {
        HashTable hashTable = new HashTable(10, new BetterStringHasher());
        hashTable.add("first");
        assertFalse(hashTable.lookup("second"));
}

    @Test
    public void shouldRemoveWhenExist() {
        HashTable hashTable = new HashTable(10, new BetterStringHasher());
        hashTable.add("first");
        hashTable.add("second");
        hashTable.remove("first");
        assertFalse(hashTable.lookup("first"));
        hashTable.add("first");
        assertTrue(hashTable.lookup("first"));
        hashTable.remove("second");
        assertFalse(hashTable.lookup("second"));

    }

}