package org.stevenw.AU272.AssignmentOne.lists;

public interface List<T> {
    public int size();
    public T get(int i);
    public T remove(int i);
    public T remove();
    public void add(T element);

}
