package com.codecool.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    @Test
    public void shouldEnqueueFirstElement() {
        Queue queue = new Queue();
        queue.enqueue("First");
        assertEquals(1, queue.getSize());
    }

    @Test
    public void shouldEnqueueElements() {
        Queue queue = new Queue();
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        assertEquals(3, queue.getSize());
        assertEquals("First", queue.getHead().getValue());
        assertEquals("Third", queue.getTail().getValue());
    }

    @Test
    public void shouldPeek() throws EmptyQueueException {
        Queue queue = new Queue();
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        assertEquals("First", queue.peek());
        assertEquals(3, queue.getSize());
        assertEquals("First", queue.peek());
        assertEquals(3, queue.getSize());
    }

    @Test
    public void shouldDeque() throws EmptyQueueException {
        Queue queue = new Queue();
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        assertEquals("First", queue.dequeue());
        assertEquals(2, queue.getSize());
        assertEquals("Second", queue.peek());
        assertEquals("Second", queue.dequeue());
        assertEquals(1, queue.getSize());
        assertEquals("Third", queue.peek());
        assertEquals("Third", queue.dequeue());
        assertEquals(0, queue.getSize());
    }

    @Test
    public void shouldThrowEmptyQueueExceptionWhenPeek() {
        Queue queue = new Queue();
        assertThrows(EmptyQueueException.class, () -> {
            queue.peek();
        });
    }

    @Test
    public void shouldThrowEmptyQueueExceptionWhenDequeue() {
        Queue queue = new Queue();
        assertThrows(EmptyQueueException.class, () -> {
            queue.dequeue();
        });
    }

    @Test
    public void shouldSetPriorityAsFirst() throws EmptyQueueException {
        Queue queue = new Queue();
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        queue.enqueue("Priority", 1);

        assertEquals("Priority", queue.peek());
        assertEquals("Priority", queue.dequeue());
        assertEquals(3, queue.getSize());
        assertEquals("First", queue.dequeue());
        assertEquals("Second", queue.dequeue());
        assertEquals("Third", queue.dequeue());
        assertEquals(0, queue.getSize());


    }

    @Test
    public void shoudEnqueElementWithPriority() throws EmptyQueueException {
        Queue queue = new Queue();
        queue.enqueue("First",2);
        queue.enqueue("Second",1);
        queue.enqueue("Third",3);
        assertEquals(3, queue.getSize());
        assertEquals("Second", queue.dequeue());
        assertEquals(2, queue.getSize());
        assertEquals("First", queue.dequeue());
        assertEquals("Third", queue.dequeue());
        assertEquals(0, queue.getSize());


    }

    @Test
    public void shouldSetPriorityAtSecond() throws EmptyQueueException {
        Queue queue = new Queue();
        queue.enqueue("First",1);
        queue.enqueue("Third",3);
        queue.enqueue("Second",2);
        queue.enqueue("Priority", 1);
        queue.enqueue("Priority2", 2);

        assertEquals(5, queue.getSize());
        assertEquals("First", queue.dequeue());
        assertEquals("Priority", queue.dequeue());
        assertEquals("Second", queue.dequeue());
        assertEquals("Priority2", queue.dequeue());
        assertEquals("Third", queue.dequeue());
        assertEquals(0, queue.getSize());
    }



}