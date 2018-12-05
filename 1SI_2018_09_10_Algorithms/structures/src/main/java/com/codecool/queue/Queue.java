package com.codecool.queue;

public class Queue {
    private Node head;
    private Node tail;
    private int length;

    public void enqueue(String text, Integer priority) {
        Node current = head;
        Node node = new Node(text, priority);
        if(head == null && tail == null) {
            head = tail = node;
        } else if (priority >= 3) {
            tail.setNextNode(node);
            tail = node;
        } else {
            if(head.getPriority() > node.getPriority()) {
                node.setNextNode(current);
                head = node;
            } else {
                while (current.getNextNode() != null && current.getNextNode().getPriority() <= priority) {
                    current = current.getNextNode();
                }
                node.setNextNode(current.getNextNode());
                current.setNextNode(node);

            }
        }
        length++;
    }

    public void enqueue(String text) {
        enqueue(text, 3);
    }

    public String peek() throws EmptyQueueException {
        if(head==null) {
            throw new EmptyQueueException();
        }
        return head.getValue();
    }

    public String dequeue() throws EmptyQueueException {
        if(head==null) {
            throw new EmptyQueueException();
        }
        String value = head.getValue();
        head = head.getNextNode();
        length--;
        return value;
    }

    public int getSize() {
        return this.length;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }
}
