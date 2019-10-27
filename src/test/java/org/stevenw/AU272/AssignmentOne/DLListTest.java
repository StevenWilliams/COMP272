package org.stevenw.AU272.AssignmentOne;

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
        assertEquals(list.get(0), 45);
        list.add(32);
    }
    @org.junit.jupiter.api.Test
    void reverse() {
        DLList list = new DLList<Integer>();
        list.add(5);
        list.add(3);
        list.add(3);
        list.add(1);
        list.add(13);
        list.add(10);
        assertEquals(10, list.get(0));
        assertEquals(13, list.get(1));
        assertEquals(1, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(3, list.get(5));
        assertEquals(5, list.get(6));

    }
    @org.junit.jupiter.api.Test
    void swapAdjacent() {

    }
}