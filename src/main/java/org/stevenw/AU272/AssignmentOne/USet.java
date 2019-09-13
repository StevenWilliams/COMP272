package org.stevenw.AU272.AssignmentOne;

import org.stevenw.AU272.AssignmentOne.lists.DLList;

public class USet<T> {
    public class Pair {
        private Object key;
        private T value;
        private DLList<Pair> pairs;
        public Pair(Object key, T value) {
            this.key = key;
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Object getKey() {
            return key;
        }
    }
    private int size = 0;
    public int size() {
        return size;
    }

    public void add(T item) {
        if(pairs.)
    }

    public T remove(T item) {
        return null;
    }

    public T find(T item) {
        return null;
    }
}
