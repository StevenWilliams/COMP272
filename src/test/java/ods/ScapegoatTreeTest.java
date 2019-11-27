package ods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScapegoatTreeTest {
	ScapegoatTree tree;
	@org.junit.jupiter.api.BeforeEach
	void setUp() {
		tree = new ScapegoatTree();
	}

	@org.junit.jupiter.api.AfterEach
	void tearDown() {
		tree = null;
	}

	@Test
	void remove() {
	}

	@Test
	void addWithDepth() {
	}

	@Test
	void add() {
		tree.add(1);

		tree.add(5);
		tree.add(2);
		tree.add(4);
		tree.add(3);
/*
		for(int i = 1; i < 7; i++) {
			System.out.println(i);
			tree.add(i);
			System.out.println("height " + tree.height());
			System.out.println();
		}*/
	}

	@Test
	void rebuild() {
	}
}