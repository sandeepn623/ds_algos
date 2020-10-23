package com.ds.algos.udemy.stack;

import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.EmptyStackException;

@NoArgsConstructor
public class ArrayStack<T> {

    private static final int DEFAULT_SIZE = 5;
    private int top;
    @Getter
    private Object[] stack = new Object[DEFAULT_SIZE];
    @Getter
    private int capacity = DEFAULT_SIZE;

    public ArrayStack(int top) {
        if(top > 0) {
            capacity = top;
            stack = new Object[top];
        }
    }

    public void push(T value) {
        if(top >= capacity)
            throw new StackOverFlowException();
        stack[top++] = value;
    }

    public Object pop() {
        if(isEmpty())
            throw new EmptyStackException();

        Object topValue = stack[--top];
        stack[top] = null;
        return topValue;
    }

    public Object peek() {
        if(isEmpty())
            throw new EmptyStackException();

        return stack[top -1];
    }

    private boolean isEmpty() {
        return top == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = top-1; i >= 0; i--) {
           sb.append(stack[i]);
           if(i > 0) {
               sb.append(", ");
           }
        }
        sb.append("]");
        return sb.toString();
    }
}
