package org.stevenw.AU272.AssignmentOne.lists;

/**
 * Used to represent double-linked nodes
 * @param <F> Type
 */
public class DoubleLinkedNode<F> {

	private final F data;
	private DoubleLinkedNode<F> next;
	private DoubleLinkedNode<F> prev;

	/**
	 * @param data - the Data that the node stores
	 */
	public DoubleLinkedNode(F data) {
		this.data = data;
	}

	/**
	 * @return get the node's data
	 */
	public F getData() {
		return data;
	}

	/**
	 * @return get the next node
	 */
	public DoubleLinkedNode<F> getNext() {
		return next;
	}

	/**
	 * Set the next node.
	 * @param next - new next node.
	 */
	public void setNext(DoubleLinkedNode<F> next) {
		this.next = next;
	}

	public DoubleLinkedNode<F> getPrev() {
		return prev;
	}

	public void setPrev(DoubleLinkedNode<F> prev) {
		this.prev = prev;
	}


}
