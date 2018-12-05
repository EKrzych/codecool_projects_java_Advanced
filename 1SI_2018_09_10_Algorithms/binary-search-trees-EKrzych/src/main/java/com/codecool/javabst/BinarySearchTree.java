package com.codecool.javabst;

public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree(int[]arrayToSort) {
        this.root = buildTree(arrayToSort, 0, arrayToSort.length-1);
    }

    public TreeNode buildTree(int[]arrayToSort, int start, int end) {

        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(arrayToSort[mid]);

        root.setLeft(buildTree(arrayToSort, start, mid-1));
        root.setRight(buildTree(arrayToSort, mid+1, end));

        return root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public boolean IsPresent(int toFind) {
        TreeNode current = this.getRoot();

        while(current != null) {
            if(toFind == current.getValue()) {
                return true;
            } else {
                if(toFind < current.getValue()) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            }
        }
        return false;
    }

    public void add(int toAdd) {
        TreeNode current = this.getRoot();

        if(this.IsPresent(toAdd)) {
            throw new IllegalArgumentException("There is such umber already in tree");
        }
        while(true) {
            if(toAdd < current.getValue()) {

                if (current.getLeft() == null) {
                    current.setLeft(new TreeNode(toAdd));
                    return;
                } else {
                    current = current.getLeft();
                }

            } else {

                if (current.getRight() == null) {
                    current.setRight(new TreeNode(toAdd));
                    return;
                } else {
                    current = current.getRight();
                }
            }
        }
    }

    public void remove(int toRemove) {
        if(!this.IsPresent(toRemove)) {
            throw new IllegalArgumentException("Couldn't find it!");
        }

        if (this.getRoot().getValue() == toRemove) {
            root = null;
            return;
        }

        TreeNode parent = this.getRoot();
        TreeNode current;

        while(true) {
            if(toRemove < parent.getValue()) {
                current = parent.getLeft();
                if(current.getValue() == toRemove) {
                    parent.setLeft(null);
                    return;
                } else {
                    parent = current;
                }
            } else {
                current = parent.getRight();
                if(current.getValue() == toRemove) {
                    parent.setRight(null);
                    return;
                } else {
                    parent = current;
                }
            }
        }
    }
}
