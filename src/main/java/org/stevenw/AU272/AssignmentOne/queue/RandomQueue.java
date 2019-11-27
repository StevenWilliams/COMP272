package org.stevenw.AU272.AssignmentOne.queue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class RandomQueue<T> implements Queue<T> {

    //using ArrayList to back queue to achieve amortized constant time
    private ArrayList<T> list = new ArrayList<T>();
   private int size = 0;

   //used to maintain consistency between peek/remove.
   private int index = -1; //-1 means no index is set

    /**
     * random number generator for selecting which element to peek/remove
     */
    private Random random;

    public RandomQueue() {
        random = new Random();
    }

    /**
     *
     * @param element - cannot be null
     *
     * Amortized constant time (constant, except when resizing in arraylist)
     */
    @Override
    public void add(T element) {
        if(element == null) throw new NullPointerException();
        list.add(element);
        size++;
        index = -1;
    }

    /**
     * @return a randomly selected element in the Queue
     * amoritized constant time (constant time apart from shrink operation in arraylist).
     * If peek was used before, then it will remove the same element chosen by peek.
     * After removing it, it resets the index.
     */
    @Override
    public T remove() {
        if(size == 0) {
            return null;
        }
        if(index == -1) {
            index = pickIndex();
        }
        T data = list.get(index);
        if(index != size-1) {
            T tail = list.get(size-1);
            //swap last node with the index just removed, to plug holes.
            list.set(index, tail);
        }
        list.remove(size-1);


        size--;
        index = -1;

        return data;
    }

    /**
     * @return returns a random element in the queue, without removing it.
     * If this is used, then the next time remove/peek is used, it will return the same element as it picks the index,
     * if not already set to ensure consistency
     */
    @Override
    public T peek() {
        if(size == 0) {
            return null;
        }
        if(index == -1) {
            index = pickIndex();
        }
        return list.get(index);
    }

    @Override
    public int size() {
        return size;
    }

    /**
     *  used to set the index that will be shared between peek/remove.
     * @return the index chosen
     */
    private int pickIndex() {
        index = random.nextInt(size);
        return index;
    }
}

