package com.ds.algos.udemy.list;

import java.util.Comparator;
import java.util.Objects;

public class SortedLinkedList<E> extends SinglyLinkedList {

    private final Comparator comparator = Comparator.naturalOrder();

    public void insertSortedIntegers(E value){
        if(isEmpty() || comparator.compare(getFirst().getValue(), value) > 0) {
            addFirst(value);
            return;
        }
        addSorted(value);
    }

    public void addSorted(E newValue) {
        Node<E> current = getFirst().next;
        Node<E> previous = getFirst();
        while(current != null && comparator.compare(current.getValue(), newValue) < 0) {
            previous = current;
            current = current.next;
        }
        Node<E> newNode = new Node<>(newValue);
        newNode.next = current;
        previous.next = newNode;
        if(Objects.isNull(current)) {
            setLast(newNode);
        }
    }
}
