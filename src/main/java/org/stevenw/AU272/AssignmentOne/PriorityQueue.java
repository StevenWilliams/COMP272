package org.stevenw.AU272.AssignmentOne;

import java.util.ArrayList;

public class PriorityQueue<T extends Comparable<T>> { //make this extend SingleLinkedList???? todo
    public PriorityQueue() {
        list = new SingleLinkedList<T>();
    }
    /*
    Q1
    (25 marks total) Describe the meaning of the essential methods add(x), deleteMin(), and
size() that are supported by the priority queue interface (5 marks).
Implement those methods using a singly-linked list (5 marks for each method).
Analyze the running time of the add(x) and deletMin() operations based on this
implementation (5 marks).

b. (15 marks total) Implement the stack methods push(x) and pop() using two queues (5 marks
for each method).
Analyze the running time of the push(x) and pop() operations based on this implementation
(5 marks).


- A regular Queue typically operates in First In First Out Order, whereas a PriorityQueue allows for the processing of objects based on their priority, removing the smallest object first (ties broken arbitrarily).
- Priority Queues can only have objects that are Comparable
Describe the methods:
- add(element) - it adds an object to to the queue
- deleteMin() - may also known as remove(). This returns/removes the object with the highest priority (smallest value) from the queue.
- size() - returns an int that's the amount of elements in the queue.

     */
    private final SingleLinkedList<T> list;

    /**
     * @param
     * @return
     */
    public void sort() {

    }

    public T getHighest() {
        return list.getHighest();
    }

    public T getLowest() {
        return list.getLowest();
    }

    public boolean add(T e) {
        list.priorityAdd(e);
        return true;
    }
    public static void main(String[] args) {
	// write your code here
    Integer a = 5;
    Integer d = 22;
    Integer b = 7;
    Integer c = 3;

    PriorityQueue pq = new PriorityQueue<Integer>();
    pq.add(a);
    pq.add(b);
    pq.add(c);
    pq.add(d);
    pq.add(2);
    pq.add(7);
    PriorityQueue pq2 = new PriorityQueue<String>();
    pq2.add("d");
    pq2.add("b");
    pq2.add("aa");
    pq2.add("z");
    pq2.add("a");
    pq2.getList();
    String node0 = (String) pq2.remove();
    //with this it's only 3 and 22
    System.out.println(pq.getList());
        System.out.println(node0);
        System.out.println("-----");
        pq2.getList();
        pq2.remove();
        System.out.println("-----");
        pq2.getList();
        System.out.println("-----");
        pq2.remove();
        pq2.remove();
        pq2.getList();
        System.out.println("-----");
        pq2.remove();
        pq2.getList();
    }

    public T deleteMin() { //alias for remove
        return remove();
    }

    public T remove() {
        return list.remove();
    }
    public int size() {
        return list.size();
    }
    public ArrayList getList() {
        return list.getList();
    }

}
