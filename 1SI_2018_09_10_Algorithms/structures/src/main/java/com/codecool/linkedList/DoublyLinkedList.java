package com.codecool.linkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList {
    DoubleLinkNode head;
    private int length = 0;
    DoubleLinkNode last;

    public void append(int data) {
        DoubleLinkNode appendedNode = new DoubleLinkNode(data);
        if(head==null) {
            head = appendedNode;
            last = appendedNode;
            length++;
        } else {
            last.next = appendedNode;
            appendedNode.previous = last;
            last = appendedNode;
            length++;
        }
    }

    public int size() {
        return this.length;
    }

    public void insert(int index, int data) {
        DoubleLinkNode appendedNode = new DoubleLinkNode(data);

        if(index > length || index < 0) {
            throw new NoSuchElementException();
        }

        if(index == 0) {
            appendedNode.next = head;
            head = appendedNode;
            DoubleLinkNode lastNode = head;

            while(lastNode.next != null) {
                lastNode = lastNode.next;
            }
            last = lastNode;
        } else {
            DoubleLinkNode current = head;
            int position = 0;

            while(position != index-1) {
                current = current.next;
                position++;
            }
            appendedNode.next = current.next;
            current.next = appendedNode;
            appendedNode.previous = current;
        }
        length++;
    }

    public void removeIndex(int index) {
        if(index > length || index < 0) {
            throw new NoSuchElementException();
        }
        if(index==0){
            head = head.next;
            head.previous = null;
        } else {
            DoubleLinkNode current = head;
            int position = 0;

            while(position != index-1) {
                current = current.next;
                position++;
            }

            current.next = current.next.next;
            if(current.next == null){
                last = current;
            } else {
                current.next.previous = current;
            }
        }
        length--;
    }

    public void removeData(int data) {
        DoubleLinkNode current = head;
        int position = 0;

        if (current.data == data) {
            head = current.next;
            head.previous = null;
            length--;
        }

        while (position < length-1) {

            if (current.next.data == data) {
                current.next = current.next.next;
                if(current.next == null){
                    last = current;
                } else {
                    current.next.previous = current;
                }
                length--;
            }
            current = current.next;
            position++;
        }
    }

    public DoublyLinkListIterator iterate() {
        return new DoublyLinkListIterator(this.head, this.last);
    }
}
