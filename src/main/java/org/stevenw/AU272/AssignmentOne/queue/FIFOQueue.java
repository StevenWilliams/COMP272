package org.stevenw.AU272.AssignmentOne.queue;

import org.stevenw.AU272.AssignmentOne.lists.DoubleLinkedNode;
import org.stevenw.AU272.AssignmentOne.lists.SingleLinkedNode;

public class FIFOQueue<T> implements Queue<T> {
    private int size = 0;

    /**
     * top of queue
     */
    private DoubleLinkedNode<T> top;
    /**
     * bottom of queue
     */
    private DoubleLinkedNode<T> bottom;

    /**
     * This is used to add an item to the queue in FIFO order
     * @param element - item to add to the queue (bottom)
     * Time: O(1)
     *
     */
    @Override
    public void add(T element) {
        DoubleLinkedNode<T> node = new DoubleLinkedNode<>(element);
        if(top != null) {
            bottom.setNext(node);
            bottom = node;
        } else {
            top = node;
            bottom=node;
        }
        size++;
    }

    /**
     * Removes the item at the top of the queue and returns it's value
     * @return the value at the top of the queue
     * O(1) time
     */
    @Override
    public T remove() {
        size--;
        if(top != null) {
            DoubleLinkedNode<T> oldTop = top;
            top = top.getNext();
            return oldTop.getData();
        }

        return null;
    }

    /**
     * Returns the value of the item at the top of the queue
     * @return the value at the top of the queue, or null if empty
     * O(1) time
     */
    @Override
    public T peek() {
        if(top != null) {
            return top.getData();
        }
        return null;
    }


    /**
     * @return size of the queue
     */
    @Override
    public int size(){
        return size;
    }

}
