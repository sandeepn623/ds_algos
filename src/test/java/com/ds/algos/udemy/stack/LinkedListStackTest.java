package com.ds.algos.udemy.stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListStackTest {

    @Test
    public void test_stack_push_items() {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        Object[] expectedStack = {2, 1};
        linkedListStack.push(1);
        linkedListStack.push(2);
        String result = linkedListStack.toString();
        System.out.println(result);
        assertEquals(Arrays.toString(expectedStack), result);
    }

    @Test
    public void test_stack_pop_on_empty_stack() {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        Object popItem = linkedListStack.pop();
        assertEquals(null, popItem);
    }

    @Test
    public void test_stack_pop_item() {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        Object[] expectedStack = {1};
        linkedListStack.push(1);
        linkedListStack.push(2);
        Object popValue = linkedListStack.pop();
        assertEquals(2, popValue);
        String result = linkedListStack.toString();
        System.out.println(result);
        assertEquals(Arrays.toString(expectedStack), result);
    }

    @Test
    public void test_stack_peek_item() {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        Object[] expectedStack = {2, 1};
        linkedListStack.push(1);
        linkedListStack.push(2);
        Object peekValue = linkedListStack.peek();
        assertEquals(2, peekValue);
        String result = linkedListStack.toString();
        System.out.println(result);
        assertEquals(Arrays.toString(expectedStack), result);
    }

    @Test
    public void test_print_on_empty_stack() {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        Object[] expectedStack = {};
        String result = linkedListStack.toString();
        System.out.println(result);
        assertEquals(Arrays.toString(expectedStack), result);
    }
}
