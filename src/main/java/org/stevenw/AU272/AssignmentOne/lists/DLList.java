package org.stevenw.AU272.AssignmentOne.lists;

public class DLList<T> implements List<T> {
    //dummy nodes
    private DoubleLinkedNode<T> head = new DoubleLinkedNode<T>(null);
    private DoubleLinkedNode<T> tail = new DoubleLinkedNode<T>(null);

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
     * Get a value at a specified node index
     */
    public T get(int pos) {
        if(pos >= size()) return null;
        return (T) getNode(pos).getData();
    }

    /**
     * @param pos - index
     * @return Node at specified index
     * Get a node at a specified index
     */
    private DoubleLinkedNode<T> getNode(int pos) {
        DoubleLinkedNode<T> node = head.getNext();
        for (int j = 0; j < pos; j++) {
            node = node.getNext();
        }
        return node;
    }

    /**
     * @param pos - index of element to remove
     * @return value of removed element
     * Removes an element from the list, and return what the element's data value was
     */
    public T remove(int pos) {
        if(pos >= size()) return null;
        DoubleLinkedNode<T> node = getNode(pos);
        T data = node.getData();
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        size--;
        return data;
    }

    /**
     * @return last item in list
     * Removes and returns last item in the list
     */
    @Override
    public T remove() {
        DoubleLinkedNode<T> node = tail.getPrev();
        node.getPrev().setNext(tail);
        tail.setPrev(node.getPrev());
        return node.getData();
    }

    public void add(T element) {
        DoubleLinkedNode<T> node = new DoubleLinkedNode<T>(element);

        node.setPrev(tail.getPrev());
        tail.getPrev().setNext(node);
        tail.setPrev(node);
        size++;
    }

    /**
     * Reverses order of nodes.
     */
    public void reverse() {
        DoubleLinkedNode<T> newHead = new DoubleLinkedNode<T>(null);
        DoubleLinkedNode<T> cursorForwards = newHead; //keep track of links going forward
        DoubleLinkedNode<T> cursor = tail.getPrev(); //keep track of links going backwards
        DoubleLinkedNode<T> cursorPrev = cursor.getPrev();
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
    public boolean swapAdjacent(int pos0) {
        if(pos0 >= size() -1) return false;
        DoubleLinkedNode<T> node0 = getNode(pos0);
        DoubleLinkedNode<T> node1 = node0.getNext();

        node0.getPrev().setNext(node1);
        node1.getNext().setPrev(node0);
        node1.setPrev(node0.getPrev());
        node0.setNext(node1.getNext());
        node1.setNext(node0);
        node0.setPrev(node1);
        return true;
    }

}

