package com.ds.algos.udemy.stack;

import com.ds.algos.udemy.list.SinglyLinkedList;

import java.util.EmptyStackException;

public class LinkedListStack<T> {

    SinglyLinkedList<T> stack;

    public LinkedListStack() {
        stack = new SinglyLinkedList<>();
    }

    public void push(T value) {
        if(value == null)
            throw new IllegalArgumentException();
        stack.addFirst(value);
    }

    public Object pop() {
        if(isEmpty())
            throw new EmptyStackException();
        return stack.removeFirst().getValue();
    }

    public Object peek() {
        if(isEmpty())
            throw new EmptyStackException();
        return stack.getFirst().getValue();
    }

    @Override
    public String toString() {
        return stack.toString();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
