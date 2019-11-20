package org.stevenw.AU272.A2;

import java.lang.reflect.Array;

public class ScapegoatTree<T extends Comparable<? super T>> extends BinarySearchTree<T>  {
	//private static double alpha = 2D/3D;
	private int q = 0;
	public boolean add(T element) {
		Node<T> node = new Node<T>(element);
		int depth = addWithDepth(node);
		if(depth > log_3_2(q)) {
			//find scapegoat
			System.out.println("depth1: " + depth);
			System.out.println("log1: " + log_3_2(q));
			Node<T> w = node.getParent();
			System.out.println("size w.parent: " + size(w.getParent()));

			//equivalent to size(w)/size(w.getParent) <= 2/3, avoids division imprecision
			while((3 * size(w) <= 2* size(w.getParent()))) {
				w = w.getParent();
				System.out.println("size w.parent: " + size(w.getParent()));
				System.out.println("size w: " + size(w));

			}
			rebuild(w.getParent());
		}
		return depth >= 0;
	}

	/**
	 * @param u
	 * Note: Java does not let you use Generics for a new Array so this is unchecked.
	 */
	void rebuild(Node<T> u) {
		int size = size(u);
		//unchecked
		Node<T>[] a = (Node<T>[]) Array.newInstance(Node.class, size);
		packIntoArray(u, a, 0);
		Node<T> parent = u.getParent();
		if(parent == null) {
			this.root = buildBalanced(a, 0, size);
			this.root.setParent(null);
		} else if(parent.getRight() == u) {
			parent.setRight(buildBalanced(a, 0, size));
			parent.getRight().setParent(parent);
		} else {
			parent.setLeft(buildBalanced(a, 0, size));
			parent.getRight().setParent(parent);
		}

	}

	/**
	 * @param node - node to unpack
	 * @param array - array to pack into
	 * @param i - index for array
	 * @return int with the index
	 * Modified from/based on Pat Morin's Open Data Structures ScapegoatTree
	 */
	int packIntoArray(Node<T> node, Node<T>[] array, int i) {
		if(node == null) {
			return i;
		}
		i = packIntoArray(node.getLeft(), array, i);
		array[i++] = node;
		return packIntoArray(node.getRight(), array, i);
	}

	/**
	 * @param array - flattened array which has all nodes to rebuild
	 * @param offset - first element in the array.
	 * @param size - size of the array subset to rebuild
	 * @return
	 * builds a subtree from the array
	 *    from array[offset] to array[offset+size] with the root being array[size/2 + offset].
	 *    It recursively divides the arrays into halves from offset to offset + size/2,
	 *    and from offset+size/2 +1 to (offset + (size - size/2 - 1)).
	 * Modified from/based on Pat Morin's Open Data Structures ScapegoatTree
	 */
	private Node<T> buildBalanced(Node<T>[] array, int offset, int size) {
		if(size == 0) {
			return null;
		}
		int m = size/2;

		//recursively build left half, with m+offset being the root of each recursive subtree iteration
		array[m + offset].setLeft(buildBalanced(array, offset, m));
		//buildBalanced can return null, if not null, then we need to set parent
		if(array[m + offset].getLeft() != null) {
			array[m+offset].getLeft().setParent(array[m+offset]);
		}
		array[m+offset].setRight(buildBalanced(array, offset+m+1, size-m-1));
		if(array[m+offset].getRight() != null) {
			array[m+offset].getRight().setParent(array[m+offset]);
		}
		return array[m+offset];
/*
If we let m=a.length/2, then the element a[m] becomes the root of the new subtree, a[0],…,a[m−1] get stored recursively in the left subtree and a[m+1],…,a[a.length−1] get stored recursively in the right subtree.
 */

	}


	double log_3_2(int q) {
		return Math.log10((double) q)/Math.log10(1.5);
	}


	/**
	 * @param node - the node to add to the BST
	 * @return depth of the node that was added, -1 if already exists
	 * runtime: O(logn) O(n) if unbalanced.
	 */
	private int addWithDepth(Node<T> node) {
		if(node == null) throw new NullPointerException("Node is null");

		NodeDepthPair lastNode = findLastWithDepth(node);
		if(lastNode.getNode() == null) {
			//would mean root
			this.root = node;
			n++; q++;
			return 0;
		} else if(lastNode.getNode() == node) {
			//the same so don't add.
			return -1;
		} else if(node.getData().compareTo(lastNode.getNode().getData()) < 0) {
			lastNode.getNode().setLeft(node);
		} else {
			lastNode.getNode().setRight(node);
		}
		node.setParent(lastNode.getNode());
		n++; q++;
		return lastNode.getDepth()+1;
	}
}
