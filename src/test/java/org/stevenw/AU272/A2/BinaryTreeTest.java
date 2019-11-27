package org.stevenw.AU272.A2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

	BinarySearchTree<Character> tree = new BinarySearchTree<Character>();
	@BeforeEach
	void setUp() {
		tree.add('F');
		tree.add('B');
		tree.add('G');
		tree.add('A');
		tree.add('D');
		tree.add('C');
		tree.add('E');
		tree.add('G');
		tree.add('I');
		tree.add('H');
	}

	@Test
	void satisfiesSearchOrder() {
		assertTrue(tree.satisfiesSearchOrder());
	}

	@Test
	void doesNotSatisfySearch() {
		//now create an invalid BST. 10 is root, left child to the root is 7,
		// so that so far is valid, but 7's right child is 15 which is >= 10 so it's invalid
		BinaryTree<Integer> tree2 = new BinaryTree<Integer>();
		BinaryTree.Node<Integer> node1 = new BinaryTree.Node<Integer>(10);
		tree2.root = node1;
		node1 = new BinaryTree.Node<Integer>(7);
		tree2.root.setLeft(node1);
		node1 = new BinaryTree.Node<Integer>(15);
		tree2.root.getLeft().setRight(node1);
		assertFalse(tree2.satisfiesSearchOrder());
	}

	@Test
	void preOrderNext() {
// pre-order (red): F, B, A, D, C, E, G, I, H

		//node will be F
		BinaryTree.Node node = tree.preOrderNext(tree.root);
		assertEquals('B', node.getData());

		//node will be B
		node = tree.root.getLeft();
		assertEquals('A', tree.preOrderNext(node).getData());

		//node will be A
		node = node.getLeft();
		assertEquals('D', tree.preOrderNext(node).getData());

		//node will be D
		node = tree.root.getLeft().getRight();
		assertEquals('C', tree.preOrderNext(node).getData());

		//node will be C
		node = tree.root.getLeft().getRight().getLeft();
		assertEquals('E',tree.preOrderNext(node).getData());

		//node will be E
		node = tree.root.getLeft().getRight().getRight();
		assertEquals('G', tree.preOrderNext(node).getData());

		//node will be G
		node = tree.root.getRight();
		assertEquals('I', tree.preOrderNext(node).getData());

		//node will be I
		node = node.getRight();
		//System.out.println(tree.inOrderNext(node).getData());
		//I is the last node, so the next should be null.
		assertEquals('H', tree.preOrderNext(node).getData());

		//node will be H
		node = node.getLeft();
		assertEquals(null, tree.preOrderNext(node));
	}

	@Test
	void postOrderNext() {
		// post-order (green): A, C, E, D, B, H, I, G, F.

		//node will be F
		BinaryTree.Node node = tree.postOrderNext(tree.root);
		assertEquals(null, node);

		//node will be B
		node = tree.root.getLeft();
		assertEquals('H', tree.postOrderNext(node).getData());

		//node will be A
		node = node.getLeft();
		assertEquals('C', tree.postOrderNext(node).getData());

		//node will be D
		node = tree.root.getLeft().getRight();
		assertEquals('B', tree.postOrderNext(node).getData());

		//node will be C
		node = tree.root.getLeft().getRight().getLeft();
		assertEquals('E', tree.postOrderNext(node).getData());

		//node will be E
		node = tree.root.getLeft().getRight().getRight();
		assertEquals('D', tree.postOrderNext(node).getData());

		//node will be G
		node = tree.root.getRight();
		assertEquals('F', tree.postOrderNext(node).getData());

		//node will be I
		node = node.getRight();
		//System.out.println(tree.inOrderNext(node).getData());
		//I is the last node, so the next should be null.
		assertEquals('G', tree.postOrderNext(node).getData());

		//node will be H
		node = node.getLeft();
		assertEquals('I', tree.postOrderNext(node).getData());
	}

	@Test
	void inOrderNext() {
		//in-order (yellow): A, B, C, D, E, F, G, H, I;


		//node will be F
		BinaryTree.Node node = tree.inOrderNext(tree.root);
		assertEquals('G', node.getData());

		//node will be B
		node = tree.root.getLeft();
		assertEquals('C', tree.inOrderNext(node).getData());

		//node will be A
		node = node.getLeft();
		assertEquals('B', tree.inOrderNext(node).getData());

		//node will be D
		node = tree.root.getLeft().getRight();
		assertEquals('E', tree.inOrderNext(node).getData());

		//node will be C
		node = tree.root.getLeft().getRight().getLeft();
		assertEquals('D', tree.inOrderNext(node).getData());

		//node will be E
		node = tree.root.getLeft().getRight().getRight();
		assertEquals('F', tree.inOrderNext(node).getData());

		//node will be G
		node = tree.root.getRight();
		assertEquals('H', tree.inOrderNext(node).getData());

		//node will be I
		node = node.getRight();
		//System.out.println(tree.inOrderNext(node).getData());
		//I is the last node, so the next should be null.
		assertEquals(null, tree.inOrderNext(node));

		//node will be H
		node = node.getLeft();
		assertEquals('I', tree.inOrderNext(node).getData());
	}
}