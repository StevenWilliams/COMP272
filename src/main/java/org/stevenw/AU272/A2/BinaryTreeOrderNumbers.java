package org.stevenw.AU272.A2;

public class BinaryTreeOrderNumbers<T extends Comparable<? super T>> extends BinarySearchTree<T> {

	public void postOrderNumber() {
		postOrderNumber((Node) root, 0);
	}
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
	@Override
	public boolean add(T element) {
		if(element == null) return false;
		Node<T> node = new Node<T>(element);
		if(this.add(node)) {
			n++;
			return true;
		}
		return false;
	}

	public void preOrderNumber() {
		/*
		Algorithm Preorder(tree)
   1. Visit the root.
   2. Traverse the left subtree, i.e., call Preorder(left-subtree)
   3. Traverse the right subtree, i.e., call Preorder(right-subtree)
		 */
		preOrderNumber((Node) root, 0);
	}


	public void inOrderNumber() {
		inOrderNumber((Node) root,  0);
	}
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
