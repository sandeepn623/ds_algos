package com.ds.algos.udemy.list;

public class SortedIntegerLinkedList extends SinglyLinkedList {

    public void insertSortedIntegers(int value){
        NaturalComparator comparator = new NaturalComparator();
        if(isEmpty() || comparator.compare((Integer) first.getValue(), value) > 0) {
            addFirst(value);
            return;
        }
        addSorted(value);
    }

    public void addSorted(int newValue) {
        Node current = first.next;
        Node previous = first;
        NaturalComparator comparator = new NaturalComparator();

        while(current != null && comparator.compare((Integer)current.getValue(), (Integer)newValue) < 0) {
            previous = current;
            current = current.next;
        }
        Node newNode = new Node(newValue);
        newNode.next = current;
        previous.next = newNode;
    }
}
