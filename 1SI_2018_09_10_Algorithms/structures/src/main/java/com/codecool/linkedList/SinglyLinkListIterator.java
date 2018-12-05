package com.codecool.linkedList;

import java.util.Iterator;

public class SinglyLinkListIterator implements Iterator <SingleLinkNode> {
    private SingleLinkNode current;


    public SinglyLinkListIterator(SingleLinkNode head) {
        this.current = head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public SingleLinkNode next() {
        SingleLinkNode node = current;
        current = current.next;
        return node;
    }
}
