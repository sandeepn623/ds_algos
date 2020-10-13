package com.ds.algos.udemy.list;

import lombok.Data;
import lombok.Getter;

import java.util.NoSuchElementException;

@Data
public class DoublyLinkedList<T> {

    private Node head;
    private Node tail;

    //addFirst
    //addLast
    //deleteFirst
    //deleteLast
    //indexof
    //contains
    public void addFirst(T value) {
        Node node = new Node(value);
        if(head == null) {
            head = tail = node;
        } else {
            node.next = head;
            //node.previous = head.previous; //not required as the previous in the new node is already set to null during object creation by default
            head.previous  = node;
            head = node;
        }
    }

    public void addLast(T value) {
        Node node = new Node(value);
        if(head == null) {
            head = tail = node;
        } else {
            //node.next = tail.next; //not required as the next in the new node is already set to null during object creation by default
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
    }

    public void addBefore(T newValue, T existingValue) {
        if(isEmpty()) throw new NoSuchElementException();
        Node currentNode = head;
        while(currentNode != null && !currentNode.value.equals(existingValue)) {
            currentNode = currentNode.next;
        }
        if(currentNode != null) {
            Node newNode = new Node(newValue);
            Node previous = currentNode.previous;
            newNode.next = currentNode;
            newNode.previous = previous;
            currentNode.previous = newNode;
            if(head == currentNode) {
                head = newNode;
            } else {
                previous.next = newNode;
            }

        } else {
            throw new NoSuchElementException();
        }
    }

    public Node removeFirst() {
        if(isEmpty()) throw new NoSuchElementException();
        if(head == tail) { // only one element in the list
            head = tail = null;
            return null;
        }
        Node removedNode = head;
        Node second = head.next;
        second.previous = head.previous;
        head.next = null;
        head = second;
        return removedNode;
    }

    public Node removeLast() {
        if(isEmpty()) throw new NoSuchElementException();
        if(head == tail) {  // only one element in the list
            head = tail = null;
            return null;
        }
        Node removedNode = tail;
        Node previous = tail.previous;
        previous.next = tail.next;
        tail.previous = null;
        tail = previous;
        return removedNode;
    }

    public int indexOf(T value) {
        int index=0;
        for(Node currentNode =head; currentNode != null; currentNode = currentNode.next) {
            if(currentNode.value.equals(value)) return index;
            ++index;
        }
        return -1;
    }

    public boolean contains(T value) {
        return indexOf(value)>=0;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public String toString() {
        Node node = this.getHead();
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

    static class Node<T> {
        @Getter
        private T value;
        private Node next;
        private Node previous;
        Node(T value) {
            this.value = value;
        }
    }
}
