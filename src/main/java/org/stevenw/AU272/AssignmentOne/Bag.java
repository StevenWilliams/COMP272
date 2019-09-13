package org.stevenw.AU272.AssignmentOne;

public class Bag<T> extends   {
    private int size = 0;
    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        size++;
    }

    @Override
    public T remove(T item) {
        size--;
        return null;
    }

    @Override
    public T find(T item) {
        return null;
    }
}
