package com.ds.algos.udemy.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountingSortTest {

    @Test
    public void test_counting_sort_asc(){
        CountingSort countingSort = new CountingSort();
        int[] input = {2, 5, 9, 8 ,2, 8, 7, 10, 4, 3};
        int[] sortedArray = {2, 2, 3, 4, 5, 7, 8, 8, 9, 10};
        countingSort.countingSortAsc(input, 1, 10);
        System.out.println(Arrays.toString(input));
        assertEquals(Arrays.toString(sortedArray), Arrays.toString(input));
    }

    @Test
    public void test_counting_sort_desc(){
        CountingSort countingSort = new CountingSort();
        int[] input = {2, 5, 9, 8 ,2, 8, 7, 10, 4, 3};
        int[] sortedArray = {10, 9, 8, 8, 7, 5, 4, 3, 2, 2};
        countingSort.countingSortDesc(input, 1, 10);
        System.out.println(Arrays.toString(input));
        assertEquals(Arrays.toString(sortedArray), Arrays.toString(input));
    }
}
