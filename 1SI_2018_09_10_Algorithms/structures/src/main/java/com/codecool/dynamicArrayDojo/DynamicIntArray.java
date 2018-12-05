package com.codecool.dynamicArrayDojo;

public class DynamicIntArray {
    int [] array = new int[0];

    public DynamicIntArray(int size) {
        this.array = new int[size];
    }

    public DynamicIntArray() {
    }

    public void add(int numberToAdd) {
        if(this.array.length == 0) {
            this.array = new int[1];
            array[0]= numberToAdd;
        } else {
            int[] myNewArr = new int[this.array.length+1];
            for(int i = 0; i < array.length; i++) {
                myNewArr[i] = array[i];
            }
            myNewArr[this.array.length] = numberToAdd;
            this.array = myNewArr;
        }
    }

    public void remove(int index) {
        int j = 0;
        if(this.array.length == 0 || index < 0 || index >= this.array.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            int [] myNewArray = new int [this.array.length-1];
            for (int i = 0; i <array.length; i++) {
                if (i == index) {
                    continue;
                }else {
                    myNewArray[j] = this.array[i];
                    j++;
                }
            }
            this.array = myNewArray;
        }
    }

    public void insert(int index, int value) {
        if(this.array.length == 0 || index >= this.array.length) {
            this.add(value);
        } else {
            int[] myNewArray = new int [array.length + 1];
            for(int i = 0, j = 0; i < array.length ; i++, j++) {
                if(i == index) {
                    myNewArray[j] = value;
                    j++;
                    myNewArray[j] = array[i];
                } else {
                    myNewArray[j] = array[i];
                }
            }
            this.array = myNewArray;
        }
    }

    @Override
    public String toString() {
        String arrayAsString ="";
        for(int i = 0; i < this.array.length; i++) {
            arrayAsString += " " + array[i];
        }
        return arrayAsString;
    }
}
