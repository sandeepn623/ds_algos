package com.ds.algos.udemy.list;

import java.util.Comparator;

public class SortedLinkedList<T> extends SinglyLinkedList {

    private Comparator comparator = Comparator.naturalOrder();

    public void insertSortedIntegers(T value){
        if(isEmpty() || comparator.compare(first.getValue(), value) > 0) {
            addFirst(value);
            return;
        }
        addSorted(value);
    }

    public void addSorted(T newValue) {
        Node current = first.next;
        Node previous = first;
        while(current != null && comparator.compare(current.getValue(), newValue) < 0) {
            previous = current;
            current = current.next;
        }
        Node newNode = new Node(newValue);
        newNode.next = current;
        previous.next = newNode;
    }
}
