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
        int[] bubbleSortedArray = insertionSort.sortAscending(arr);
        System.out.println(Arrays.toString(sortedArrAsc));
        assertEquals(Arrays.toString(sortedArrAsc), Arrays.toString(bubbleSortedArray));
    }

    @Test
    public void test_insertion_sort_descending() {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        int[] sortedArrAsc = {55, 35, 20, 7, 1, -15, -22};
        InsertionSort insertionSort = new InsertionSort();
        int[] bubbleSortedArray = insertionSort.sortDescending(arr);
        System.out.println(Arrays.toString(sortedArrAsc));
        assertEquals(Arrays.toString(sortedArrAsc), Arrays.toString(bubbleSortedArray));
    }

    @Test
    public void test_insertion_sort_empty_array() {
        int[] arr = {};
        InsertionSort insertionSort = new InsertionSort();
        int[] insertionSortedArray = insertionSort.sortAscending(arr);
        System.out.println(Arrays.toString(insertionSortedArray));
        assertEquals(0, insertionSortedArray.length);
        insertionSortedArray = insertionSort.sortDescending(arr);
        System.out.println(Arrays.toString(insertionSortedArray));
        assertEquals(0, insertionSortedArray.length);
    }
}
