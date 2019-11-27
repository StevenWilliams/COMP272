package org.stevenw.AU272.A3;


import org.stevenw.AU272.A2.BinaryTree;

import java.util.*;

public class MeldableHeap<T extends Comparable<? super T>> extends BinaryTree<T> {

	/**
	 * comparator used for merging
	 */
	Comparator<T> comp;
	/**
	 * random generator for merging
	 */
	Random rand = new Random();

	public MeldableHeap(Comparator<T> comparator) {
		comp = comparator;
	}

	/**
	 * Use default comparator for merging (casting to comparable) and using compare
	 */
	public MeldableHeap() {
		comp = new DefaultComparator<T>();
	}

	class DefaultComparator<T> implements Comparator<T> {
		@SuppressWarnings("unchecked")
		public int compare(T a, T b) {
			return ((Comparable<T>)a).compareTo(b);
		}
	}

	/**
	 * @param element - element to add to heap
	 * Adds a node to the heap, by merging it with the root.
	 */
	public void add(T element) {
		Node<T> node = new Node<T>(element);
		add(node);
	}
	/**
	 * @param node - node to add to heap
	 * Adds a node to the heap, by merging it with the root.
	 */
	public void add(Node<T> node) {
		root = merge(node, root);
		root.setParent(null);
		n++;
	}

	/**
	 * Removes root node
	 */
	public T remove() {
		if(root == null) {
			return null;
		}
		T data = root.getData();
		root = merge(root.getLeft(), root.getRight());
		if(root != null) {
			root.setParent(null);
		}
		n--;
		return data;
	}


	/**
	 * @param node - node to remove
	 * removes the given node from the heap
	 */
	public void remove(Node<T> node) {
		if(node == root) {
			//we already have a case for removal of root.
			remove();
		} else {

			//remove refs from parents.
			if (node.getParent() != null) {
				if (node.getParent().getLeft() == node) {
					node.getParent().setLeft(null);
				} else {
					node.getParent().setRight(null);
				}
			}

			//cut off the node from the heap
			node.setParent(null);


			//add both subtrees back into the heap by merging them with the root node
			if(node.getLeft() != null) {
				root = merge(root, node.getLeft());
			}
			//now merge the other subtree into the already merged heap.
			if(node.getRight() != null) {
				root = merge(root, node.getRight());
			}

			//root should have no parent.
			root.setParent(null);
			n--;
		}
	}

	/**
	 * @param h1
	 * @param h2
	 * @return
	 * Adapted from Pat Morin in Open Data Structures (MeldableHeap)
	 */
	Node<T> merge(Node<T> h1, Node<T> h2) {
		if (h1 == null) return h2;
		if (h2 == null) return h1;

		if (comp.compare(h2.getData(), h1.getData()) < 0) return merge(h2, h1);

		if (rand.nextBoolean()) {
			h1.setLeft(merge(h1.getLeft(), h2));
			h1.getLeft().setParent(h1);
		} else {
			h1.setRight(merge(h1.getRight(), h2));
			h1.getRight().setParent(h1);
		}
		return h1;
	}
}
