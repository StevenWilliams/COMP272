package org.stevenw.AU272.A2;

import java.util.Arrays;

/**
 * Hashtable using k mod 13 hashing algorithm with linear probing
 * @param <Key> type to store in the hashtable
 */
public class HashTable<Key> {

    private int entries = 0;
    /**
     * starting power of 2 is 4 (16)
     * This is since it's bigger than the mod for the hash algorithm.
     * It will be incremented to grow the array.
     */
    private int tableSizePower = 4;

    /**
     * constant bigger than mod in hash function. Used for initial size of array.
     */
    private final int MIN_SIZE = 16; //has to be a power of 2 greater greater than hash (13)

    /**
     * Array where all items are stored
     */
    protected Key[] table  = (Key[]) new Object[MIN_SIZE];

    /**
     * @return # of elements in hashtable
     */
    public int size() {
        return entries;
    }

    /**
     * Adds item to table by picking its index using linear probign
     * @param x Item to add to table
     * @return the index where it was added
     */
    private int probe(Key x) {
        int index = hash(x);
        //int start = index;
        //boolean reset = false;
        int tries = 0;
        while(table[index] != null && tries < table.length) {
            //index & -tableSize;
            //table size 8 (1000), index 8 (1000) = 1000
            //-tableSize = 0111
            //1000 & 0111 = 0000
            //table size 8 (1000), index 7 (0111) = 0111
            //0111 & 0111 = 0111
            //table size 8 (1000), index 6(0110)
            //0110 & 0111 = 0110
            //table size 10 (1010), index 6 (0110)
            //0110 & ~(1010) = 0110 & 0101 = 0100 (4)
            //only works for powers of 2.

            //this increases index, but prevents it from overflowing by starting it over again from 0.
            index = (index+1) & (~(1 << tableSizePower));
            tries++;
            //make index have a max size of tableSize, and if incremented go to 0
        }
        table[index] = x;
        return index;
    }

    /**
     * Print the array backing the hashtable
     */
    void printTableArray() {
        System.out.println(Arrays.toString(table));
    }

    /**
     * @param x - item to add to hashtable
     * @return false if already in table, true otherwise if added
     */
    boolean add(Key x) {
        if(find(x) != null) return false;
        probe(x);
        if(((float)(entries)/(float) table.length) >= 0.5) {
            tableSizePower++;
            resize();
        }
        entries++;
        return true;
    }

    /**
     * @param x -key to find
     * @return - the item in the hashtable that's equal to the key
     */
    Key find(Key x) {
        int index = findKeyIndex(x);
        if(index < 0) {
            return null;
        } else {
            return table[index];
        }
    }

    /**
     * @param x - Key to remove
     * @return true if removed, false if not found
     * Removes specified key from hashtable.
     */
    boolean remove(Key x) {
        int index = findKeyIndex(x);
        if(index < 0) {
            //key not found
            return false;
        } else {
            table[index] = null;
            entries--;
            return true;
        }
    }

    /**
     * @param x - key to search for
     * @return index of key, if key not found, then return -1.
     */
    int findKeyIndex(Key x) {
        int index = hash(x);
        int tries = 0;
        while(tries <= table.length) {
            if(table[index] == x) {
                return index;
            }
            index = (index+1) & (~(1 << tableSizePower));
            tries++;
        }
        return -1;
    }

    /**
     * Calculate hash for index
     * @param x - key to hash
     * @return k mod 13 hashing value
     */
    int hash(Key x) {
        //index must be positive, so apply a bitmask that will make sure the number is positive.
        return (x.hashCode() & 0x7FFFFFFF) % 13;
    }

    /**
     * Resize hashtable array to size 2 to the power of tableSizePower and rehash/reprobe all elements.
     */
    void resize(){
        int newSize = 1 << tableSizePower; // 2 to the power of tableSizePower
        Key[] oldTable = table;
        table = (Key[]) new Object[newSize];
        for(int i = 0; i<oldTable.length; i++){
            if(oldTable[i] != null) {
                probe(oldTable[i]);
            }
        }
    }

}
