package org.stevenw.AU272.A2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScapegoatTreeTest {
	ScapegoatTree<Integer> tree;
	ods.ScapegoatTree tree2;
	@BeforeEach
	void setUp() {
		tree = new ScapegoatTree<Integer>();
		tree2 = new ods.ScapegoatTree();
	}

	@AfterEach
	void tearDown() {
		tree = null;
		tree2 = null;
	}

	@Test
	void add() {
		for(int i = 1; i < 30; i++) {
			System.out.println(i);
			tree.add(i);
			tree2.add(i);
			System.out.println("height " + tree.height());
			assertEquals(tree2.height(), tree.height());
			System.out.println();
		}
	}

	@Test
	void log_3_2() {
		for(int i = 1; i < 30; i++) {
			System.out.println(i + " " + tree.log_3_2(i));
		}
	}
}