package com.ds.algos.grokking.coding.patterns.sliding.window;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MaxSumSubArrayOfSizeKTest {

    @Test
    public void test_max_sum_of_sub_array_brute_force(){
        MaxSumSubArrayOfSizeK instance = new MaxSumSubArrayOfSizeK();
        int[] arr = {2, 1, 5, 1, 3, 2};
        int K = 3;
        assertEquals(9, instance.findMaxSumSubArrayBruteForce(K, arr));
    }

    @Test
    public void test_max_sum_of_sub_array_sliding_window(){
        MaxSumSubArrayOfSizeK instance = new MaxSumSubArrayOfSizeK();
        int[] arr = {2, 3, 4, 1, 5};
        int K = 2;
        assertEquals(7, instance.findMaxSumSubArraySlidingWindow(K, arr));
    }
}
