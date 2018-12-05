package com.codecool.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    public void shouldCreateStackWith20Spaces() {
        Stack myStack = new Stack(20);
        assertEquals(20, myStack.getSize());
    }

    @Test
    public void shouldAddElement() throws StackOverFlowException {
        Stack myStack = new Stack(20);
        myStack.push("Hello1");
        myStack.push("Hello2");
        assertEquals("Hello1", myStack.myStack[0]);
        assertEquals("Hello2", myStack.myStack[1]);
    }

    @Test
    public void shouldPopElement() throws StackUnderFlowException, StackOverFlowException {
        Stack myStack = new Stack(20);
        myStack.push("Hello1");
        myStack.push("Hello2");
        assertEquals("Hello2", myStack.pop());
        assertEquals("Hello1", myStack.myStack[0]);
        assertEquals(null, myStack.myStack[1]);
    }

    @Test
    public void shouldPeekElement() throws StackOverFlowException, StackUnderFlowException {
        Stack myStack = new Stack(20);
        myStack.push("Hello1");
        myStack.push("Hello2");
        assertEquals("Hello2", myStack.peek());
        assertEquals("Hello1", myStack.myStack[0]);
        assertEquals("Hello2", myStack.myStack[1]);
    }

    @Test
    public void shouldReturnFreeSpaces() throws StackUnderFlowException, StackOverFlowException {
        Stack myStack = new Stack(5);
        myStack.push("Hello1");
        myStack.push("Hello2");
        assertEquals(3, myStack.checkFreeSpaces());
        myStack.push("Hello1");
        myStack.push("Hello2");
        myStack.push("Hello1");
        assertEquals(0, myStack.checkFreeSpaces());
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        assertEquals(5, myStack.checkFreeSpaces());

    }

    @Test
    public void shouldTrowExceptionForEmptyListWhenPopOrPeek() throws StackUnderFlowException {
        Stack myStack = new Stack(5);
        assertThrows(StackUnderFlowException.class, ()->{
            myStack.pop();
        });
    }
    @Test
    public void shouldTrowExceptionForFullListWhenPush() throws StackOverFlowException {
        Stack myStack = new Stack(3);
        myStack.push(0);
        myStack.push(1);
        myStack.push(2);
        assertThrows(StackOverFlowException.class, ()->{
            myStack.push(3);
        });
    }

}