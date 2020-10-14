package com.ds.algos.udemy.list;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.NoSuchElementException;

@Data
@NoArgsConstructor
public class SinglyLinkedList<T> {

    protected Node first;
    private Node last;

    //addFirst
    //addLast
    //deleteFirst
    //deleteLast
    //indexof
    //contains

    public void addFirst(T value) {
        Node node = new Node(value);
        if(isEmpty())
           first = last = node;
        else {
            node.next = first;
            first = node;
        }
    }

    public void addLast(T value) {
       Node node = new Node(value);
       if(isEmpty())
           first = last = node;
       else {
           last.next = node;
           last = node;
       }
    }

    public Node removeFirst(){
        if(isEmpty()) throw new NoSuchElementException();
        Node removedNode = first;
        if(first == last) {
            first = last = null;
        } else {
            Node second = first.next;
            first.next = null;
            first = second;
        }
        return removedNode;
    }

    public Node removeLast() {
        if(isEmpty()) throw new NoSuchElementException();
        Node removedNode = last;
        if(first == last) {
            first = last = null;
        } else {
            Node previousNode = getPreviousNode();
            last = previousNode;
            last.next = null;
        }
        //[10 -> 20 -> 30 ]
        return removedNode;
    }

    private Node getPreviousNode() {
        Node current = this.first;
        while(current.next != last) {
            current = current.next;
        }
        return current;
    }

    public int indexOf(T value){
        int index = 0;
        for (Node current = first; current != null; current = current.next) {
            if(current.value.equals(value)) return index;
            ++index;
        }
        return -1;
    }

    public boolean contains(T value) {
        return (indexOf(value) >=0);
    }

    public boolean isEmpty() {
        return (first == null);
    }

    @Override
    public String toString() {
        Node node = this.getFirst();
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        while (node != null){
            sb.append(node.value);
            if(node.next != null) {
                sb.append(", ");
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static class Node<T> {
        @Getter
        private T value;
        protected Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    static class NaturalComparator<T extends Comparable<T>> implements Comparator<T> {
        public int compare(T a, T b) {
            return a.compareTo(b);
        }
    }
}
