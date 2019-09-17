package org.stevenw.AU272.AssignmentOne.lists;

public class SingleLinkedNode<F> {
    private final F data;

    /**
     * @param data - the object of the node's type
     */
    public SingleLinkedNode(F data) {
        this.data = data;
    }

    public F getData() {
        return data;
    }

    private SingleLinkedNode<F> next;

    public SingleLinkedNode<F> getNext() {
        return next;
    }

    public void setNext(SingleLinkedNode<F> next) {
        this.next = next;
    }

}
