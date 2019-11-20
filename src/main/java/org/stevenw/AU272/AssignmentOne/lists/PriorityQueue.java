package org.stevenw.AU272.AssignmentOne.lists;

public class PriorityQueue<T extends Comparable<? super T>> extends SingleLinkedList<T>{

    /**
     * @return the element with the highest priority (lowest value)
     * Runtime will be O(1) as all it does is returns the top node, and replaces the top node reference with the next node.
     */
    public T deleteMin() {
        return this.remove();
    }
    /**
     * @param element an instance of the type's object (must be comparable)
     * Internal notes: if item's priority (less than in comparable) is higher than the current head,
     *                it will displace the head at constant time, otherwise if it's lower than the head it will loop the list
     *                from the top in linear time until it's in the appropriate place in priority order.
     */
    @Override
    public void add(T element) {
        SingleLinkedNode<T> node = new SingleLinkedNode<T>(element);


        if (size() == 0) {
            head = node;

            //System.out.println("size0" + element.toString());
        } else if (element.compareTo(head.getData()) < 0) {
            //higher priority items go to top
            //element < head
            //System.out.println("lessthan1st" + element.toString());
            node.setNext(head);
            head = node;
            if (head.getNext().getNext() == null) {
                tail = head.getNext();
            }
        } else {
            //lower priority go to bottom
            //System.out.println("lessthan2nd" + element.toString());

            SingleLinkedNode<T> node0 = head;
            //System.out.println("node0" + node0.getData().toString());
            SingleLinkedNode<T> node1 = head.getNext();
            if (node1 == null) {
                head.setNext(node);
            } else {
                //System.out.println("node1" + node1.getData().toString());
                while (node1 != null && node1.getData() != null) {
                    //System.out.println("whileloop");
                    T nodeData = node.getData();
                    if ((nodeData.compareTo( node1.getData())) < 0) {
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
    }
}
