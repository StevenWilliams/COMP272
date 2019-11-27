package org.stevenw.AU272.AssignmentOne.queue;

import org.stevenw.AU272.AssignmentOne.lists.SingleLinkedList;
import org.stevenw.AU272.AssignmentOne.lists.SingleLinkedNode;

public class PriorityQueue<T extends Comparable<? super T>> extends SingleLinkedList<T> {

    /**
     * @return the element with the highest priority (lowest value)
     * Runtime will be O(1) as all it does is returns the top node, and replaces the top node reference with the next node.
     */
    public T deleteMin() {
        return this.remove(0);
    }

    @Override
    public T remove() {
        return deleteMin();
    }
    /**
     * @param element an instance of the type's object (must be comparable)
     * Internal notes: if item's priority (less than in comparable) is higher than the item in pos 0,
     *                it will displace the item in pos 0 at constant time, otherwise if it's lower than item in pos0 it will loop the list
     *                from the top in linear time until it's in the appropriate place in priority order.
     */
    @Override
    public void add(T element) {
        if(element == null) throw new NullPointerException("cannot add null values");
        SingleLinkedNode<T> node = new SingleLinkedNode<T>(element);

        int i =0;
        SingleLinkedNode<T> node0 = head;
        while(i < size()) {
         //   System.out.println(i + " " + node0.getNext().getData());
            if(element.compareTo(node0.getNext().getData()) > 0) {
             //   System.out.println(i + " " + node0.getData() + "larger");

                node0 = node0.getNext();
            } else {
               // System.out.println(i + " " + node0.getData() + "smaller");

                break;
            }
            i++;
        }
        node.setNext(node0.getNext());
        node0.setNext(node);

        if(i == size()) {
            tail = node;
        }
        /*

        if (size() == 0) {

            //System.out.println("size0" + element.toString());
        } else if (element.compareTo(this.get(0)) < 0) {
            //higher priority items go to top
            //element < head
            //System.out.println("lessthan1st" + element.toString());
            node.setNext(head.getNext());
            head.setNext(node);
            if(size() == 0) {
                tail=node;
            }
        } else {
            //lower priority go to bottom

        }*/
        size++;
    }
}
