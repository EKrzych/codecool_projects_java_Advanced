/**
 *
 * ICS 23 Summer 2004
 * Project #5: Lost for Words
 *
 * Implement your hash table here.  You are required to use the separate
 * chaining strategy that we discussed in lecture, meaning that collisions
 * are resolved by having each cell in the table be a linked list of all of
 * the strings that hashed to that cell.
 */
package com.codecool;

import java.util.ArrayList;

public class HashTable {
    private ArrayList<String> [] hashMap;
    StringHasher hasher;


	/**
   * The constructor is given a table size (i.e. how big to make the array)
   * and a StringHasher, which is used to hash the strings.
   *
   * @param tableSize number of elements in the hash array
   *        hasher    Object that creates the hash code for a string
   * @see StringHasher
   */
	public HashTable(int tableSize, StringHasher hasher) {
        hashMap = new ArrayList[tableSize];
        this.hasher = hasher;
	}


	/**
   * Takes a string and adds it to the hash table, if it's not already
   * in the hash table.  If it is, this method has no effect.
   *
   * @param stringToAdd String to add
   */
	public void add(String stringToAdd) {
        int position = getHash(stringToAdd);
        ArrayList<String> list;
        if(hashMap[position] == null) {
            list = hashMap[position] = new ArrayList<>();
        } else {
            list = hashMap[position];
        }

        for(String element : list) {
            if(element.equals(stringToAdd)) {
                throw new IllegalArgumentException("Key already in map!");
            }
        }
        list.add(stringToAdd);
	}

    private int getHash(String s) {
        return Math.abs(hasher.hash(s) % hashMap.length);
    }
	

	/**
  * Takes a string and returns true if that string appears in the
	* hash table, false otherwise.
  *
  * @param stringToCheck String to look up
  */
	public boolean lookup(String stringToCheck) {
        int position = getHash(stringToCheck);
        if(hashMap[position] == null) {
            return false;
        }
        ArrayList <String> list = hashMap[position];
        for(String element : list) {
            if(element.equals(stringToCheck)) {
                return true;
            }
        }
        return false;

	}

	

	/**
   * Takes a string and removes it from the hash table, if it
   * appears in the hash table.  If it doesn't, this method has no effect.
   *
   * @param stringToRemove String to remove
  */
	public void remove(String stringToRemove) {
        int position = getHash(stringToRemove);
        ArrayList <String> list = hashMap[position];
        list.remove(stringToRemove);
	}

    public ArrayList<String>[] getHashMap() {
        return hashMap;
    }
}
