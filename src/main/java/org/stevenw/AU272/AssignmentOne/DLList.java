package org.stevenw.AU272.AssignmentOne;

public class DLList<T> {
    private Node head;
    private Node tail;
    private int size = 0;

    public int size() {
        return size;
    }

    public T get(int pos) {
        return (T) getNode(pos).getData();
    }

    private Node getNode(int pos) {
        Node node = head;
        for (int j = 0; j < pos; j++) {
            node = node.getNext();
            System.out.println("j" + j);
        }
        return node;
    }


    //check code (coped from single linked)
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

    public void swapAdjacent(int pos0) { //todo cleanup and test

        Node node0 = getNode(pos0);
        Node node1 = node0.getNext();
        if (pos0 > 0) {
            Node preNode0 = node0.getPrev();
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
    public class Node<F> {

        private final F data;
        private Node<F> next;
        private Node<F> prev;
        private int size = 0;



        public Node(F data) {
            this.data = data;
        }

        public F getData() {
            return data;
        }

        public Node<F> getNext() {
            return next;
        }

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

