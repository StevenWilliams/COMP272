package org.stevenw.AU272.AssignmentOne.queue;

//import com.sun.tools.javac.util.Assert;

import org.junit.jupiter.api.Assertions;
//import static sun.jvm.hotspot.code.CompressedStream.L;


class PriorityQueueTest {
    PriorityQueue pq;

    @org.junit.jupiter.api.Test
    void addTestInt() {
        pq = new PriorityQueue();
        pq.add(16);
        pq.add(13);
        pq.add(255);
        pq.add(20);
        pq.add(3);
        pq.add(2);
        System.out.println("Size: " + pq.size() + " expected: " + 6);
        Assertions.assertEquals(6, pq.size());
        Assertions.assertEquals(2, pq.remove());
        Assertions.assertEquals(3, pq.remove());
        Assertions.assertEquals(13, pq.remove());
        Assertions.assertEquals(16, pq.remove());
        Assertions.assertEquals(20, pq.remove());
        Assertions.assertEquals(255, pq.remove());
        Assertions.assertEquals(null, pq.remove());

        //pq = null;
    }


    @org.junit.jupiter.api.Test
    void addTestLong() {
        pq = new PriorityQueue();
        pq.add(16.2);
        pq.add(13.3);
        pq.add(255.0);
        pq.add(20.1224);
        pq.add(2.114);
        pq.add(2.115);
        System.out.println("Size: " + pq.size() + " expected: " + 6);
        Assertions.assertEquals(6, pq.size());
        Assertions.assertEquals(2.114, pq.remove());
        Assertions.assertEquals(2.115, pq.remove());
        Assertions.assertEquals(4, pq.size());

        //pq = null;

    }

}