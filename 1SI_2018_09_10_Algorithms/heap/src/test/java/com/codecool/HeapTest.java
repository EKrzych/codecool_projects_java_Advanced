package com.codecool;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {
    @Test
    public void shouldAddElemets() {
        Heap heap = new Heap();
        heap.add(1);
        heap.add(2);
        heap.add(3);

        assertEquals(1, (int)heap.getHeap()[0]);
        assertEquals(2, (int)heap.getHeap()[1]);
        assertEquals(3, (int)heap.getHeap()[2]);
        assertEquals(3, heap.getTakenPlace());
    }

    @Test
    public void shouldResize() {
        Heap heap = new Heap();
        for(int i = 0; i <= 30; i++) {
            heap.add(i);
        }

        assertEquals(0, (int)heap.getHeap()[0]);
        assertEquals(30, (int)heap.getHeap()[30]);
        assertEquals(40, heap.getHeap().length);
    }

    @Test
    public void shouldMoveElemetUp() {
        Heap heap = new Heap();
        heap.add(10);
        heap.add(20);
        heap.add(30);
        heap.add(40);
        heap.add(80);
        heap.add(70);
        heap.add(1);


        assertEquals(1, (int)heap.getHeap()[0]);
        assertEquals(30, (int)heap.getHeap()[heap.getTakenPlace()-1]);
    }

    @Test
    public void shoudRemoveFirst() {
        Heap heap = new Heap();
        heap.add(10);
        heap.add(20);
        heap.add(30);
        heap.add(40);
        heap.add(80);

        assertEquals(5, heap.getTakenPlace());
        assertEquals(10, (int)heap.remove());
        assertEquals(20, (int)heap.getHeap()[0]);

        assertEquals(20, (int)heap.remove());
        assertEquals(30, (int)heap.getHeap()[0]);
        assertEquals(3, heap.getTakenPlace());
        assertNull(heap.getHeap()[6]);

        assertEquals(30, (int)heap.remove());
        assertEquals(40, (int)heap.remove());
        assertEquals(80, (int)heap.remove());

        assertEquals(0, heap.getTakenPlace());
        assertNull(heap.remove());
    }
}