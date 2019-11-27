package org.stevenw.AU272.AssignmentOne.lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {

	@Test
	void addRemove() {
		SingleLinkedList<Integer> list = new SingleLinkedList<>();
		list.add(1);
		assertEquals(1, list.size());
		assertEquals(1, list.get(0));
		list.remove(0);
		assertEquals(0, list.size());
		assertEquals(null, list.get(0));
		list.add(3);
		list.add(15);
		list.add(20);
		assertEquals(3, list.get(0));
		assertEquals(15, list.get(1));
		assertEquals(20, list.get(2));

		assertEquals(15, list.remove(1));

		assertEquals(3, list.get(0));
		assertEquals(20, list.get(1));
	}



	@Test
	void swapAdjacent() {
		SingleLinkedList<Integer> list = new SingleLinkedList<>();
		list.add(1);
		list.add(3);
		list.add(15);
		list.add(20);

		list.swapAdjacent(0);

		assertEquals(3, list.get(0));
		assertEquals(1, list.get(1));

		list.swapAdjacent(2);

		assertEquals(20, list.get(2));
		assertEquals(15, list.get(3));
		assertFalse(list.swapAdjacent(3));

		list.remove();
		list.remove();
		list.swapAdjacent(0);
		assertEquals(1, list.get(0));
		assertEquals(3, list.get(1));
		assertEquals(null, list.get(2));

		list.remove();
		assertFalse(list.swapAdjacent(0));
	}
}