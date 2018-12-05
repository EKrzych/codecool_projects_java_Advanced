package com.codecool.javatries;

import java.util.ArrayList;
import java.util.List;

public class AutoComplete {

    private TrieDataNode root;

    /**
     * Starts a new Trie with dummy root data "-"
     */
    public AutoComplete() {
        root = new TrieDataNode('-');
    }

    /**
     * Adds a word to the Trie.
     */
    public void addWord(String wordToAdd) {
        TrieDataNode node = root;
        char[] charArray = wordToAdd.toCharArray();
        for (char letter : charArray) {
            if (node.checkIfExist(letter)) {
                node = node.getNode(letter);
            } else {
                node = node.addNewNode(letter);
            }
        }
        if (!node.checkIfExist('*')) {
            node.addEndNode();
        }
    }

    /**
     * Returns the possible completions of baseChars String from the Trie.
     *
     * @param baseChars The String to autocomplete.
     * @return possible completions. An empty list if there are none.
     */
    public List<String> autoComplete(String baseChars) {
        StringBuilder newBase = new StringBuilder();
        List<String> words = new ArrayList<>();
        TrieDataNode node = root;
        char[] charArray = baseChars.toCharArray();
        for (char letter : charArray) {
            if (node.checkIfExist(letter)) {
                node = node.getNode(letter);
                newBase.append(node.getData());
            } else {
                return words;
            }
        }
        words = buildWords(new StringBuilder(newBase), node, words);


        return words;
    }

    private List<String> buildWords(StringBuilder baseChars, TrieDataNode node, List<String> words) {
        for (TrieDataNode letter : node.getConnectedLetters()) {
            if (letter.getData() == '*') {
                words.add(baseChars.toString());
            } else {
                baseChars.append(letter.getData());
                buildWords(baseChars, letter, words);
                baseChars.setLength(baseChars.length() - 1);
            }
            if((words.size() >= 10)) {
                return words;
            }
        }
        return words;
    }


    /**
     * Removes a word from the Trie
     *
     * @return true if the removal was successful
     */
    public boolean removeWord(String wordToRemove) {
        wordToRemove += "*";
        char[] charArray = wordToRemove.toCharArray();
        TrieDataNode node = root;
        TrieDataNode nodeToCut = root;
        char cuttingLetter = charArray[0];
        for (char letter : charArray) {
            if (!node.checkIfExist(letter)) {
                return false;
            }
            if(node.getNode(letter).getConnectedLetters().size() > 1 || letter == '*') {
                nodeToCut = node;
                cuttingLetter = letter;
            }
            node = node.getNode(letter);
        }
        nodeToCut.removeNode(cuttingLetter);
        return true;
    }

}
