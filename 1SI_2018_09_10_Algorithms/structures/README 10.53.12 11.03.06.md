# Structures
In this project we were supposed to implement the following structures:

## Dynamic array 
Your task now is to make a dynamic array based on a static array. You have to store the data in a static array, but it's hidden, and the user of your class doesn't even know about it since she can simply put more and more elements into the dynamic array.

## Linked List
Requirements: 
- Implement a SinglyLinkedList (nodes only reference the next node in the list)
- Implement a DoublyLinkedList (nodes have a reference for both the previous and next node in the list)
- Write unit tests (for example: head / tail / length / insert / remove / iterate)

## Stack
Requirements:

- it should be generic
- the size should be given in the constructor (no default constructor allowed)
- push functionality (when I add an item to the stack)
- pop functionality (when I remove an item)
- peek functionality (I can receive the top item without removing it from the stack, so it's peeking)
- I want to be able to get the size of the stack (I mean the maximum capacity)
- nd write me a method which gives back the number of free spaces left
- throw an exception when the stack is full and I want to add one more item
- throw an exception when the stack is empty and I want to pop an item
- Unit tests!!

## Queue
1) Create a class for a queue, that can store Strings. Please don't use any collection inside that queue, a Node class should be used instead:

Three methods should be implemented:

public void enqueue (String value);
public String peek();
public String dequeue();
HINT: Highlight below hint only if you lost all hope! ;)

Use in CustomQueue two pointers - head and tail - that point to first and last Node of the queue respectively:

private Node head;

private Node tail;

2) Add two new methods to our CustomQueue class:

public int queueSize();
public bool isEmpty();
as well as error handling in situation when a queue is empty and a user tries to dequeue() or peak()

3) We need to upgrade our CustomClass functionality by adding priority! So, please

a) add a priority field to our Node class,

b) think about what should be changed in out CustomQueue functionality to meet new criteria

c) Alter CustomQueue enqueue() method:

public void enqueue (String value, Integer priority);