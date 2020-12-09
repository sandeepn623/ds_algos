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
    private int size;
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
        size++;
    }

    public void addLast(E value) {
       Node<E> node = new Node<>(value);
       if(isEmpty())
           first = last = node;
       else {
           last.next = node;
           last = node;
       }
       size++;
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
        size--;
        return removedNode;
    }

    public Node<E> removeLast() {
        if(isEmpty()) throw new NoSuchElementException();
        Node<E> removedNode = last;
        if(first == last) {
            first = last = null;
        } else {
            last = getPreviousToLastNode();
            last.next = null;
        }
        size--;
        //[10 -> 20 -> 30 ]
        return removedNode;
    }

    public void insertAt(int index, E value) {
        Node<E> newNode = new Node<>(value);
        if(isEmpty()) {
            first=last=newNode;
        } else if(index == 0) {
            addFirst(value);
        } else if(index == size) {
            addLast(value);
        } else {
            Node<E> node = getPrevious(index);
            newNode.next=node.next;
            node.next=newNode;
            size++;
        }
    }

    public void removeAt(int index) {
        System.out.println(size);
        if(index == 0) {
            removeFirst();
        } else if(index == size-1) {
            removeLast();
        } else {
            Node<E> node = getPrevious(index);
            Node<E> temp = node.next;
            node.next = temp.next;
            temp.next = null;
        }
        size--;
    }

    public Node<E> getPrevious(int index) {
        if(index>size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = first;
        for(int i = 0; i < size; i++) {
            if(i==index-1) {
                return node;
            }
            node=node.next;
        }
        return node;
    }

    private Node<E> getPreviousToLastNode() {
        Node<E> current = this.first;
        while(current.next != last) {
            current = current.next;
        }
        return current;
    }

    public int indexOf(E value){
        int index = 0;
        for (Node<E> current = first; current != null; current = current.next) {
            if(current.value.equals(value)) {
                return index;
            }
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
