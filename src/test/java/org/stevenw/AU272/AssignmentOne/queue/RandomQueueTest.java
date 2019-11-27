package org.stevenw.AU272.AssignmentOne.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomQueueTest {
	RandomQueue<Integer> randomQueue;
	@BeforeEach
	void setup() {
		randomQueue = new RandomQueue<>();
	}
	@Test
	void sizeOne() {
		for(int i =0; i < 100; i++) {
			randomQueue.add(1);
			assertEquals(1, randomQueue.remove());
		}
	}

	@Test
	void sizeTwo() {

		int count1 = 0;
		int count2 = 0;
		for(int i =0; i < 10000; i++) {
			randomQueue.add(1);
			randomQueue.add(2);
			int next = randomQueue.peek();
			assertEquals(randomQueue.peek(), randomQueue.remove());
			if(next == 2) {
				count2++;
				assertEquals(1, randomQueue.remove());
			} else {
				count1++;
				assertEquals(2, randomQueue.remove());
			}
		}
		//ratio between them should be about equal, but adding in a lot of room just in case.
		//Test may fail very infrequently by chance.
		assert((float) count1/(float) count2 > 0.4 || ((float) count1/(float) count2) < 0.6);

	}
}