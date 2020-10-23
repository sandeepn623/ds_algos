package com.ds.algos.udemy.stack;

import com.ds.algos.udemy.list.SinglyLinkedList;

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
        if(stack.isEmpty())
            throw new StackOverFlowException();
        return stack.removeFirst().getValue();
    }

    public Object peek() {
        if(stack.isEmpty())
            throw new StackOverFlowException();
        return stack.getFirst().getValue();
    }

    public String printStack() {
        return stack.toString();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
