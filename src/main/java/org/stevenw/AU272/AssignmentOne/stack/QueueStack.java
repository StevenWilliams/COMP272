package org.stevenw.AU272.AssignmentOne.stack;

import org.stevenw.AU272.AssignmentOne.queue.FIFOQueue;

public class QueueStack<T> implements Stack<T>{
    int size = 0;
    /**
     * Used as the main queue
     */
    private FIFOQueue<T> q1 = new FIFOQueue<>();
    /**
     * Used as a secondary queue to reverse q1 when pushing.
     * Normally empty except during push.
     */
    private FIFOQueue<T> q2 = new FIFOQueue<>();

    @Override
    public void push(T element) {
        q2.add(element);

        //reverse queue by adding to new queue in order
        while(q1.size() >=1) {
            q2.add(q1.remove());
        }

        //q1 is now empty
        FIFOQueue<T> oldQ1 = q1;
        //since q1 is used as the main queue for pops, it needs to be flipped around since q1 was emptied into q2.
        q1 = q2;
        q2 = oldQ1;
        size++;
    }

    @Override
    public T pop() {
        size--;
        return q1.remove();
    }

    @Override
    public int size() {
        return size;
    }
}
