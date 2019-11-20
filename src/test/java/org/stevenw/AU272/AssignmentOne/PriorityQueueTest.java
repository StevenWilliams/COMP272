package org.stevenw.AU272.AssignmentOne;

//import com.sun.tools.javac.util.Assert;

import org.junit.jupiter.api.Assertions;
//import static sun.jvm.hotspot.code.CompressedStream.L;


class PriorityQueueTest {
    PriorityQueue pq;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

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
        Assertions.assertEquals(pq.size(), 6);
        Assertions.assertEquals(pq.getLowest(), 2);
        Assertions.assertEquals(pq.getHighest(), 255);
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
        Assertions.assertEquals(pq.size(), 6);
        Assertions.assertEquals(pq.getLowest(), 2.114);
        Assertions.assertEquals(pq.getHighest(), 255.0);
        //pq = null;

    }

    @org.junit.jupiter.api.Test
    void addTestString() {
    }

    @org.junit.jupiter.api.Test
    void removeInt() {
        addTestInt();
        Assertions.assertNotNull(pq);
        int a = (int) pq.remove();
        Assertions.assertEquals(a, 2);
        Assertions.assertEquals(pq.getLowest(), 3);
    }

    @org.junit.jupiter.api.Test
    void size() {
    }

    @org.junit.jupiter.api.Test
    void getList() {
    }
}