package org.stevenw.AU272.AssignmentOne.queue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class RandomQueue<T> {
    private T[] array;
   // private ArrayList<T> list = new ArrayList<T>();
    private int size;
    private int capacity;
    private final int minCapacity;
    private Random random;

    /**
     * @param minSize - a guarenteed minimum capacity to avoid having to resize downwards.
     */
    public RandomQueue(int minSize) {
        //array = Array.newInstance(T, startingSize);
        random = new Random();
        capacity = minSize;
        minCapacity = minSize;
        array = (T[]) new Object[capacity];
        //list.ensureCapacity(startingSize);
    }
    public RandomQueue() {
        this(1);
    }

    /**
     *
     * @param element - cannot be null
     */
    public void add(T element) {
        if(element == null) throw new NullPointerException();
        if(array.length + 1 > size) {
            resize();
        }
        size++;
    }
    public T remove() {
        /*

        max_size = 0.5
        min_size = 0.25
        choose between 0 to size()
        up to half of size can be null
        choosing an element has a 50/50 chance

         */
        int pos = random.nextInt(size);

        T data = array[pos];
        array[pos] = null;
        //this would cause a bunch of holes in random places from 0 to peak_size (where peak size is the max size reached.
        //so move the last element in the array structure to the plug the whole in order to keep it constant and avoiding multiple random calls.
        array[pos] = array[size-1];


        size--;

        //would have to be resized here
        if(size < capacity / 4 && size > minCapacity) {
            resize();
        }
        return data;
    }
    private void resize() {
        //go to next Power of 2.
        capacity = nextPowerOf2(capacity);

        capacity = capacity >> 4;
    }

    /**
     * @param num
     * @return
     * Source: Chipopo Lagoral (Stack Overflow: Fast way to find exponent of nearest superior power of)
     */
    int nextPowerOf2(int num)
    {
        return num == 1 ? 1 : Integer.highestOneBit(num - 1) * 2;
    }
}

