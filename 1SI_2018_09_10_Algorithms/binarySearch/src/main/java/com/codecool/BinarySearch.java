package com.codecool;

public class BinarySearch {

    public boolean search(int [] sortedArray, int value) {
        int begin = 0;
        int end = sortedArray.length-1;

        while(begin <= end) {
            int middle = (begin+end)/2;
            if(sortedArray[middle] == value) {
                return true;
            } else if(value < sortedArray[middle]){
                end = middle -1;
            } else {
                begin = middle +1;
            }
        }
        return false;
    }

}
