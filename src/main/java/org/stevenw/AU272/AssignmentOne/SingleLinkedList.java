package org.stevenw.AU272.AssignmentOne;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SingleLinkedList<E extends Comparable<E>> {
    private Node head;
    private Node tail;
    private int size = 0;

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
        Node node = head;
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
     * @returns true if added to list
     */
    public boolean add(Comparable element) {
        Node node = new Node<>(element);
        if (size() == 0) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
        size++;
        return true;
    }


    public boolean priorityAdd(Comparable element) {
        Node node = new Node<>(element);
        if (size() == 0) {
            head = node;
            //System.out.println("size0" + element.toString());
        } else if (node.getData().compareTo(head.getData()) < 0) { // less than
            //System.out.println("lessthan1st" + element.toString());
            node.setNext(head);
            head = node;
            if (head.getNext().getNext() == null) {
                tail = head.getNext();
            }
        } else { //equal to or greater
            //System.out.println("lessthan2nd" + element.toString());

            Node node0 = head;
            //System.out.println("node0" + node0.getData().toString());
            Node node1 = head.getNext();
            if (node1 == null) {
                head.setNext(node);
            } else {
                //System.out.println("node1" + node1.getData().toString());
                while (node1 != null && node1.getData() != null) {
                    //System.out.println("whileloop");
                    if ((node.getData().compareTo(node1.getData())) < 0) {
                        //System.out.println("whileloopif");
                        node.setNext(node1);
                        node0.setNext(node);
                        break;
                    } else {
                        node0 = node0.getNext();
                        node1 = node1.getNext();
                        if (node1 == null) {
                            node0.setNext(node);
                            tail = node;
                        }
                    }

                }
            }
        }
        size++;
        return true;
    }

    public E get(int position) {
        Node node = getNode(position);
        return (E) node.getData();
    }

    public E peak() {
        return (E) head.getData();
    }

    public void sort() {
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

    private Node getNode(int pos) {
        Node node = head;
        for (int j = 0; j < pos; j++) {
            node = node.getNext();
            System.out.println("j" + j);
        }
        return node;
    }

    public void swapAdjacent(int pos0) { //todo cleanup and test
        int pos1 = pos0 + 1;
        Node node0 = getNode(pos0);
        Node node1 = getNode(pos1);
        System.out.println(" node0: " + node0.getData() + " node1: " + node1.getData());
        if (pos0 > 0) {
            Node preNode0 = getNode(pos0 - 1); //won't work for head?
            System.out.println("prenode0: " + preNode0.getData());

            preNode0.setNext(node1);
        } else {
            head = node1;
        }

        node0.setNext(node1.getNext());
        node1.setNext(node0);

        /*
        if (pos0 > 0) {
            Node preNode0 = getNode(pos0 - 1); //won't work for head?
            Node node0 = getNode(pos0);
            Node node1 = getNode(pos1);
            System.out.println("prenode0: " + preNode0.getData() + " node0: " + node0.getData() + " node1: " + node1.getData());
            preNode0.setNext(node1);
            node0.setNext(node1.getNext());
            node1.setNext(node0);
        } else {
            Node node0 = head;
            Node node1 = head.getNext();
            node0.setNext(node1.getNext());
            node1.setNext(node0);
            head = node1;
        }*/
    }

    public void swap(int pos0, int pos1) {
    }
    public boolean isEmpty() {
        return size() == 0;
    }

    public class Node<F extends Comparable<E>> {
        private final F data;

        /**
         * @param data - the object of the node's type
         */
        public Node(F data) {
            this.data = data;
        }

        public F getData() {
            return data;
        }

        private Node<F> next;

        public Node<F> getNext() {
            return next;
        }

        public void setNext(Node<F> next) {
            this.next = next;
        }

    }
}
