package org.stevenw.AU272.A2;

public class BinaryTreeOrderNumbers<T extends Comparable<? super T>> extends BinarySearchTree<T> {
	public class Node<T> extends BinaryTree.Node {

		private int preOrder;
		private int postOrder;
		private int inOrder;

		public Node(Object data) {
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
	public void preOrderNumber()
}
