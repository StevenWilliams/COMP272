package org.stevenw.AU272.AssignmentOne.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FIFOQueueTest {
	FIFOQueue<Integer> queue;
	@BeforeEach
	void setUp() {
		queue = new FIFOQueue<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);

	}

	@Test
	void add() {
		assertEquals(1, queue.remove());
		assertEquals(2, queue.remove());
		assertEquals(3, queue.remove());
		assertEquals(null, queue.remove());
		queue.add(5);
		assertEquals(5, queue.peek());
	}
}