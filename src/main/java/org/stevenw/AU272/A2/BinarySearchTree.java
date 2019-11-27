package org.stevenw.AU272.A2;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> {

	/**
	 * Finds node in BST and returns it, otherwise return null
	 * @param node Node to find
	 * @return Node if found, otherwise null
	 */
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
		/**
		 * depth of node
		 */
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

	/**
	 * Find node or last node on path, along with depth.
	 * @param node - node to find
	 * @return a NodeDepthPair of the Node searched for or last Node on path and the depth
	 */
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

	/**
	 * Add a node to BST
	 * @param node - Node to add to BST
	 * @return true if added, false if not added
	 */
	protected boolean add(Node<T> node) {
		if(node.getData() == null) {
			return false;
		}
		if(root == null) {
			root = node;
			this.n++;

			return true;
		} else {
			Node<T> last = findLast(node);
			node.setParent(last);
			if(node.getData() == last.getData()) {
				return false;
			} else if(node.getData().compareTo(last.getData()) < 0 ) {
				last.setLeft(node);
				this.n++;

				return true;
			} else {
				last.setRight(node);
				this.n++;

				return true;
			}
		}
	}

	/**
	 * Add an element to BST
	 * @param element - element to add to BST
	 * @return true if added, false if not added
	 */
	public boolean add(T element) {
		if(element == null) return false;
		Node<T> node = new Node<T>(element);
		return this.add(node);
	}

}
