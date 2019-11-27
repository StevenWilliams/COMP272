package org.stevenw.AU272.A2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
	HashTable<Integer> table = new HashTable<Integer>();
	@BeforeEach
	void setup() {
		table.add(2);
		table.add(3);
	}

	@Test
	void size() {
		assertEquals(2, table.size());
	}

	@Test
	void add() {
		table.add(5);
		assertEquals(5, table.find(5));
	}

	@Test
	void find() {
		assertEquals(2, table.find(2));
	}

	@Test
	void remove() {
		table.remove(2);
		assertEquals(null, table.find(2));
	}
}