package org.stevenw.AU272.AssignmentOne.lists;

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
     * Add an element to the end of the list
     * @param element an instance of the type's object
     */
    public void add(E element) {
        SingleLinkedNode node = new SingleLinkedNode<>(element);
        tail.setNext(node);
        tail = node;
        size++;
    }


    /**
     * Get the data stored at a specfied index in the list
     * @param position - index of data value to get
     * @return the value of the node at the position, or null if it doesn't exist
     */
    public E get(int position) {
        if(position >= size()) return null;
        SingleLinkedNode<E> node = getNode(position);
        return node.getData();
    }


    /**
     * Remove the last node in the list
     * @return the value of the node removed, or null if the list is empty
     */
    public E remove() {
        return remove(size() -1);
    }

    /**
     * Removes a node at the specified position from the list
     * @param position - index of Node to remove
     * @return the value of the node removed, or null if node doesn't exist
     */
    public E remove(int position) {
        if (position >= size()) return null;

        SingleLinkedNode<E> prevNode = getNode(position-1);
        E data = prevNode.getNext().getData();
        prevNode.setNext(prevNode.getNext().getNext());

        if(size() == 1) tail = head;

        size--;
        return data;
    }

    /**
     * @param pos - index of Node to get, 0 is first actual node, -1 is the dummy head node
     * @return the Node at the specified index (including the dummy head if requested)
     *
     */
    private SingleLinkedNode<E> getNode(int pos) {
        SingleLinkedNode<E> node = head;
        for (int j = 0; j <= pos; j++) {
            node = node.getNext();
        }
        return node;
    }

    /**
     * Swaps nodes at position pos0 and pos0+1
     * @param pos0 node to swap with the node next to it
     * @return true if swapped, false if not swapped
     */
    public boolean swapAdjacent(int pos0) {
        if(pos0 >= size()-1) return false;
        SingleLinkedNode<E> prev = getNode(pos0 -1);

        SingleLinkedNode<E> node0 = prev.getNext();
        SingleLinkedNode<E> node1 = node0.getNext();
        prev.setNext(node1);
        node0.setNext(node1.getNext());
        node1.setNext(node0);

        return true;
    }

    /**
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return size() == 0;
    }

}
