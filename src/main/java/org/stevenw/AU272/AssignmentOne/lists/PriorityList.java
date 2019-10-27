package org.stevenw.AU272.AssignmentOne.lists;

public class PriorityList<E extends Comparable<E>> extends SingleLinkedList<Comparable<E>> {
    //SingleLinkedNode<Comparable<E>> head;
    SingleLinkedNode<Comparable<E>> tail;

    @Override
    public boolean add(Comparable<E> element) {
        SingleLinkedNode<Comparable<E>> node = new SingleLinkedNode<Comparable<E>>(element);

        if (size() == 0) {
            head = node;

            //System.out.println("size0" + element.toString());
        } else if (element.compareTo((E) head.getData()) < 0) { // less than
            //System.out.println("lessthan1st" + element.toString());
            node.setNext(head);
            head = node;
            if (head.getNext().getNext() == null) {
                tail = head.getNext();
            }
        } else { //equal to or greater
            //System.out.println("lessthan2nd" + element.toString());

            SingleLinkedNode<Comparable<E>> node0 = head;
            //System.out.println("node0" + node0.getData().toString());
            SingleLinkedNode<Comparable<E>> node1 = head.getNext();
            if (node1 == null) {
                head.setNext(node);
            } else {
                //System.out.println("node1" + node1.getData().toString());
                while (node1 != null && node1.getData() != null) {
                    //System.out.println("whileloop");
                    E nodeData = (E) node.getData();
                    if ((nodeData.compareTo((E) node1.getData())) < 0) {
                        //System.out.println("whileloopif");
                        node.setNext(node1);
                        node0.setNext(node);
                        break;
                    } else {
                        node0 = node0.getNext();
                        node1 = node1.getNext();
                        if (node1 == null) {
                            node0.setNext(node);
                            tail = node;
                        }
                    }

                }
            }
        }
        size++;
        return true;
    }
}
