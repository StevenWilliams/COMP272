package org.stevenw.AU272.A2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeOrderNumbersTest {
	BinaryTreeOrderNumbers tree = new BinaryTreeOrderNumbers();
	//BinaryTree.Node F = new BinaryTree.Node( 'F');
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

	@AfterEach
	void tearDown() {

	}

	@Test
	void preOrderNumber() {

		tree.preOrderNumber();
		//start at F
		BinaryTreeOrderNumbers.Node node = (BinaryTreeOrderNumbers.Node) tree.root;
		int i = 0;
		while(tree.preOrderNext(node) != null) {
			System.out.println();
			System.out.println("Node: " + node.getData());
			System.out.println("preOrderNumber: " + node.getPreOrder());
			assertEquals(i, node.getPreOrder());
			node = (BinaryTreeOrderNumbers.Node) tree.preOrderNext(node);
			i++;
		}

	}

	@Test
	void inOrderNumber() {
		tree.inOrderNumber();
		//start at A
		BinaryTreeOrderNumbers.Node node = (BinaryTreeOrderNumbers.Node) tree.root.getLeft().getLeft();
		int i = 0;
		while(tree.inOrderNext(node) != null) {
			System.out.println();
			System.out.println("Node: " + node.getData());
			System.out.println("inOrderNumber: " + node.getInOrder());
			assertEquals(i, node.getInOrder());
			node = (BinaryTreeOrderNumbers.Node) tree.inOrderNext(node);
			i++;
		}
	}

	@Test
	void postOrderNumber() {
		tree.postOrderNumber();
		//start at A
		BinaryTreeOrderNumbers.Node node = (BinaryTreeOrderNumbers.Node) tree.root.getLeft().getLeft();
		int i = 0;
		while(tree.inOrderNext(node) != null) {
			System.out.println();
			System.out.println("Node: " + node.getData());
			System.out.println("postOrderNumber: " + node.getPostOrder());
			assertEquals(i, node.getPostOrder());
			node = (BinaryTreeOrderNumbers.Node) tree.postOrderNext(node);
			i++;
		}
	}


}