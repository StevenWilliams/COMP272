package org.stevenw.AU272.AssignmentOne.stack;

import org.stevenw.AU272.AssignmentOne.lists.SingleLinkedList;
import org.stevenw.AU272.AssignmentOne.lists.SingleLinkedNode;

public class MinStack<T extends Comparable<T>> implements Stack<T>{
    /**
     * (20 marks) Exercise 3.14. Design and implement a MinStack data structure that can store
     * comparable elements and supports the stack operations push(x), pop(), and size(), as well as the
     * min() operation, which returns the minimum value currently stored in the data structure. All
     * operations should run in constant tim
     */

    private int size = 0;
    private MinNode<T> top;

    public class MinNode<T extends Comparable<? super T>>  extends SingleLinkedNode<T> {    /*
    In order to maintain constant time, add the min value to each node.
    Additional size requirement compared to a regular Stack Node is O(n) which a regular stack is also so no asymptotic size changes.
     */
        //include the min value in each node
        private T min;
        private MinNode<T> next;

        /**
         * @param data - the object of the node's type
         */
        public MinNode(T data) {
            super(data);
        }

        public void setMin(T data) {
            min = data;
        }
        public T getMin() {
            return min;
        }

        @Override
        public MinNode<T> getNext() {
            return next;
        }

        public void setNext(MinNode<T> next) {
            this.next = next;
        }
    }

    public void push(T item) {
        MinNode<T> node = new MinNode<T>(item);
        T min;
        if(top != null && item.compareTo(top.getMin()) >= 0) {
            min = top.getMin();
        } else {
            min = item;
        }
        node.setMin(min);
        if(top != null) {
            node.setNext(top);
        }
        top = node;
        size++;
    }

    public T pop() {
        if(top == null){
            return null;
        }
        T data = top.getData();
        top = top.getNext(); //can be null
        size--;
        return data;
    }
    public int size() {
        return size;
    }

    public T min() {
        if(top == null) {
            return null;
        }
        return top.getMin();
    }

}
