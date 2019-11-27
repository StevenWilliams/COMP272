package org.stevenw.AU272.AssignmentOne.stack;

import org.stevenw.AU272.AssignmentOne.lists.SingleLinkedNode;

public class MinStack<T extends Comparable<T>> implements Stack<T>{

    private int size = 0;

    /**
     * top of the stack
     */
    private MinNode<T> top;

    /**
     * @param <T> type of object to store (must be comparable)
     * single-linked structure that keeps track of the minimum value to date
     */
    public class MinNode<T extends Comparable<? super T>>  extends SingleLinkedNode<T> {
        /*
    In order to maintain constant time, add the min value to each node.
    Additional size requirement compared to a regular Stack Node is O(n) which a regular stack is also so no O(n) changes.
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

    /**
     * Adds an item to the stack, keeping track of the minimum value.
     * @param item - item to add to the stack
     * if the value of the item is less than the previous stack top's min value,
     *             then the value of the item becomes the min value for the stack node,
     *             and all future items pushed to the stack that are larger than it.
     *             Otherwise, use the previous top's min value.
     * Runs in O(1) as all it does is just changes references to put the new node at the top of the stack,
     *             and keeping track of the minimum value based on the lesser of the item, or the previous top's min.
     */
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

    /**
     * @return the top node from the stack
     * Remove the top node from the stack
     * Runs in constant time as there's no loops anywhere in the structure
     */
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


    /**
     * Gets the minimum value currently in the stack without removing it
     * @return minimum value in the stack
     * O(1)
     */
    public T min() {
        if(top == null) {
            return null;
        }
        return top.getMin();
    }

}
