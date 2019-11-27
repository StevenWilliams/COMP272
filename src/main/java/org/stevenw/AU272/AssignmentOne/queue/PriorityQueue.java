package org.stevenw.AU272.AssignmentOne.queue;

import org.stevenw.AU272.AssignmentOne.lists.SingleLinkedList;
import org.stevenw.AU272.AssignmentOne.lists.SingleLinkedNode;

public class PriorityQueue<T extends Comparable<? super T>> extends SingleLinkedList<T> {

    //size is inherited from List, which runs in constant time

    /**
     * @return the element with the highest priority (lowest value)
     * Runtime will be O(1) as all it does is returns the top node, and replaces the top node reference with the next node.
     */
    public T deleteMin() {
        return this.remove(0);
    }

    /**
     * @return alias for deleteMin()
     */
    @Override
    public T remove() {
        return deleteMin();
    }

    /**
     * @param element an instance of the type's object (must be comparable)
     * Internal notes: if item's priority (less than in comparable) is higher than the item in pos 0,
     *                it will displace the item in pos 0 at constant time, otherwise if it's lower than item in pos0 it will loop the list
     *                from the top in linear time until it's in the appropriate place in priority order.
     *                Therefore worst-case time is O(n).
     */
    @Override
    public void add(T element) {
        if(element == null) throw new NullPointerException("cannot add null values");
        SingleLinkedNode<T> node = new SingleLinkedNode<T>(element);

        int i =0;
        SingleLinkedNode<T> node0 = head;
        //loop through array to find the appropriate place to put the item after.
        while(i < size()) {
            if(element.compareTo(node0.getNext().getData()) > 0) {
                node0 = node0.getNext();
            } else {
                break;
            }
            i++;
        }
        node.setNext(node0.getNext());
        node0.setNext(node);

        if(i == size()) {
            tail = node;
        }
        size++;
    }
}
