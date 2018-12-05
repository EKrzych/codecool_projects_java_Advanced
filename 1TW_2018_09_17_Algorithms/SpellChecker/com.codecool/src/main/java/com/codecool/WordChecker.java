/**
 *
 * ICS 23 Summer 2004
 * Project #5: Lost for Words
 *
 * Implement your word checker here.  A word checker has two responsibilities:
 * given a word list, answer the questions "Is the word 'x' in the wordlist?"
 * and "What are some suggestions for the misspelled word 'x'?"
 *
 * WordChecker uses a class called WordList that I haven't provided the source
 * code for.  WordList has only one method that you'll ever need to call:
 *
 *     public boolean lookup(String word)
 *
 * which returns true if the given word is in the WordList and false if not.
 */
package com.codecool;

import java.util.ArrayList;

public class WordChecker {
	private WordList wordList;
	/**
   * Constructor that initializes a new WordChecker with a given WordList.
   *
   * @param wordList Initial word list to check against.
   * @see WordList
   */
	public WordChecker(WordList wordList) {
		this.wordList = wordList;
	}
	

	/**
   * Returns true if the given word is in the WordList passed to the
   * constructor, false otherwise. 
   *
   * @param word Word to chack against the internal word list
   * @return bollean indicating if the word was found or not.
   */
	public boolean wordExists(String word) {

		return wordList.lookup(word);
	}


	/**
   * Returns an ArrayList of Strings containing the suggestions for the
   * given word.  If there are no suggestions for the given word, an empty
   * ArrayList of Strings (not null!) should be returned.
   *
   * @param word String to check against
   * @return A list of plausible matches
   */
	public ArrayList getSuggestions(String word) {
		if(wordExists(word)) {
			return new ArrayList();
		} else {
			return generateSuggestions(word);
		}
	}

	private ArrayList generateSuggestions(String word) {
		ArrayList<String> suggestions = new ArrayList<>();
		suggestions.addAll(swapPairs(word));
		suggestions.addAll(insertLetters(word));
		suggestions.addAll(deleteEachLetter(word));
		suggestions.addAll(replaceEachLetter(word));
		suggestions.addAll(splitInTwo(word));
		return suggestions;
	}

	private ArrayList<String> splitInTwo(String word) {
		ArrayList<String> suggestions = new ArrayList<>();
		if (word.length() >= 4) {
			for (int i = 0; i <= word.length(); i += 2) {
				String firstPart = word.substring(0, i);
				String lastPart = word.substring(i, word.length());
				String separatedWord = String.valueOf(new StringBuilder(firstPart).append(" ").append(lastPart));
				if(checkIfBothExist(firstPart,lastPart)) {
					addBoth(separatedWord, suggestions);
				}

			}
		}
		return suggestions;
	}

	private void addBoth(String separatedWord, ArrayList<String> suggestions) {
		if(!suggestions.contains(String.valueOf(separatedWord))) {
			suggestions.add(String.valueOf(separatedWord));
		}

	}

	private boolean checkIfBothExist(String firstPart, String lastPart) {
		return (wordExists(firstPart) && wordExists(lastPart));
	}

	private ArrayList<String> replaceEachLetter(String word) {
		ArrayList<String> suggestions = new ArrayList<>();
		String [] letters = createArrayofLetters();

		for(String letter : letters) {
			String replacedWord = word;

			for (int i = 0; i < word.length(); i += 2) {
				String firstPart = word.substring(0, i);
				String lastPart = word.substring(i + 1, word.length());
				replacedWord = String.valueOf(new StringBuilder(firstPart).append(letter).append(lastPart));
				addIfExist(replacedWord, suggestions);
			}
		}
		return suggestions;
	}

	private ArrayList<String> deleteEachLetter(String word) {
		ArrayList<String> suggestions = new ArrayList<>();
		String readyWord;
		for(int i = 0; i<word.length(); i++) {
			String firstPart = word.substring(0, i);
			String lastPart = word.substring(i+1, word.length());
			readyWord = String.valueOf(new StringBuilder(firstPart).append(lastPart));
			addIfExist(readyWord, suggestions);
		}
		return suggestions;
	}

	private ArrayList<String> swapPairs(String word) {
		ArrayList<String> suggestions = new ArrayList<>();
		if(word.length() >= 4) {
			for (int i = 0, k = 2; k+2 <=  word.length(); k += 2, i += 2) {
				String begin = word.substring(0, i);
				String firstPair = word.substring(i, k);
				String secondPair = word.substring(k, k + 2);
				String lastPart = word.substring(k + 2, word.length());
				String newWord = String.valueOf(new StringBuilder(begin+ secondPair + firstPair + lastPart));
				addIfExist(newWord, suggestions);
			}
		}
		return suggestions;
	}
	private ArrayList<String> insertLetters(String word) {
		ArrayList<String> suggestions = new ArrayList<>();
		String [] letters = createArrayofLetters();

		for(String letter : letters) {
			String insertedWord = String.valueOf(new StringBuilder(letter).append(word));
			addIfExist(insertedWord, suggestions);
			for (int i = 0; i <= word.length(); i += 2) {
				String firstPart = word.substring(0, i);
				String lastPart = word.substring(i, word.length());
				insertedWord = String.valueOf(new StringBuilder(firstPart).append(letter).append(lastPart));
				addIfExist(insertedWord, suggestions);

			}
			insertedWord = String.valueOf(new StringBuilder(word).append(letter));
			addIfExist(insertedWord, suggestions);
		}
		return suggestions;
	}

	private void addIfExist(String insertedWord, ArrayList<String> suggestions) {
		if (wordExists(String.valueOf(insertedWord))) {
			if(!suggestions.contains(String.valueOf(insertedWord))) {
				suggestions.add(String.valueOf(insertedWord));
			}
		}
	}

	private String [] createArrayofLetters() {
		String [] letters = new String [26];
		int asciiForLowerA = 'a';
		int asciiForLowerZ = 'z';
		for(int i = asciiForLowerA, j = 0; i <= asciiForLowerZ; i++, j++){
			letters[j] = Character.toString ((char) i);
		}
		return letters;
	}



}
