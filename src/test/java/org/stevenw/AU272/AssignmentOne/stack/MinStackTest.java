package org.stevenw.AU272.AssignmentOne.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {
	MinStack<Integer> stack;

	@BeforeEach
	void setUp() {
		stack = new MinStack<Integer>();
		stack.push(7);
		stack.push(1);
		stack.push(5);
		stack.push(3);
		stack.push(2);
	}

	@Test
	void pop() {
		//test normal stack behavior
		assertEquals(2, stack.pop());
		assertEquals(3, stack.pop());
		assertEquals(5, stack.pop());
		assertEquals(1, stack.pop());
		assertEquals(7, stack.pop());
	}

	@Test
	void min() {
		assertEquals(1, stack.min());
		stack.pop();
		assertEquals(1, stack.min());
		stack.pop();
		assertEquals(1, stack.min());
		stack.pop();
		assertEquals(1, stack.min());
		stack.pop();
		assertEquals(7, stack.min());
		stack.pop();
		assertNull(stack.min());

	}
}