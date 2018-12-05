package com.codecool.linkedList;

import java.util.Iterator;

public class DoublyLinkListIterator implements Iterator<DoubleLinkNode> {
    private DoubleLinkNode currentFromHead;
    private DoubleLinkNode currentFromTail;


    public DoublyLinkListIterator(DoubleLinkNode currentFromHead, DoubleLinkNode currentFromTail) {
        this.currentFromHead = currentFromHead;
        this.currentFromTail = currentFromTail;
    }

    @Override
    public boolean hasNext() {
        return currentFromHead != null;
    }

    @Override
    public DoubleLinkNode next() {
        DoubleLinkNode node = currentFromHead;
        currentFromHead = currentFromHead.next;
        return node;
    }

    public boolean hasPrevious() {
        return currentFromTail != null;
    }


    public DoubleLinkNode previous() {
        DoubleLinkNode node = currentFromTail;
        currentFromTail = currentFromTail.previous;
        return node;
    }
}
