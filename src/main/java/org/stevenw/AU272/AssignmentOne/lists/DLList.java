package org.stevenw.AU272.AssignmentOne.lists;

import java.util.Collections;

public class DLList<T>  implements List<T> {
    //dummy nodes
    private Node<T> head = new Node<T>(null);
    private Node<T> tail = new Node<T>(null);
    private int size = 0;

    public DLList() {
        head.setNext(tail);
        tail.setPrev(head);
    }
    public int size() {
        return size;
    }


    /**
     * @param pos - index
     * @return data of generic type T at the specified index.
     */
    public T get(int pos) {
        if(pos >= size()) return null;
        return (T) getNode(pos).getData();
    }

    /**
     * @param pos - index
     * @return Node at specified index
     */
    private Node<T> getNode(int pos) {
        Node<T> node = head.getNext();
        for (int j = 0; j < pos; j++) {
            node = node.getNext();
        }
        return node;
    }

    public T remove(int pos) {
        if(pos >= size()) return null;
        Node<T> node = getNode(pos);
        T data = node.getData();
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        size--;
        return data;
    }

    @Override
    public T remove() {
        Node<T> node = tail.getPrev();
        node.getPrev().setNext(tail);
        tail.setPrev(node.getPrev());
        return node.getData();
    }

    public void add(T element) {
        Node<T> node = new Node<T>(element);

        node.setPrev(tail.getPrev());
        tail.getPrev().setNext(node);
        tail.setPrev(node);
        size++;
    }

    /**
     * Reverses order of nodes.
     */
    public void reverse() {
        Node<T> newHead = new Node<T>(null);
        Node<T> cursorForwards = newHead; //keep track of links going forward
        Node<T> cursor = tail.getPrev(); //keep track of links going backwards
        Node<T> cursorPrev = cursor.getPrev();
        while(cursor!= head) {
            cursor.setPrev(cursorForwards);
            cursorForwards.setNext(cursor);
            //update the cursors
            cursorForwards = cursor;
            cursor = cursorPrev;
            cursorPrev = cursor.getPrev();
        }
        head = newHead;
        tail.setPrev(cursorForwards);
    }

    /**
     * @param pos0 swap node at this position with the one on the next position
     * pos0 cannot be the least index
     */
    public boolean swapAdjacent(int pos0) { //todo cleanup and test
        if(pos0 >= size() -1) return false;
        Node<T> node0 = getNode(pos0);
        Node<T> node1 = node0.getNext();

        node0.getPrev().setNext(node1);
        node1.getNext().setPrev(node0);
        node1.setPrev(node0.getPrev());
        node0.setNext(node1.getNext());
        node1.setNext(node0);
        node0.setPrev(node1);
        return true;
    }

    /**
     * Used to represent double-linked nodes
     * @param <F> Type
     */
    public class Node<F> {

        private final F data;
        private Node<F> next;
        private Node<F> prev;

        /**
         * @param data - the Data that the node stores
         */
        public Node(F data) {
            this.data = data;
        }

        /**
         * @return get the node's data
         */
        public F getData() {
            return data;
        }

        /**
         * @return get the next node
         */
        public Node<F> getNext() {
            return next;
        }

        /**
         * Set the next node.
         * @param next - new next node.
         */
        public void setNext(Node<F> next) {
            this.next = next;
        }

        public Node<F> getPrev() {
            return prev;
        }

        public void setPrev(Node<F> prev) {
            this.prev = prev;
        }


    }
}

