package com.codecool.linkedList;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    public void shouldContainOneElement() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.append(9);
        assertEquals(1, linkedList.size());
    }

    @Test
    public void shouldContainFiveElement() {
        SinglyLinkedList linkedList = createList(5);
        assertEquals(5, linkedList.size());
    }

    @Test
    public void shouldContainThreeElementsAfterInsert() {
        SinglyLinkedList linkedList = createList(2);
        linkedList.insert(0, 99);
        assertEquals(3,linkedList.size());
    }

    @Test
    public void shouldInsert99onFirstPosition() {
        SinglyLinkedList linkedList = createList(20);
        linkedList.insert(1, 99);
        assertEquals( 0, linkedList.head.data);
        assertEquals( 99, linkedList.head.next.data);
        assertEquals( 1, linkedList.head.next.next.data);
        assertEquals(21,linkedList.size());
    }

    @Test
    public void shouldRemoveFirst() {
        SinglyLinkedList linkedList = createList(20);
        linkedList.insert(1, 99);
        linkedList.removeIndex(1);
        assertEquals( 0, linkedList.head.data);
        assertEquals( 1, linkedList.head.next.data);
        assertEquals(20, linkedList.size());
    }

    @Test
    public void shouldContainFourElementsAfterRemove() {
        SinglyLinkedList linkedList = createList(5);
        linkedList.removeIndex(4);
        assertEquals(4,linkedList.size());
    }

    @Test
    public void shouldRemoveData() {
        SinglyLinkedList linkedList = createList(5);
        linkedList.append(2);
        linkedList.removeData(2);
        linkedList.insert(0,2);
        linkedList.removeData(2);
        assertEquals(4,linkedList.size());
    }

    @Test
    public void shoudIterateTheList() {
        SinglyLinkedList myList = createList(4);
        String nodeCollection = "";

        Iterator myListIterator = myList.iterate();

        while(myListIterator.hasNext()) {
            nodeCollection += myListIterator.next();
        }
        assertEquals("0123", nodeCollection);
    }


    private SinglyLinkedList createList(int size) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        for(int i = 0; i < size; i++) {
            linkedList.append(i);
        }
        return linkedList;
    }







}