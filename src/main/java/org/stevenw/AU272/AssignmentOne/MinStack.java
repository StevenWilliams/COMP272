package org.stevenw.AU272.AssignmentOne;

import org.stevenw.AU272.AssignmentOne.lists.SingleLinkedList;
import org.stevenw.AU272.AssignmentOne.lists.SingleLinkedNode;

public class MinStack<T extends Comparable<T>> {
    /**
     * (20 marks) Exercise 3.14. Design and implement a MinStack data structure that can store
     * comparable elements and supports the stack operations push(x), pop(), and size(), as well as the
     * min() operation, which returns the minimum value currently stored in the data structure. All
     * operations should run in constant tim
     */
    private int size = 0;
    private SingleLinkedNode<T> top;
    private T min;
    public void push(T item) {
        if(item.compareTo(min) < 0){
            min = item;
        }
        if(top == null) {
            top = new SingleLinkedNode<T>(item);
        } else {
            SingleLinkedNode<T> newTop = new SingleLinkedNode<T>(item);
            newTop.setNext(top);
        }
        size++;
    }

    public T pop() {
        SingleLinkedNode<T> oldTop = top;
        top = top.getNext();
        size--;
        return oldTop.getData();
    }
    public int size() {
        return size;
    }
    public T min() {
        return min;
    }

}
