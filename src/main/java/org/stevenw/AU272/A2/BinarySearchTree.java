package org.stevenw.AU272.A2;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> {
	private T min;
	private T max;

	//protected Node<T> root;

	public boolean satisfiesSearchOrder() {
		return satisfiesSearchOrder(this.root, min, max);
	}

	/*public static class Node<T> extends BinaryTree.Node<T> {

		public Node(T data) {
			super(data);
		}
	}*/

	public Node<T> find(Node<T> node) {
		BinaryTree.Node<T> parent = null;

		BinaryTree.Node<T> index = this.root;
		while(index != null) {
			if (node.getData().compareTo(index.getData()) > 0) {
				index = index.getRight();
			} else if (node.getData().compareTo(index.getData()) < 0) {
				index = index.getLeft();
			} else {
				return index;
			}
		}
		return null;
	}

	public class NodeDepthPair {
		private final Node<T> node;
		private final int depth;
		public NodeDepthPair(Node<T> val1, int val2) {
			this.node = val1;
			this.depth = val2;
		}

		public Node<T> getNode() {
			return node;
		}

		public int getDepth() {
			return depth;
		}
	}

	/**
	 * @param node - Node to search for
	 * @return - Node if found, otherwise returns the last node searched on the expected path towards the node.
	 * This uses findLastWithDepth in order to shorten code complexity.
	 *
	 * findLastWithDepth would still be O(n), if unbalanced, for time complexity
	 *
	 * space overhead associated with findLastWithDepth
	 *    is constant (integer for counting depth and object overhead for the pair object.
	 */
	public Node<T> findLast(Node<T> node) {
		return findLastWithDepth(node).getNode();
	}

	public NodeDepthPair findLastWithDepth(Node<T> node) {
		BinaryTree.Node<T> parent = null;
		int depth = -1;
		BinaryTree.Node<T> index = this.root;
		while(index != null) {
			parent = index;
			depth++;
			if (node.getData().compareTo(index.getData()) > 0) {
				index = index.getRight();
			} else if (node.getData().compareTo(index.getData()) < 0) {
				index = index.getLeft();
			} else {
				return new NodeDepthPair(index, depth);
			}
		}
		return new NodeDepthPair(parent, depth);
	}

	public boolean add(T element) {
		if(element.compareTo(min) < 0) {
			min =  element;
		}
		if(element.compareTo(max) >0) {
			max = element;
		}
		return false;
		//todo: implement code
	}
		private boolean satisfiesSearchOrder(BinaryTree.Node<T> node, T min, T max) {
		if(node == null) return true;

		//in every recursion, acceptable ranges get bigger
		if(node.getLeft()!= null && node.getLeft().getData().compareTo(min) > 0) {
				return false;
			}
		if(node.getRight()!= null && node.getRight().getData().compareTo(max) < 0) {
			return false;
		}
		return satisfiesSearchOrder(node.getLeft(), min, node.getData()) && satisfiesSearchOrder(node.getRight(), node.getData(), max);

		/*
		Binary-search-tree property: Let x be a node in a binary search tree. If y is a node
in the left subtree of x, then y.key ≤ x.key. If y is a node in the right subtree of x, then
y.key ≥ x.key.
1 < left <
		 */
		/*
		if(node.getLeft()!= null && !(node.getLeft().getData().compareTo(node.getData()) <= 0)) {
			return false;
		}
		if(node.getRight()!= null && !(node.getRight().getData().compareTo(node.getData()) >= 0)) {
	return false;
		}
		return (node.getLeft() == null) || (satisfiesSearchOrder(node.getLeft())) && ((node
				.getRight() == null) || satisfiesSearchOrder(node.getLeft()));*/
	}

}
