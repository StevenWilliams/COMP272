package org.stevenw.AU272.AssignmentOne.lists;

import org.stevenw.AU272.AssignmentOne.lists.DLList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class DLListTest {

    @org.junit.jupiter.api.Test
    void size() {
        //test add and remove
    }

    @org.junit.jupiter.api.Test
    void add() {
        DLList list = new DLList();
        assertEquals(0, list.size());
        list.add(45);
        assertEquals(1, list.size());
        assertEquals(45, list.get(0));
        list.add(32);
        list.add(5);
        assertEquals(32, list.get(1));
        assertEquals(5, list.get(2));

    }

    @org.junit.jupiter.api.Test
    void remove() {
        DLList list = new DLList();
        assertEquals(0, list.size());
        list.add(45);
        list.add(32);
        list.add(5);
        list.remove(0);
        assertEquals(32, list.get(0));
        assertEquals(5, list.get(1));

    }

    @org.junit.jupiter.api.Test
    void reverse() {
        DLList<Integer> list = new DLList<Integer>();
        list.add(5);
        list.add(3);
        list.add(3);
        list.add(1);
        list.add(13);
        list.add(10);
        list.reverse();
        assertEquals(10, list.get(0));
        assertEquals(13, list.get(1));
        assertEquals(1, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(3, list.get(4));
        assertEquals(5, list.get(5));

        //zero elements
        list = new DLList<Integer>();
        list.reverse();
        assertEquals(null, list.get(0));


        //1 element
        list.add(1);
        list.reverse();
        assertEquals(1, list.get(0));


    }
    @org.junit.jupiter.api.Test
    void swapAdjacent() {
        DLList list = new DLList<Integer>();

        list.add(5);
        list.add(3);
        list.add(3);
        list.add(1);
        list.add(13);
        list.swapAdjacent(0);
        assertEquals(3, list.get(0));
        assertEquals(5, list.get(1));

        list.swapAdjacent(2);
        assertEquals(1, list.get(2));
        assertEquals(3, list.get(3));
    }
}