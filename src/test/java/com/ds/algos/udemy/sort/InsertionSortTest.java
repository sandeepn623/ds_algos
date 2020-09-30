package com.ds.algos.udemy.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertionSortTest {

    @Test
    public void test_insertion_sort_ascending() {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        int[] sortedArrAsc = {-22, -15, 1, 7, 20, 35,55};

        InsertionSort insertionSort = new InsertionSort();

        int[] insertionSortedArray = insertionSort.sortAscending(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(insertionSortedArray));
        assertEquals(Arrays.toString(sortedArrAsc), Arrays.toString(insertionSortedArray));
    }

    @Test
    public void test_insertion_sort_descending() {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        int[] sortedArrDesc = {55, 35, 20, 7, 1, -15, -22};

        InsertionSort insertionSort = new InsertionSort();

        int[] insertionSortedArray = insertionSort.sortDescending(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(insertionSortedArray));
        assertEquals(Arrays.toString(sortedArrDesc), Arrays.toString(insertionSortedArray));
    }

    @Test
    public void test_insertion_sort_empty_array() {
        int[] arr = {};

        InsertionSort insertionSort = new InsertionSort();

        int[] insertionSortedArray = insertionSort.sortAscending(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(insertionSortedArray));
        assertEquals(0, insertionSortedArray.length);

        insertionSortedArray = insertionSort.sortDescending(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(insertionSortedArray));
        assertEquals(0, insertionSortedArray.length);
    }
}
