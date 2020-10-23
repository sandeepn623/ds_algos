package com.ds.algos.udemy.queue;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.NoSuchElementException;

@NoArgsConstructor
public class ArrayQueue<T> {

    private static final int DEFAULT_SIZE = 5;
    private int front;
    private int back;
    @Getter
    private Object[] queue = new Object[DEFAULT_SIZE];
    @Getter
    private int capacity = DEFAULT_SIZE;

    public ArrayQueue(int size) {
        if(size>0) {
            capacity = size;
            queue = new Object[size];
        }
    }

    public void add(T value){
        if(size() == capacity-1) {
            resize();
        }
        queue[back] = value;
        if(back < capacity-1) {
            back++;
        } else
            back=0;
    }

    private void resize() {
        int numItems = size();
        Object[] temp = new Object[capacity * 2];
        if(front<=back) {
            System.arraycopy(queue, front, temp, 0, capacity - front);
        } else {
            System.arraycopy(queue, front, temp, 0, capacity - front);
            System.arraycopy(queue, 0, temp, capacity - front, back);
            front = 0;
            back = numItems;
        }
        queue = temp;
        capacity= queue.length;
    }

    public Object remove() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Object value = queue[front];
        queue[front++] = null;
        if(isEmpty()) {
            front = back = 0;
        } else if(front == capacity) {
            front = 0;
        }
        return value;
    }

    public Object peek() {
        if(isEmpty()){
            front=back=0;
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public int size() {
        // not wrapped due to circular queue
        if(front<=back) {
            return (back-front);
        } else {
            return (back + (queue.length- front));
        }
    }

    public boolean isEmpty(){
        return (front==back);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(front<=back) {
            for (int i = front; i < back; i++) {
                sb.append(queue[i]);
                if (i < back - 1) {
                    sb.append(", ");
                }
            }
        } else {
            for (int i = front; i < queue.length; i++) {
                sb.append(queue[i]).append(", ");
            }
            for (int i = 0; i < back; i++) {
                sb.append(queue[i]);
                if (i < back - 1) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
