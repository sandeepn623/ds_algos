package com.ds.algos.udemy.queue;

import org.junit.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayQueueTest {

    @Test
    public void test_enqueue_items_queue() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(2);
        Object[] expectedQueue = {1, 2};
        arrayQueue.add(1);
        arrayQueue.add(2);
        String result = arrayQueue.toString();
        System.out.println(result);
        assertEquals(Arrays.toString(expectedQueue), result);
    }

    @Test
    public void test_dequeue_items_queue() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(2);
        Object[] expectedQueue = {1, 2};
        arrayQueue.add(1);
        arrayQueue.add(2);
        String result = arrayQueue.toString();
        System.out.println(result);
        assertEquals(Arrays.toString(expectedQueue), result);

        //dequeue 1
        assertEquals(1, arrayQueue.remove());
        System.out.println(arrayQueue.toString());
        assertEquals(Arrays.toString(new int[] {2}), arrayQueue.toString());

        //dequeue 2
        assertEquals(2, arrayQueue.remove());
        System.out.println(arrayQueue.toString());
        assertEquals(Arrays.toString(new int[0]), arrayQueue.toString());
    }

    @Test
    public void test_queue_peek_item() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(2);
        Object[] expectedQueue = {1, 2};
        arrayQueue.add(1);
        arrayQueue.add(2);
        int peekValue = (int) arrayQueue.peek();
        assertEquals(1, peekValue);
        String result = arrayQueue.toString();
        System.out.println(result);
        assertEquals(Arrays.toString(expectedQueue), result);
    }

    @Test
    public void test_queue_dequeue_and_queue_item_queue_resize() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(2);
        arrayQueue.add(1);
        arrayQueue.add(2);
        System.out.println(arrayQueue.toString());
        assertEquals(Arrays.toString(new int[]{1, 2}), arrayQueue.toString());
        arrayQueue.remove();
        arrayQueue.remove();
        System.out.println(arrayQueue.toString());
        assertEquals(Arrays.toString(new int[0]), arrayQueue.toString());
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        System.out.println(arrayQueue.toString());
        assertEquals(Arrays.toString(new int[]{1, 2, 3}), arrayQueue.toString());
        assertEquals(4, arrayQueue.getCapacity());
    }

    @Test(expected = NoSuchElementException.class)
    public void test_queue_dequeue_no_such_element() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(2);
        arrayQueue.add(1);
        arrayQueue.add(2);
        System.out.println(arrayQueue.toString());
        assertEquals(Arrays.toString(new int[]{1, 2}), arrayQueue.toString());
        arrayQueue.remove();
        arrayQueue.remove();
        arrayQueue.remove();
    }

    @Test
    public void test_queue_default_size() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        System.out.println(arrayQueue.toString());
        assertEquals(5, arrayQueue.getCapacity());
    }

    @Test
    public void test_print_on_empty_queue() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(2);
        Object[] expectedQueue = {};
        String result = arrayQueue.toString();
        System.out.println(result);
        assertEquals(Arrays.toString(expectedQueue), result);
    }

    @Test
    public void test_items_circular_queue() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(5);
        arrayQueue.add(0);
        arrayQueue.add(1);
        arrayQueue.add(2);
        //dequeue 1
        assertEquals(0, arrayQueue.remove());
        arrayQueue.add(3);
        //dequeue 2
        assertEquals(1, arrayQueue.remove());
        arrayQueue.add(4);
        //dequeue 3
        assertEquals(2, arrayQueue.remove());
        arrayQueue.add(5);
        System.out.println(arrayQueue.toString());
        assertEquals(3, arrayQueue.getQueue()[3]);
        assertEquals(4, arrayQueue.getQueue()[4]);
        assertEquals(5, arrayQueue.getQueue()[0]);
        assertEquals(3, arrayQueue.size());
        assertEquals(5, arrayQueue.getCapacity());
    }

    @Test
    public void test_items_circular_unwrapped_queue() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(5);
        arrayQueue.add(0);
        arrayQueue.add(1);
        arrayQueue.add(2);
        //dequeue 1
        assertEquals(0, arrayQueue.remove());
        arrayQueue.add(3);
        //dequeue 2
        assertEquals(1, arrayQueue.remove());
        arrayQueue.add(4);
        //dequeue 3
        assertEquals(2, arrayQueue.remove());
        arrayQueue.add(5);
        System.out.println(arrayQueue.toString());
        assertEquals(3, arrayQueue.getQueue()[3]);
        assertEquals(4, arrayQueue.getQueue()[4]);
        assertEquals(5, arrayQueue.getQueue()[0]);
        assertEquals(3, arrayQueue.size());
        assertEquals(5, arrayQueue.getCapacity());
        arrayQueue.add(0);
        arrayQueue.add(1);
        arrayQueue.add(2);
        System.out.println(arrayQueue.toString());
        assertEquals(3, arrayQueue.getQueue()[0]);
        assertEquals(4, arrayQueue.getQueue()[1]);
        assertEquals(5, arrayQueue.getQueue()[2]);
        assertEquals(0, arrayQueue.getQueue()[3]);
        assertEquals(1, arrayQueue.getQueue()[4]);
        assertEquals(2, arrayQueue.getQueue()[5]);
        assertEquals(6, arrayQueue.size());
        assertEquals(10, arrayQueue.getCapacity());

    }

    @Test
    public void test_enqueue_items_circular_queue() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(5);
        arrayQueue.add(0);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        arrayQueue.add(4);
        arrayQueue.add(5);
        assertEquals(6, arrayQueue.size());
        assertEquals(10, arrayQueue.getCapacity());
        System.out.println(arrayQueue.toString());
    }
}
