package com.ds.algos.udemy.list;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.NoSuchElementException;

@Data
@NoArgsConstructor
public class SinglyLinkedList<E> {

    private Node<E> first;
    private Node<E> last;

    //addFirst
    //addLast
    //deleteFirst
    //deleteLast
    //indexof
    //contains

    public void addFirst(E value) {
        Node<E> node = new Node<>(value);
        if(isEmpty())
           first = last = node;
        else {
            node.next = first;
            first = node;
        }
    }

    public void addLast(E value) {
       Node<E> node = new Node<>(value);
       if(isEmpty())
           first = last = node;
       else {
           last.next = node;
           last = node;
       }
    }

    public Node<E> removeFirst(){
        if(isEmpty()) throw new NoSuchElementException();
        Node<E> removedNode = first;
        if(first == last) {
            first = last = null;
        } else {
            Node<E> second = first.next;
            first.next = null;
            first = second;
        }
        return removedNode;
    }

    public Node<E> removeLast() {
        if(isEmpty()) throw new NoSuchElementException();
        Node<E> removedNode = last;
        if(first == last) {
            first = last = null;
        } else {
            last = getPreviousNode();
            last.next = null;
        }
        //[10 -> 20 -> 30 ]
        return removedNode;
    }

    private Node<E> getPreviousNode() {
        Node<E> current = this.first;
        while(current.next != last) {
            current = current.next;
        }
        return current;
    }

    public int indexOf(E value){
        int index = 0;
        for (Node<E> current = first; current != null; current = current.next) {
            if(current.value.equals(value)) return index;
            ++index;
        }
        return -1;
    }

    public boolean contains(E value) {
        return (indexOf(value) >=0);
    }

    public boolean isEmpty() {
        return (first == null);
    }

    @Override
    public String toString() {
        Node<E> node = this.getFirst();
        StringBuilder sb = new StringBuilder();
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
        private final T value;
        protected Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
