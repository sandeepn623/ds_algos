package com.ds.algos.udemy.search;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchIterativeTest {

    @Test
    public void test_binary_search_key_found_in_left_array() {
        BinarySearchIterative instance = new BinarySearchIterative();
        int[] arr = {-22,-15,1,7,20,35,55};
        int index = instance.binarySearch(arr, 1);
        assertEquals(2, index);
    }

    @Test
    public void test_binary_search_key_found_in_right_array_odd_length() {
        BinarySearchIterative instance = new BinarySearchIterative();
        int[] arr = {-22,-15,1,7,20,35,55};
        int index = instance.binarySearch(arr, 35);
        assertEquals(5, index);
    }

    @Test
    public void test_binary_search_key_found_in_left_array_even_length() {
        BinarySearchIterative instance = new BinarySearchIterative();
        int[] arr = {1,2,3,4,5,6,7,8};
        int index = instance.binarySearch(arr, 4);
        assertEquals(3, index);
    }

    @Test
    public void test_binary_search_key_found_in_right_array_even_length() {
        BinarySearchIterative instance = new BinarySearchIterative();
        int[] arr = {1,2,3,4,5,6,7,8};
        int index = instance.binarySearch(arr, 8);
        assertEquals(7, index);
    }



    @Test
    public void test_binary_search_key_not_found() {
        BinarySearchIterative instance = new BinarySearchIterative();
        int[] arr = {1,2,3,4,5,6,7,8};
        int index = instance.binarySearch(arr, 20);
        assertEquals(-1, index);
    }
}
