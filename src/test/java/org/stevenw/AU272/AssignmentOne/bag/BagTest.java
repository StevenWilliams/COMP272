package org.stevenw.AU272.AssignmentOne.bag;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {
	Bag<Integer> bag = new Bag<Integer>();
	@BeforeEach
	void setUp() {
		bag.add(1);
		bag.add(2);
		bag.add(1);
	}

	@Test
	void find() {
		assertNull(bag.find(3));
		assertEquals(1, bag.find(1));
		assertEquals(2, bag.find(2));

	}

	@Test
	void findAll() {
		assertNull(bag.findAll(3));
		assertEquals(2, bag.findAll(1).size());
		assertEquals(1, bag.findAll(2).size());

	}
}