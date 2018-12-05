package com.codecool.linkedList;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    @Test
    public void shouldContainOneElement() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.append(9);
        assertEquals(1, linkedList.size());
    }

    @Test
    public void shouldContainFiveElement() {
        DoublyLinkedList linkedList = createList(5);
        assertEquals(5, linkedList.size());
    }

    @Test
    public void shouldContainThreeElementsAfterInsert() {
        DoublyLinkedList linkedList = createList(2);
        linkedList.insert(0, 99);
        assertEquals(3,linkedList.size());
    }

    @Test
    public void shouldInsert99onFirstPosition() {
        DoublyLinkedList linkedList = createList(20);
        linkedList.insert(1, 99);
        assertEquals( 0, linkedList.head.data);
        assertEquals( 99, linkedList.head.next.data);
        assertEquals( 1, linkedList.head.next.next.data);
        assertEquals(21,linkedList.size());
    }

    @Test
    public void shouldRemoveFirst() {
        DoublyLinkedList linkedList = createList(20);
        linkedList.insert(1, 99);
        linkedList.removeIndex(1);
        assertEquals( 0, linkedList.head.data);
        assertEquals( 1, linkedList.head.next.data);
        assertEquals(20, linkedList.size());
    }

    @Test
    public void shouldContainFourElementsAfterRemove() {
        DoublyLinkedList linkedList = createList(5);
        linkedList.removeIndex(0);
        assertEquals(4,linkedList.size());
    }

    @Test
    public void shouldRemoveData() {
        DoublyLinkedList linkedList = createList(5);
        linkedList.append(2);
        linkedList.removeData(2);
        linkedList.insert(0,2);
        linkedList.removeData(2);
        assertEquals(4,linkedList.size());
    }

    @Test
    public void shoudIterateTheListFromHead() {
        DoublyLinkedList linkedList = createList(5);
        String nodeCollection = "";

        Iterator myListIterator = linkedList.iterate();

        while(myListIterator.hasNext()) {
            nodeCollection += myListIterator.next();
        }
        assertEquals("01234", nodeCollection);
    }

    @Test
    public void shoudIterateTheListFromTail() {
        DoublyLinkedList linkedList = createList(5);
        String nodeCollection = "";

        DoublyLinkListIterator myListIterator = linkedList.iterate();

        while(myListIterator.hasPrevious()) {
            nodeCollection += myListIterator.previous();
        }
        assertEquals("43210", nodeCollection);
    }

    private DoublyLinkedList createList(int size) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        for(int i = 0; i < size; i++) {
            linkedList.append(i);
        }
        return linkedList;
    }



}