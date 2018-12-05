package com.codecool;

import java.util.LinkedList;

public class HashMap {
    private int bucketSize = 16;
    private LinkedList<KeyValue>[] hashMap = new LinkedList[bucketSize];

    public void add(String key, Integer value) {
        int position = getHash(key, bucketSize);
        LinkedList <KeyValue> list;
        if(hashMap[position] == null) {
            list = hashMap[position] = new LinkedList<>();
        } else {
            list = hashMap[position];
        }

        for(KeyValue element : list) {
            if(element.getKey() == key) {
                throw new IllegalArgumentException("Key already in map!");
            }
        }
        list.add(new KeyValue(key, value));
    }

    public Integer getValue(String key) {
        int position = getHash(key, bucketSize);
        LinkedList <KeyValue> list = hashMap[position];
        for(KeyValue element : list) {
            if(element.getKey() == key) {
                return element.getValue();
            }
        }
        throw new IllegalArgumentException("Key doesn't exist");
    }

    private int getHash(String key, int bucketSize) {
        return key.hashCode() % bucketSize;
    }
}
