package org.stevenw.AU272.AssignmentOne.lists;

import java.util.Collections;

public class DLList<T>  {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public int size() {
        return size;
    }


    /**
     * @param pos - index
     * @return data of generic type T at the specified index.
     */
    public T get(int pos) {
        return (T) getNode(pos).getData();
    }

    /**
     * @param pos - index
     * @return Node at specified index
     */
    private Node<T> getNode(int pos) {
        Node<T> node = head;
        for (int j = 0; j < pos; j++) {
            node = node.getNext();
            System.out.println("j" + j);
        }
        return node;
    }


    //check code (coped from single linked)
    //todo: verify
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
     */
    public void swapAdjacent(int pos0) { //todo cleanup and test

        Node<T> node0 = getNode(pos0);
        Node<T> node1 = node0.getNext();
        if (pos0 > 0) {
            Node<T> preNode0 = node0.getPrev();
            node1.setPrev(preNode0);
            preNode0.setNext(node1);
        } else { //if node0 is head
            head = node1;
        }
        //[-1, 0, 1, 2, 3] =_> [-1, 1, 0, 2, 3]
        node0.setNext(node1.getNext());
        node0.setPrev(node1);
        node1.setNext(node0);

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

