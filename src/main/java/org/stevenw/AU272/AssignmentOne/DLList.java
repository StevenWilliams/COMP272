package org.stevenw.AU272.AssignmentOne;

public class DLList {
    public class Node<F> {

        private final F data;
        private Node<F> next;
        private Node<F> prev;

        public Node(F data) {
            this.data = data;
        }

        public F getData() {
            return data;
        }

        public Node<F> getNext() {
            return next;
        }

        public void setNext(Node<F> next) {
            this.next = next;
        }

        public Node<F> getPrev() {
            return prev;
        }

        public void setPrev(Node<F> prev) {
            this.prev = prev;
        }
    }

}

