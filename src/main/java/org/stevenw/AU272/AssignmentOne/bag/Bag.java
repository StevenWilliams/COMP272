package org.stevenw.AU272.AssignmentOne.bag;

import java.util.HashSet;
import java.util.Hashtable;

public class Bag<T>  {
    /*
    Set - No duplicates and No order
Bag - Can contain Duplicates and No Order (Also called, Unordered List or Set with duplicates)
    HashTable using LinkedList
    LinkedList index = {node, node, node}, node has (data, count)
     */
    private HashSet<T> hashSet  = new HashSet<>();
    /**
     * Will store the amount of times that an object is in the Bag.
     * Hashtable will only be used if there are 2 or more of that element in the bag to save space.
     * If an object is in the hashSet but not in the hashtable, it will be assumed to be 1.
     * If an object is not in the hashSet it's not in the bag.
     * If an object is in the hashtable, and in the hashset, then it would be the number of times its in the bag (2+)
     */
    private Hashtable<T, Integer> instances = new Hashtable<>();

    /*
    public class SetNode<T> {
        private T data;
        private int count = 1;

        public SetNode(T item) {
            this.data = item;
        }

        /**
         * Set implementations use hashCode to differentiate elements.
         * In order to make sure that the hash code of 2 Nodes with the same underlying data are equal,
         * this return the data's hash code as its own.
         *
         * @return hash code of Data
         *

        @Override
        public int hashCode() {
            return data.hashCode();
        }

        /**
         *
         * @param item an Object to compare it to.
         * @return true if data is equal (but will ignore count).
         *
        @Override
        public boolean equals(Object item) {
            if(this==item) return true;
            if(item instanceof SetNode) {
                if(((SetNode) item).data == data) return  true;
            }
            return false;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }*/

    private int size = 0;

    public int size() {
        return size;
    }


    public void add(T item) {
        if(!hashSet.contains(item)) {
            hashSet.add(item);
        } else {
            //node was already in bag
            if(instances.containsKey(item)) {
                //either 2 or more.
                int quantity = instances.get(item);
                instances.replace(item, quantity+1);
            } else {
                //only 1 before, since it doesn't contain the key
                instances.put(item, 2);
            }
        }
        size++;
    }


    public T remove(T item) {
        if(instances.containsKey(item)) {
            //2 or more
            int quantity = instances.get(item);
            if(quantity - 1 >=2) {
                instances.replace(item, quantity-1);
            } else {
                //new quantity is 1 so can be removed from table.
                instances.remove(item);
            }
            size--;
            return item;
        } else if (hashSet.contains(item)){
            //only 1 so can be removed from set.
            hashSet.remove(item);
            size--;
            return item;
        }
        return null;
    }


    public T find(T item) {
        return null;
    }
}
