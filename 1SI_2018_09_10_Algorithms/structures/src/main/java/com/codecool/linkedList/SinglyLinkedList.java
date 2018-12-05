package com.codecool.linkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList {
    SingleLinkNode head;
    private int length = 0;
    SingleLinkNode last;


    public void append(int data) {
        SingleLinkNode appendedNode = new SingleLinkNode(data);
        if(head==null) {
            head = appendedNode;
            last = appendedNode;
            length++;
        } else {
            last.next = appendedNode;
            last = appendedNode;
            length++;
        }
    }

    public void insert(int index, int data) {
        SingleLinkNode appendedNode = new SingleLinkNode(data);

        if(index > length || index < 0) {
            throw new NoSuchElementException();
        }

        if(index == 0) {
            appendedNode.next = head;
            head = appendedNode;
            SingleLinkNode lastNode = head;

            while(lastNode.next != null) {
                lastNode = lastNode.next;
            }
            last = lastNode;
        } else {
            SingleLinkNode current = head;
            int position = 0;

            while(position != index-1) {
                current = current.next;
                position++;
            }
            appendedNode.next = current.next;
            current.next = appendedNode;
        }
        length++;
    }

    public void removeIndex(int index) {
        if(index > length || index < 0) {
            throw new NoSuchElementException();
        }
        if(index==0){
            head = head.next;
        } else {
            SingleLinkNode current = head;
            int position = 0;

            while(position != index-1) {
                current = current.next;
                position++;
            }
            current.next = current.next.next;
        }
        length--;
    }

    public void removeData(int data) {
        SingleLinkNode current = head;
        int position = 0;

        if (current.data == data) {
            head = current.next;
            length--;
        }

        while (position < length-1) {

            if (current.next.data == data) {
                current.next = current.next.next;
                length--;
            }
            current = current.next;
            position++;
        }
    }

    public int size() {
        return this.length;
    }

    public Iterator<SingleLinkNode> iterate() {
        return new SinglyLinkListIterator(this.head);
    }
}
