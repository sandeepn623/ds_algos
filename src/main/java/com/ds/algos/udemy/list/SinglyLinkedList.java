package com.ds.algos.udemy.list;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.NoSuchElementException;

@Data
@NoArgsConstructor
public class SinglyLinkedList<T> {

    private Node first;
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

    public void removeFirst(){
        if(isEmpty()) throw new NoSuchElementException();
        if(first == last) {
            first = last = null;
            return;
        }
        Node removedNode = first;
        Node second = first.next;
        first.next = null;
        first = second;
        second=null;
    }

    public void removeLast() {
        Node previousNode = getPreviousNode();
        if(isEmpty()) throw new NoSuchElementException();
        if(first == last) {
            first = last = null;
            return;
        }
        last = previousNode;
        previousNode = null;
        last.next = null;
        //[10 -> 20 -> 30 ]
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

    private static class Node<T> {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }
    }
}
