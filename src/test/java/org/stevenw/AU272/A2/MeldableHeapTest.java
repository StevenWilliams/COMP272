package org.stevenw.AU272.A2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeldableHeapTest {
	MeldableHeap<Integer> heap = new MeldableHeap<>();
	MeldableHeap.Node<Integer> node20 = new MeldableHeap.Node<Integer>(20);
	MeldableHeap.Node<Integer> node3 = new MeldableHeap.Node<Integer>(3);
	MeldableHeap.Node<Integer> node15 = new MeldableHeap.Node<Integer>(15);
	MeldableHeap.Node<Integer> node25 = new MeldableHeap.Node<Integer>(25);

	@BeforeEach
	void setup() {
		heap = new MeldableHeap<>();
		heap.add(node20);
		heap.add(node3);
		heap.add(node15);
		heap.add(node25);
	}

	@Test
	void remove() {
		assertEquals(3, heap.remove());
		assertEquals(15, heap.remove());
		assertEquals(20, heap.remove());
		assertEquals(25, heap.remove());
		assertEquals(null, heap.remove());

	}

	@Test
	void removeNode3() {
		heap.remove(node3);
		assertEquals(15, heap.remove());
		assertEquals(20, heap.remove());
		assertEquals(25, heap.remove());
	}


	@Test
	void removeNode15() {
		heap.remove(node15);
		assertEquals(3, heap.remove());
		assertEquals(20, heap.remove());
		assertEquals(25, heap.remove());
	}

	@Test
	void removeNode3_15() {
		heap.remove(node3);
		heap.remove(node15);
		assertEquals(20, heap.remove());
		assertEquals(25, heap.remove());
	}
	@Test
	void removeNode15_25() {
		heap.remove(node15);
		heap.remove(node25);
		assertEquals(3, heap.remove());
		assertEquals(20, heap.remove());
		assertEquals(null, heap.remove());
	}

	@Test
	void removeNode25() {
		heap.remove(node25);
		assertEquals(3, heap.remove());
		assertEquals(15, heap.remove());
		assertEquals(20, heap.remove());
		assertEquals(null, heap.remove());
	}
}
