package org.stevenw.AU272.AssignmentOne.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FIFOQueueTest {

	@BeforeEach
	void setUp() {
		FIFOQueue<Integer> queue = new FIFOQueue<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		assertEquals(1, queue.remove());
		assertEquals(2, queue.remove());
		assertEquals(3, queue.remove());

	}

	@Test
	void add() {

	}
}