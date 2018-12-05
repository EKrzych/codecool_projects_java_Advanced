package com.codecool.stack;

public class Stack<E> {
    E[] myStack;

    public Stack(int size) {
        this.myStack =  (E[])new Object[size];
    }

    public int getSize() {
        return myStack.length;
    }

    public void push(E item) throws StackOverFlowException {
        for(int i = 0; i < myStack.length; i++) {
            if(myStack[i] == null) {
                myStack[i] = item;
                return;
            }
        }
        throw new StackOverFlowException();
    }

    public E pop() throws StackUnderFlowException {
        E temp;
        for(int i = myStack.length - 1; i >= 0; i--) {
            if(myStack[i] != null) {
                temp = myStack[i];
                myStack[i] = null;
                return temp;
            }
        }
        throw new StackUnderFlowException ();
    }

    public E peek() throws StackUnderFlowException {
        for(int i = myStack.length - 1; i >= 0; i--) {
            if (myStack[i] != null) {
                return myStack[i];
            }
        }
        throw new StackUnderFlowException ();
    }

    public int checkFreeSpaces() {
        for(int i = 0; i < myStack.length; i++) {
            if (myStack[i] == null) {
                return myStack.length - i;
            }
        }
        return 0;
    }
}
