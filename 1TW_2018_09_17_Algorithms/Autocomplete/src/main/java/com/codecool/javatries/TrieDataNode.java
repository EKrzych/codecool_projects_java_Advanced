package com.codecool.javatries;

import java.util.Iterator;
import java.util.LinkedList;


public class TrieDataNode {

    private char data;
    private LinkedList<TrieDataNode> connectedLetters = new LinkedList<>();

    /**
     * Initializes a TrieDataNode with its data
     * @param data The data in this node
     */
    public TrieDataNode(char data) {
        this.data = data;
    }

    public char getData() {
        return data;
    }

    @Override
    public String toString() {
        return Character.toString(data);
    }

    public TrieDataNode getNode(char letter) {
        for(TrieDataNode node : connectedLetters) {
            if(String.valueOf(node.getData()).equalsIgnoreCase(String.valueOf(letter))){
                return node;
            }
        }
        return null;
    }

    public boolean checkIfExist(char letter) {
        for(TrieDataNode node : connectedLetters) {
            if(String.valueOf(node.getData()).equalsIgnoreCase(String.valueOf(letter))) {
                return true;
            }
        }
        return false;
    }

    public TrieDataNode addNewNode(char letter) {
        TrieDataNode newNode = new TrieDataNode(letter);
        this.connectedLetters.add(newNode);
        return newNode;
    }

    public EndNode addEndNode() {
        EndNode newNode = new EndNode();
        this.connectedLetters.add(newNode);
        return newNode;
    }

    public LinkedList<TrieDataNode> getConnectedLetters() {
        return connectedLetters;
    }

    public void removeNode(char cuttingLetter) {
        for(Iterator<TrieDataNode> iter = connectedLetters.iterator(); iter.hasNext();) {
            TrieDataNode data = iter.next();
            if (data.getData() == cuttingLetter) {
                iter.remove();
            }
        }
    }
}
