package org.stevenw.AU272.AssignmentOne.queue;

public interface Queue<T> {
	//FIFO
	void add(T element);

	T remove();

	T peek();

	int size();
}
