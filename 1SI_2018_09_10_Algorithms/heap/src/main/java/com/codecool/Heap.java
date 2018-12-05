package com.codecool;

public class Heap{
    private int takenPlace;
    private int size = 10;
    private Integer [] heap = new Integer[size];

    public void add(int toAdd) {
        if(takenPlace == size) {
            resize();
        }

        if(takenPlace == 0) {
            heap[0] = toAdd;
            takenPlace++;
        } else {
            heap[takenPlace] = toAdd;
            adjustHeapStructureAfterAdding(takenPlace);
            takenPlace++;
        }
    }

    public Integer remove() {
        Integer valueRemoved = null;
        if(takenPlace >= 1) {
            valueRemoved = heap[0];
            heap[0] = heap[takenPlace-1];
            heap[takenPlace-1] = null;
            takenPlace--;
            adjustHeapStructureAfterRemovig(0);
        } else {
            heap = null;
        }
        return valueRemoved;
    }

    private void adjustHeapStructureAfterRemovig(int parentIndex) {
        if(getLeftChildIndex(parentIndex) < takenPlace-1) {
            if(getRightChildIndex(parentIndex) < takenPlace) {
                if(heap[getLeftChildIndex(parentIndex)] > heap[getRightChildIndex(parentIndex)]) {
                    int index = getRightChildIndex(parentIndex);

                    swapValues(index,parentIndex);
                    parentIndex = index;
                    adjustHeapStructureAfterRemovig(parentIndex);
                    return;
                }
            }
            int index = getLeftChildIndex(parentIndex);

            swapValues(index,parentIndex);
            parentIndex = index;
            adjustHeapStructureAfterRemovig(parentIndex);
        }
        return;
    }

    private int getRightChildIndex(int parentIndex) {
        return (parentIndex*2)+2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return (parentIndex*2)+1;
    }

    private void adjustHeapStructureAfterAdding(int index) {
        if(heap[index] >= getParentValue(index) || index == 0) {
            return;
        } else {
            int parentIndex = getParentIndex(index);
            swapValues(index, parentIndex);
            index = parentIndex;
            adjustHeapStructureAfterAdding(index);
        }
    }

    private void swapValues(int index, int parentIndex) {
        int temp = heap[parentIndex];
        heap[parentIndex] = heap[index];
        heap[index] = temp;
    }

    private int getParentIndex(int index) {
        int parentIndex = (index-2) < 0 ? 0 : (index-2)/2;
        return parentIndex;
    }

    private int getParentValue(int index) {
        return heap[getParentIndex(index)];
    }

    private void resize() {
        Integer [] biggerHeap = new Integer[2*size];
        for(int i = 0; i < size; i++) {
            biggerHeap[i] = heap[i];
        }
        heap = biggerHeap;
        size *= 2;
    }

    public Integer[] getHeap() {
        return heap;
    }


    public int getTakenPlace() {
        return takenPlace;
    }
}
