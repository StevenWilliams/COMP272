package org.stevenw.AU272.AssignmentOne.queue;

import org.stevenw.AU272.AssignmentOne.lists.SingleLinkedList;
import org.stevenw.AU272.AssignmentOne.lists.SingleLinkedNode;

public class FIFOQueue<T> implements Queue<T> {
    private int size = 0;
    private SingleLinkedNode<T> top;
    private SingleLinkedNode<T> bottom;

    //FIFO
    @Override
    public void add(T element) {
        SingleLinkedNode<T> node = new SingleLinkedNode<>(element);
        if(top != null) {

            SingleLinkedNode<T> node2 = top;
            while(node2.getNext() != null) {
                node2 = node2.getNext();
            }
            node2.setNext(node);
            bottom.setNext(node);
            bottom = node;
        } else {
            top = node;
            bottom=node;
        }
        size++;
    }
    @Override
    public T remove() {
        size--;
        if(top != null) {
            SingleLinkedNode<T> oldTop = top;
            top = top.getNext();
            return oldTop.getData();
        }

        return null;
    }

    @Override
    public T peek() {
        if(top != null) {
            return top.getData();
        }
        return null;
    }


    @Override
    public int size(){
        return size;
    }

}
