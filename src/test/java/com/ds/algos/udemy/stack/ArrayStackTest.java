package com.ds.algos.udemy.stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ArrayStackTest {

    @Test
    public void test_stack_push_items() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(2);
        Object[] expectedStack = {2, 1};
        arrayStack.push(1);
        arrayStack.push(2);
        String result = arrayStack.toString();
        System.out.println(result);
        assertEquals(Arrays.toString(expectedStack), result);
    }

    @Test(expected = StackOverFlowException.class)
    public void test_stack_push_items_stack_over_flow() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(2);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
    }

    @Test(expected = EmptyStackException.class)
    public void test_stack_pop_on_empty_stack() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(2);
        arrayStack.pop();
    }

    @Test
    public void test_stack_pop_item() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(2);
        Object[] expectedStack = {1};
        arrayStack.push(1);
        arrayStack.push(2);
        int popValue = (int) arrayStack.pop();
        assertEquals(2, popValue);
        String result = arrayStack.toString();
        System.out.println(result);
        assertEquals(Arrays.toString(expectedStack), result);
    }

    @Test
    public void test_stack_peek_item() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(2);
        Object[] expectedStack = {2, 1};
        arrayStack.push(1);
        arrayStack.push(2);
        int peekValue = (int) arrayStack.peek();
        assertEquals(2, peekValue);
        String result = arrayStack.toString();
        System.out.println(result);
        assertEquals(Arrays.toString(expectedStack), result);
    }

    @Test
    public void test_print_on_empty_stack() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(2);
        Object[] expectedStack = {};
        String result = arrayStack.toString();
        System.out.println(result);
        assertEquals(Arrays.toString(expectedStack), result);
    }

    @Test
    public void test_stack_default_size() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        System.out.println(arrayStack.toString());
        assertEquals(5, arrayStack.getCapacity());
    }

    @Test(expected = StackOverFlowException.class)
    public void test_stack_pop_and_push_item_stack_over_flow() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(2);
        arrayStack.push(1);
        arrayStack.push(2);
        System.out.println(arrayStack.toString());
        arrayStack.pop();
        arrayStack.pop();
        System.out.println(arrayStack.toString());
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
    }
}
