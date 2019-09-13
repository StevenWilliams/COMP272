package org.stevenw.AU272.AssignmentOne.lists;

public interface List<T> {
    public int size();
    public T get(int i);
    public void set(int i, T item);
    public void add(int i, T item);
    public T remove(int i);
}
