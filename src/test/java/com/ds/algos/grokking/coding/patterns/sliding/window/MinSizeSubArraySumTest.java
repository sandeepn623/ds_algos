package com.ds.algos.grokking.coding.patterns.sliding.window;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinSizeSubArraySumTest {

    @Test
    public void test_min_size_of_sub_array_sum_brute_force(){
        MinSizeSubArraySum instance = new MinSizeSubArraySum();
        int[] arr = {2, 1, 5, 2, 8};
        int S = 7;
        assertEquals(1, instance.findMinSubArrayBruteForce(S, arr));
    }

    @Test
    public void test_min_size_of_sub_array_sum_sliding_window(){
        MinSizeSubArraySum instance = new MinSizeSubArraySum();
        int[] arr = {3, 4, 1, 1, 6};
        int S = 8;
        assertEquals(3, instance.findMinSubArraySlidingWindow(S, arr));
    }

    @Test
    public void test_min_size_of_sub_array_sum_not_found_brute_force(){
        MinSizeSubArraySum instance = new MinSizeSubArraySum();
        int[] arr = {2, 1, 5, 2, 8};
        int S = 20;
        assertEquals(0, instance.findMinSubArrayBruteForce(S, arr));
    }

    @Test
    public void test_min_size_of_sub_array_sum_not_found_sliding_window(){
        MinSizeSubArraySum instance = new MinSizeSubArraySum();
        int[] arr = {3, 4, 1, 1, 6};
        int S = 20;
        assertEquals(0, instance.findMinSubArraySlidingWindow(S, arr));
    }
}
