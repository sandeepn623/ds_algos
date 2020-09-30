package com.ds.algos.udemy.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectionSortTest {

    @Test
    public void test_selection_sort_ascending() {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        int[] sortedArrAsc = {-22, -15, 1, 7, 20, 35,55};

        SelectionSort selectionSort = new SelectionSort();
        int[] selectionSortedArray = selectionSort.sortAscending(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(selectionSortedArray));
        assertEquals(Arrays.toString(sortedArrAsc), Arrays.toString(selectionSortedArray));
    }

    @Test
    public void test_selection_sort_descending() {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        int[] sortedArrDesc = {55, 35, 20, 7, 1, -15, -22};

        SelectionSort selectionSort = new SelectionSort();
        int[] selectionSortedArray = selectionSort.sortDescending(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(selectionSortedArray));
        assertEquals(Arrays.toString(sortedArrDesc), Arrays.toString(selectionSortedArray));
    }

    @Test
    public void test_selection_sort_empty_array() {
        int[] arr = {};

        SelectionSort selectionSort = new SelectionSort();
        int[] selectionSortedArray = selectionSort.sortAscending(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(selectionSortedArray));
        assertEquals(0, selectionSortedArray.length);

        selectionSortedArray = selectionSort.sortDescending(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(selectionSortedArray));
        assertEquals(0, selectionSortedArray.length);
    }
}
