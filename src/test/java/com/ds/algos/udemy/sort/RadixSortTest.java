package com.ds.algos.udemy.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadixSortTest {

    @Test
    public void test_radix_sort_ascending() {
        int[] intArray = {4725, 4586, 1330, 8792, 1594, 5729};
        int [] sortedArray = {1330, 1594 , 4586 , 4725, 5729, 8792};
        RadixSort radixSort = new RadixSort();
        radixSort.radixSort(intArray, 10, Integer.toString(intArray[0]).length());
        System.out.println(Arrays.toString(intArray));
        assertEquals(Arrays.toString(sortedArray), Arrays.toString(intArray));
    }

    @Test
    public void test_radix_sort_ascending_empty_input() {
        int[] intArray = {};
        int [] sortedArray = {};
        RadixSort radixSort = new RadixSort();
        radixSort.radixSort(intArray, 10, Integer.toString(intArray.length!=0?intArray[0]:0).length());
        System.out.println(Arrays.toString(intArray));
        assertEquals(Arrays.toString(sortedArray), Arrays.toString(intArray));
    }
}
