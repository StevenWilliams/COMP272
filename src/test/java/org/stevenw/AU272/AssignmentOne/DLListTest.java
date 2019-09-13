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
        assertTrue(list.size() == 0);
        list.add(45);
        assertTrue(list.size() == 1);
        assertEquals(list.get(0), 45);
    }

    @org.junit.jupiter.api.Test
    void swapAdjacent() {

    }
}