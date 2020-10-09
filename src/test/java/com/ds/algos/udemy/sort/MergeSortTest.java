package com.ds.algos.udemy.sort;

import com.ds.algos.udemy.sort.recursive.MergeSort;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeSortTest {

    @Test
    public void test_merge_sort_ascending() {
        int[] integerArray = {20, 35, -15, 7, 55, 1, -22};
        int[] sortedArrAsc = {-22, -15, 1, 7, 20, 35,55};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(integerArray, 0, integerArray.length, true);
        System.out.println(Arrays.toString(integerArray));
        assertEquals(Arrays.toString(sortedArrAsc), Arrays.toString(integerArray));
    }

    @Test
    public void test_merge_sort_descending() {
        int[] integerArray = {20, 35, -15, 7, 55, 1, -22};
        int[] sortedArrDesc = {55, 35, 20, 7, 1, -15, -22};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(integerArray, 0, integerArray.length, false);
        System.out.println(Arrays.toString(integerArray));
        assertEquals(Arrays.toString(sortedArrDesc), Arrays.toString(integerArray));
    }
}
