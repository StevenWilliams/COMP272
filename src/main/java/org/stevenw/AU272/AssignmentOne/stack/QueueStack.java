package org.stevenw.AU272.AssignmentOne.stack;

import org.stevenw.AU272.AssignmentOne.queue.Queue;

public class QueueStack<T>{
    /**
     * Used as the main queue
     */
    private Queue<T> q1 = new Queue<>();
    /**
     * Used as a secondary queue to reverse q1 when pushing.
     * Normally empty except during push.
     */
    private Queue<T> q2 = new Queue<>();
    public void push(T element) {
        q2.add(element);
        //reverse queue by adding to new queue in order
        while(q1.size() >=1) {
            q2.add(q1.remove());
        }
        //q1 is now empty
        Queue<T> oldQ1 = q1;
        //since q1 is used as the main queue for pops, it needs to be flipped around since q1 was emptied into q2.
        q1 = q2;
        q2 = q1;
    }
    public void pop() {
        q1.remove();
    }
}
