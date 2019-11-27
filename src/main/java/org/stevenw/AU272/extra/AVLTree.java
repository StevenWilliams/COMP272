package org.stevenw.AU272.extra;

import org.stevenw.AU272.A2.BinarySearchTree;

public class AVLTree <T extends Comparable<? super T>> extends BinarySearchTree<T> {
	@Override
	public boolean add(T element) {
		if(element == null) {
			return false;
		}
		Node<T> node = new Node<T>(element);
		return super.add(node);
	}

	/**
	 * @param target - target tree which will be the one to convert to
	 * Converts current tree into target tree via single rotation
	 */
	public void convertTreeBySingleRotation(AVLTree<T> target) {
		AVLTree<T> tree = this;
		if(tree.root == null || target.root == null || tree.size() != target.size()) {
			return;
		}
		//convert tree into target.
		//first convert tree to a linked list.
		//tree rotation takes log N on average?
		if(!tree.bringNodeToRoot((AVLNode) tree.root, (AVLNode) target.root)) {
			System.out.println("Trees are not identical");
		} else {
			if (!tree.bringNodeToRoot((AVLNode) tree.root.getRight(), (AVLNode) target.root.getRight())) {

			}
			if (!tree.bringNodeToRoot((AVLNode) tree.root.getLeft(), (AVLNode) target.root.getLeft())) {

			}
		}
	}


	/**
	 * @param root - current root at subtree
	 * @param target - finds target node and brings it up to root
	 * @return false if target node cannot be found in the tree, true otherwise
	 */
	public boolean bringNodeToRoot(AVLNode<T> root, AVLNode<T> target) {
		if(root == null || target == null || root.getData() == null || target.getData() == null) {
			return false;
		}
		if(root == target) {
			return true;
		}
		AVLNode<T> targetNodeInTree = (AVLNode<T>) this.find(target);
		if(targetNodeInTree == null) {
			return false;
		}
		AVLNode<T> parent = (AVLNode<T>) targetNodeInTree;
		//parent being root means that targetNodeInTree is now at the level of root
		while(parent != root) {
			parent = (AVLNode<T>) targetNodeInTree.getParent();
			if (targetNodeInTree == parent.getLeft()) {
				targetNodeInTree.rightRotate();
			} else {
				targetNodeInTree.leftRotate();
			}
		}

		/*
		while (target node is not the root) {
    if (node is a left child) {
        apply a right rotation to the node and its parent;
    } else {
        apply a left rotation to the node and its parent;
    }
}
		 */
		return true;

	}

	public class AVLNode<T extends Comparable<? super T>> extends BinarySearchTree.Node<T> {
		protected int height = 1;
		public AVLNode(T data) {
			super(data);
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public int getBalanceFactor() {
			return ((getRight() != null) ? ((AVLNode<T>) getRight()).getHeight() : 0) - ((getLeft() != null) ? ((AVLNode<T>) getLeft()).getHeight() : 0);
		}
		public void leftRotate() {
			AVLNode<T> parent = (AVLNode<T> ) this.getParent();
			AVLNode<T> pivot = (AVLNode<T> ) parent.getRight();
			parent.setRight(pivot.getLeft());
			pivot.setLeft(parent);
			AVLNode<T> parent2 = (AVLNode<T>) parent.getParent();
			if(parent2 != null) {
				if (this.getData().compareTo(parent2.getData()) < 0) {
					parent2.setLeft(pivot);
				} else {
					parent2.setRight(pivot);
				}
			} else {
				//root?
			}

			/*
			The programmer must also make sure that the root's parent points to the pivot after the rotation. Also, the programmer should note that this operation may result in a new root for the entire tree and take care to update pointers accordingly.

			 */
			/*
			Pivot = Root.OS
Root.OS = Pivot.RS
Pivot.RS = Root
Root = Pivot
			 */
		}
		public void rightRotate() {

		}
	}
}