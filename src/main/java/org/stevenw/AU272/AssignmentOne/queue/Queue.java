package org.stevenw.AU272.AssignmentOne.queue;

import org.stevenw.AU272.AssignmentOne.lists.SingleLinkedList;
import org.stevenw.AU272.AssignmentOne.lists.SingleLinkedNode;

public class Queue<T> {
    private int size;
    private SingleLinkedNode<T> top;
    //FIFO
    public void add(T element) {
        SingleLinkedNode<T> node = new SingleLinkedNode<>(element);
        if(top != null) {
            SingleLinkedNode<T> oldTop = top;
            node.setNext(oldTop);
        }
        top = node;
    }
    public T remove() {
        if(top != null) {
            SingleLinkedNode<T> oldTop = top;
            top = top.getNext();
            return oldTop.getData();
        }
        return null;
    }

    public int size (){
        return size;
    }

}
