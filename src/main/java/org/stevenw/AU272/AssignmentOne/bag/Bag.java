package org.stevenw.AU272.AssignmentOne.bag;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class Bag<T> {
    /**
     * Stores a Hashtable of Lists (where each element that has equivalent keys will be added)
     */
    private Hashtable<T, List<T>> uSet = new Hashtable<>();

    private int size = 0;

    public int size() {
        return size;
    }


    /**
     * @param item - item to add
     *  Add an item to the bag.
     */
    public void add(T item) {
        if(item == null) {
            throw new NullPointerException("Item cannot be null");
        }
        List<T> listOfTElements = uSet.getOrDefault(item, new LinkedList<>());

        listOfTElements.add(item);
        uSet.put(item, listOfTElements);

        size++;
    }


    /**
     * Remove an element from the bag
     * @param item - item to remove from bag
     * @return - removes last element added
     */
    public T remove(T item) {
        if(uSet.containsKey(item)) {
            List<T> list = uSet.get(item);
            if(list.size() <= 1) {
                uSet.remove(item);
            }
            size--;
            return list.remove(0);
        } else {
            return null;
        }
    }


    /**
     * Looks for an element in the bag, and return the first item added if found
     * @param item - item to look for
     * @return - first duplicate item added to the bag
     */
    public T find(T item) {
        if(uSet.containsKey(item)) {
            List<T> list = uSet.get(item);
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * @param item - item to search for
     * @return - all items that are equivalent to the item being searched for that are in the bag
     */
    public List<T> findAll(T item) {
        if(uSet.containsKey(item)) {
            List<T> list = uSet.get(item);
            return list;
        } else {
            return null;
        }
    }
}
