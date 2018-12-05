package com.codecool.linkedList;

public class DoubleLinkNode {
    DoubleLinkNode next;
    DoubleLinkNode previous;
    int data;

    public DoubleLinkNode(int data) {
        this.data = data;
    }

    public String toString() {
        return String.valueOf(data);
    }
}
