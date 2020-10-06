package com.ds.algos.udemy.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTest {

    @Test
    public void test_quick_sort_empty_input() {
        QuickSort quickSort = new QuickSort();
        int[] intArray = {};
        int[] sortedArray = {};
        quickSort.quickSort(intArray, 0, intArray.length);
        assertEquals(Arrays.toString(sortedArray), Arrays.toString(intArray));
    }

    @Test
    public void test_quick_sort() {
        QuickSort quickSort = new QuickSort();
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        int[] sortedArray = {-22, -15, 1, 7, 20, 35, 55};
        quickSort.quickSort(intArray, 0, intArray.length);
        assertEquals(Arrays.toString(sortedArray), Arrays.toString(intArray));
    }
}
