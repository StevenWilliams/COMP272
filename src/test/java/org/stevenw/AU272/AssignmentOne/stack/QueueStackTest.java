package org.stevenw.AU272.AssignmentOne.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.stevenw.AU272.AssignmentOne.queue.Queue;

import static org.junit.jupiter.api.Assertions.*;

class QueueStackTest {
	QueueStack<Integer> stack = new QueueStack<Integer>();
	@BeforeEach
	void setUp() {
		stack.push(1);
		stack.push(5);
		stack.push(3);
		stack.push(2);
	}

	@Test
	void pop() {
		assertEquals(2, stack.pop());
		assertEquals(3, stack.pop());
		assertEquals(5, stack.pop());
		assertEquals(1, stack.pop());
		assertEquals(null, stack.pop());
	}

	@Test
	void popZero() {
		stack = new QueueStack<>();
		assertEquals(null, stack.pop());
	}
}