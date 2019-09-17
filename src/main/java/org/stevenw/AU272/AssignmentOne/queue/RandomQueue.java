package org.stevenw.AU272.AssignmentOne.queue;

import java.util.Random;

public class RandomQueue<T> {
    private T[] array;
    private int size;
    private Random random;
    public RandomQueue(int startingSize) {
        array = (T[]) new Object[startingSize];
        random = new Random();
    }
    public RandomQueue() {
        this(1);
    }

    /**
     *
     * @param element
     */
    public void add(T element) {
        if(array.length + 1 > size) {
            resize();
        }
        size++;
    }
    public T remove() {
        int pos = random.nextInt(size);
        T data = array[pos];
        array[pos] = null;
        size--;
        return data;
    }
    private void resize() {

    }
}
