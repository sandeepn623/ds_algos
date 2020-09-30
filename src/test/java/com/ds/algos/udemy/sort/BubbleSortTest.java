package com.ds.algos.udemy.sort;

import org.junit.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubbleSortTest {

    @Test
    public void test_bubble_sort_ascending() {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        int[] sortedArrAsc = {-22, -15, 1, 7, 20, 35,55};

        BubbleSort bubbleSort = new BubbleSort();

        int[] bubbleSortedArray = bubbleSort.sortAscending(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(bubbleSortedArray));
        assertEquals(Arrays.toString(sortedArrAsc), Arrays.toString(bubbleSortedArray));

        int[] bubbleSortedArrayLeft = bubbleSort.sortAscendingLeft(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(bubbleSortedArrayLeft));
        assertEquals(Arrays.toString(sortedArrAsc), Arrays.toString(bubbleSortedArrayLeft));
    }

    @Test
    public void test_bubble_sort_descending() {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        int[] sortedArrDesc = {55, 35, 20, 7, 1, -15, -22};
        BubbleSort bubbleSort = new BubbleSort();

        int[] bubbleSortedArray = bubbleSort.sortDescending(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(bubbleSortedArray));
        assertEquals(Arrays.toString(sortedArrDesc), Arrays.toString(bubbleSortedArray));

        int[] bubbleSortedArrayLeft = bubbleSort.sortDescendingLeft(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(bubbleSortedArrayLeft));
        assertEquals(Arrays.toString(sortedArrDesc), Arrays.toString(bubbleSortedArrayLeft));
    }

    @Test
    public void test_bubble_sort_empty_array() {
        int[] arr = {};
        BubbleSort bubbleSort = new BubbleSort();
        int[] bubbleSortedArray = bubbleSort.sortAscending(arr);
        System.out.println(Arrays.toString(bubbleSortedArray));
        assertEquals(0, bubbleSortedArray.length);
        bubbleSortedArray = bubbleSort.sortDescending(arr);
        System.out.println(Arrays.toString(bubbleSortedArray));
        assertEquals(0, bubbleSortedArray.length);
    }
}
