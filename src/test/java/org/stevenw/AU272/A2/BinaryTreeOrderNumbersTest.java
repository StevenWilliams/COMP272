package org.stevenw.AU272.A2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreeOrderNumbersTest {
	BinaryTreeOrderNumbers tree = new BinaryTreeOrderNumbers();
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
	}

	@Test
	void testPreOrderNumber() {
	}

	@Test
	void inOrderNumber() {
		tree.inOrderNumber();

	}

	@Test
	void postOrderNumber() {
		tree.postOrderNumber();
	}
}