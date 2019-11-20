package org.stevenw.AU272.AssignmentOne.lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> {
    protected SingleLinkedNode<E> head;
    protected SingleLinkedNode<E> tail;
    protected int size = 0;

    /**
     * @return how many items are in the list
     * runtime complexity: O(1)
     */
    public int size() {
        return size;
    }

    /**
     * @return returns the item with the lowest comparable value
     * runtime complexity: O(1)
     */
    public E getLowest() {
        return (E) head.getData();
    }

    public E getHighest() {
        return (E) tail.getData();
    }


    public ArrayList<E> getList() {
        LinkedList listTest = new LinkedList();

        ArrayList arrayList = new ArrayList();
        if (head == null) return arrayList;
        arrayList.add(head);
        SingleLinkedNode node = head;
        System.out.println(node.getData());
        while (node.getNext() != null) {
            arrayList.add(node.getNext());
            System.out.println(node.getNext().getData());
            node = node.getNext();
        }

        return arrayList;
    }

    /**
     * @param element an instance of the type's object (must be comparable)
     */
    public void add(E element) {
        SingleLinkedNode node = new SingleLinkedNode<>(element);
        if (size() == 0) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
        size++;
    }




    public E get(int position) {
        SingleLinkedNode node = getNode(position);
        return (E) node.getData();
    }

    public E peak() {
        return (E) head.getData();
    }



    public void add(int pos, Comparable element) {
    }

    public E remove() {
        if (isEmpty()) throw new NoSuchElementException(); //returns if list is empty
        E data = (E) head.getData();
        head = head.getNext();
        size--;
        if (head == null) tail = null;
        return data;
    }

    private SingleLinkedNode getNode(int pos) {
        SingleLinkedNode node = head;
        for (int j = 0; j < pos; j++) {
            node = node.getNext();
            System.out.println("j" + j);
        }
        return node;
    }

    public void swapAdjacent(int pos0) { //todo cleanup and test
        int pos1 = pos0 + 1;
        SingleLinkedNode node0 = getNode(pos0);
        SingleLinkedNode node1 = getNode(pos1);
        System.out.println(" node0: " + node0.getData() + " node1: " + node1.getData());
        if (pos0 > 0) {
            SingleLinkedNode preNode0 = getNode(pos0 - 1); //won't work for head?
            System.out.println("prenode0: " + preNode0.getData());

            preNode0.setNext(node1);
        } else {
            head = node1;
        }

        node0.setNext(node1.getNext());
        node1.setNext(node0);
    }
    public boolean isEmpty() {
        return size() == 0;
    }

}
