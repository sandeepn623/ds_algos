package com.ds.algos.udemy.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BucketSortTest {

    @Test
    public void test_bucket_sort() {
        BucketSort instance = new BucketSort();
        int[] unsortedArray = {54, 46, 83, 66, 95, 92, 43};
        int[] expectedArray = {43, 46, 54, 66, 83, 92, 95};
        instance.bucketSort(unsortedArray, 10, String.valueOf(unsortedArray[0]).length()-1);
        System.out.println(Arrays.toString(unsortedArray));
        assertEquals(Arrays.toString(expectedArray), Arrays.toString(unsortedArray));
    }
}
