package org.stevenw.AU272.A2;

public class BinaryTreeOrderNumbers<T extends Comparable<? super T>> extends BinarySearchTree<T> {

	/**
	 * Assigns post-order numbers to all node in the tree, starting from zero in order of post-order traversal
	 * Runs using standard recursive post-order traversal which is O(n)
	 */
	public void postOrderNumber() {
		postOrderNumber((Node) root, 0);
	}

	/**
	 * Assigns post-order numbers for subtree rooted at given node.
	 * @param node - Node to assign post-order numbers for subtree
	 * @param number - number to start
	 * @return - next number
	 */
	private int postOrderNumber(Node node, int number) {
		if(node != null) {
			int futureNumber = number;
			if(node.getLeft() != null) {
				futureNumber = postOrderNumber((Node) node.getLeft(), number);
			}
			if (node.getRight() != null){
				futureNumber = postOrderNumber((Node) node.getRight(),  futureNumber);
			}
			node.setPostOrder(futureNumber);
			System.out.println(node.getData() + " " + futureNumber);
			return Math.max(futureNumber+1, number+1);
		}
		return number;
	}
	public class Node<T> extends BinaryTree.Node<T> {

		private int preOrder;
		private int postOrder;
		private int inOrder;

		public Node(T data) {
			super(data);
		}

		public int getPostOrder() {
			return postOrder;
		}

		public void setPostOrder(int postOrder) {
			this.postOrder = postOrder;
		}

		public int getPreOrder() {
			return preOrder;
		}

		public void setPreOrder(int preOrder) {
			this.preOrder = preOrder;
		}

		public int getInOrder() {
			return inOrder;
		}

		public void setInOrder(int inOrder) {
			this.inOrder = inOrder;
		}
	}

	/**
	 * Adds element to BST. Overriding in order to add the extended Node subclass rather than default Node
	 * @param element - element to add to BST
	 * @return true if added,false if not
	 */
	@Override
	public boolean add(T element) {
		if(element == null) return false;
		Node<T> node = new Node<T>(element);
		if(this.add(node)) {
			return true;
		}
		return false;
	}

	/**
	 * Assigns pre-order numbers, starting at 0, in order of pre-order traversal to all nodes.
	 * Runs using standard recursive post-order traversal which is O(n)
	 */
	public void preOrderNumber() {
		preOrderNumber((Node) root, 0);
	}


	/**
	 * Assign in order numbers, starting at 0, to all nodes in the tree, in order of in-order traversal
	 * O(n) time as regular traversal which is O(n) just with an extra step of assigning numbers.
	 */
	public void inOrderNumber() {
		inOrderNumber((Node) root,  0);
	}

	/**
	 * Assign in order number for node and all it's children starting at specified number
	 * @param node Node to assign in-order number for, assigns numbers recursively for all it's children too
	 * @param number starting number for that node
	 * @return the next number after this node
	 */
	private int inOrderNumber(Node node, int number) {
		if(node != null) {
			int futureNumber = number;
			if(node.getLeft() != null) {
				futureNumber = inOrderNumber((Node) node.getLeft(), number);
			}
			node.setInOrder(futureNumber);
			System.out.println(node.getData() + " " + futureNumber);
			if (node.getRight() != null){
				futureNumber = inOrderNumber((Node) node.getRight(),  futureNumber+1);
			}

			return Math.max(futureNumber, number+1);
		}
		return number;

	}

	/**
	 * Assigns pre-order number for a node and all it's children with a specified starting number
	 * @param node - Node to assign pre-order number for and it's children
	 * @param number - starting number
	 * @return the next number to use
	 */
	public int preOrderNumber(Node node, int number) {
		//count++;
		if(node != null) {
			int futureNumber = number+1;
			node.setPreOrder(number);
			System.out.println(node.getData() + " " + number);
			if(node.getLeft() != null) {
				futureNumber = preOrderNumber((Node) node.getLeft(), number+1);
			}
			if (node.getRight() != null){
				futureNumber = preOrderNumber((Node) node.getRight(), futureNumber);
			}
			return Math.max(futureNumber, number+1);
		}
		return number;

	}
}
