package org.stevenw.AU272.A2;

import java.util.Arrays;

public class HashTable<Key> {
    private int entries = 0;
    //private int tableSize = 1;
    private int hashingModulo = 13;
    private int tableSizePower = 4;
    //13 = 1101 -> 1111 (how?)
    private final int MIN_SIZE = 16; //has to be a power of 2 greater greater than hash (13)
    private Key[] table  = (Key[]) new Object[MIN_SIZE];

    public int hash2(Object o) {
        //hash(x) = ((z · x) mod 2 w ) div 2 w−d
        return o.hashCode() % 13;
    }
    public static void main(String[] args) {
        HashTable<Integer> table = new HashTable<Integer>();
        table.add(1);
        table.add(5);
        table.add(21);
        //26, 39, 14, 15, 16, 17, 18, 19, 20, 111, 145, 146}.
        table.add(26);
        table.add(39);
        table.add(14);
        table.add(15);
        table.add(16);
        table.add(17);
        table.add(18);
        table.add(19);
        table.add(20);
        table.add(111);
        table.add(145);
        table.add(146);

        table.add(199);
        table.add(5000);
       System.out.println(Arrays.toString(table.table));
       table.remove(5000);
    }
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
            //index = (index >= tableSize) ? index+1 : 0;
            //make index have a max size of tableSize, and if incremented go to 0
        }
        table[index] = x;
        return index;
    }
    boolean add(Key x) {
        if(find(x) != null) return false;

        if(((float)(entries)/(float) table.length) >= 0.5) {
            tableSizePower++;
            resize();
        }
        entries++;
        return true;
    }
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
    int hash(Key x) {
        //index must be positive, so apply a bitmask that will make sure the number is positive.
        return (x.hashCode() & 0x7FFFFFFF) % 13;
    }
    void resize(){
        /*Goal. Average length of list N / M ≤ ½.
・Double size of array M when N / M ≥ ½.
・Halve size of array M when N / M ≤ ⅛.
・Need to rehash all keys when resizing.*/
        int newSize = 1 << tableSizePower;
        Key[] oldTable = table;
        table = (Key[]) new Object[newSize];
        for(int i = 0; i<oldTable.length; i++){
            if(oldTable[i] != null) {
                probe(oldTable[i]);
            }
        }
        System.out.println("resize: " + table.length);
    }
}
