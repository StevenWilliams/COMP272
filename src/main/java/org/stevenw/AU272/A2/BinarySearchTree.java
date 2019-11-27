package org.stevenw.AU272.A2;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> {


	//protected Node<T> root;

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

	protected boolean add(Node<T> node) {
		if(node.getData() == null) {
			return false;
		}
		//Node<T> node = new Node<T>(element);
		if(root == null) {
			root = node;
			return true;
		} else {
			Node<T> last = findLast(node);
			node.setParent(last);
			if(node.getData() == last.getData()) {
				return false;
			} else if(node.getData().compareTo(last.getData()) < 0 ) {
				last.setLeft(node);
				return true;
			} else {
				last.setRight(node);
				return true;
			}
		}
	}
	public boolean add(T element) {
		if(element == null) return false;
		Node<T> node = new Node<T>(element);
		return this.add(node);

		/*
		if(element.compareTo(min) < 0) {
			min =  element;
		}
		if(element.compareTo(max) >0) {
			max = element;
		}*/

		//todo: implement code
	}

}
