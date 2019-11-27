package org.stevenw.AU272.AssignmentOne.lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements List<E> {
    protected SingleLinkedNode<E> head = new SingleLinkedNode<E>(null); //dummy
    protected SingleLinkedNode<E> tail = head;
    protected int size = 0;

    /**
     * @return how many items are in the list
     * runtime complexity: O(1)
     */
    public int size() {
        return size;
    }


    /**
     * @param element an instance of the type's object
     */
    public void add(E element) {
        SingleLinkedNode node = new SingleLinkedNode<>(element);
        tail.setNext(node);
        tail = node;
        size++;
    }


    public E get(int position) {
        if(position >= size()) return null;
        SingleLinkedNode<E> node = getNode(position);
        return node.getData();
    }


    public E remove() {
        return remove(size() -1);
    }

    public E remove(int position) {
        if (isEmpty()) return null;

        SingleLinkedNode<E> prevNode = getNode(position-1);
        E data = prevNode.getNext().getData();
        prevNode.setNext(prevNode.getNext().getNext());

        if(size() == 1) tail = head;

        size--;
        return data;
    }

    private SingleLinkedNode<E> getNode(int pos) {
        SingleLinkedNode<E> node = head;
        for (int j = 0; j <= pos; j++) {
            node = node.getNext();
        }
        return node;
    }

    public boolean swapAdjacent(int pos0) { //todo cleanup and test
        if(pos0 >= size()-1) return false;
        SingleLinkedNode<E> prev = getNode(pos0 -1);



        SingleLinkedNode<E> node0 = prev.getNext();
        SingleLinkedNode<E> node1 = node0.getNext();
        prev.setNext(node1);
        node0.setNext(node1.getNext());
        node1.setNext(node0);

        return true;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

}
