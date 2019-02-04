package org.stevenw.AU272.AssignmentOne;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class SingleLinkedList<E extends Comparable<E>> {
    private Node head;
    private Node tail;
    private int size = 0;

    public int size() {
        return size;
    }

    public ArrayList<E> getList() {
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

    public E remove() {
        if (isEmpty()) throw new NoSuchElementException(); //returns if list is empty
        E data = (E) head.getData();
        head = head.getNext();
        size--;
        if (head == null) tail = null;
        return data;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public class Node<F extends Comparable<E>> {
        private final F data;

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
