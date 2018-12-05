package com.codecool.javabst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    @Test
    public void shouldCreateThree() {
        int [] myArray = {1,2,3,4,5,6,7,8,9};
        BinarySearchTree tree = new BinarySearchTree(myArray);

        assertEquals(5, tree.getRoot().getValue());
        assertEquals(2, tree.getRoot().getLeft().getValue());
        assertEquals(7, tree.getRoot().getRight().getValue());
        assertEquals(8, tree.getRoot().getRight().getRight().getValue());
        assertEquals(9, tree.getRoot().getRight().getRight().getRight().getValue());
        assertEquals(3, tree.getRoot().getLeft().getRight().getValue());
        assertEquals(4, tree.getRoot().getLeft().getRight().getRight().getValue());
        assertEquals(1, tree.getRoot().getLeft().getLeft().getValue());
        assertNull(tree.getRoot().getLeft().getLeft().getLeft());
    }

    @Test
    public void shouldFindNumbers() {
        int [] myArray = {12,13,14,15,16,17,18,25,99,2789};
        BinarySearchTree tree = new BinarySearchTree(myArray);

        assertTrue(tree.IsPresent(17));
        assertTrue(tree.IsPresent(25));
        assertTrue(tree.IsPresent(2789));
    }

    @Test
    public void shouldNOTFindNumbers() {
        int [] myArray = {56,57,67,89,99,100};
        BinarySearchTree tree = new BinarySearchTree(myArray);

        assertFalse(tree.IsPresent(11));
        assertFalse(tree.IsPresent(52));
        assertFalse(tree.IsPresent(0));
    }

    @Test
    public void shouldAddNumber() {
        int [] myArray = {1,2,3,4,5,6,7,8,9};
        BinarySearchTree tree = new BinarySearchTree(myArray);

        tree.add(10);
        assertEquals(10, tree.getRoot().getRight().getRight().getRight().getRight().getValue());

        tree.add(0);
        assertEquals(0, tree.getRoot().getLeft().getLeft().getLeft().getValue());
    }

    @Test
    public void shouldThrowExceptionWhenNumberAlreadyInTree() {
        int [] myArray = {1,2,3,4,5,6,7,8,9};
        BinarySearchTree tree = new BinarySearchTree(myArray);

        assertThrows (IllegalArgumentException.class, () -> {
            tree.add(5);
        });
    }

    @Test
    public void shouldRemoveNumber() {
        int [] myArray = {1,2,3,4,5,6,7,8,9};
        BinarySearchTree tree = new BinarySearchTree(myArray);

        tree.add(10);
        assertEquals(10, tree.getRoot().getRight().getRight().getRight().getRight().getValue());

        tree.remove(10);
        assertNull(tree.getRoot().getRight().getRight().getRight().getRight());
    }

    @Test
    public void shouldThrowExceptionWhenNumberAbsent() {
        int [] myArray = {1,2,3,4,5,6,7,8,9};
        BinarySearchTree tree = new BinarySearchTree(myArray);

        assertThrows (IllegalArgumentException.class, () -> {
            tree.remove(10);
        });
    }

    @Test
    public void shouldBeNullAfterRemovingRoot() {
        int [] myArray = {1,2,3,4,5,6,7,8,9};
        BinarySearchTree tree = new BinarySearchTree(myArray);

        tree.remove(5);

        assertNull(tree.getRoot());
    }

}