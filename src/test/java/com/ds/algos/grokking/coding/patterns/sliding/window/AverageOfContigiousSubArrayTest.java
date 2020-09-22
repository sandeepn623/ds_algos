package com.ds.algos.grokking.coding.patterns.sliding.window;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AverageOfContigiousSubArrayTest {

    public double[] expectedResult = {2.2, 2.8, 2.4, 3.6, 2.8};

    @Test
    public void test_avg_of_sub_array_brute_force(){
        AverageOfContigiousSubArray instance = new AverageOfContigiousSubArray();
        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int K = 5;
        assertEquals(Arrays.toString(expectedResult), Arrays.toString(instance.findAvgBruteForce(K, arr)));
    }

    @Test
    public void test_avg_of_sub_array_sliding_window(){
        AverageOfContigiousSubArray instance = new AverageOfContigiousSubArray();
        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int K = 5;
        assertEquals(Arrays.toString(expectedResult), Arrays.toString(instance.findAvgSlidingWindow(K, arr)));
    }

    @Test(expected = NegativeArraySizeException.class)
    public void test_avg_of_sub_array_brute_force_with_empty_input_array(){
        AverageOfContigiousSubArray instance = new AverageOfContigiousSubArray();
        int[] arr = new int[0];
        int K = 5;
        instance.findAvgBruteForce(K, arr);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void test_avg_of_sub_array_sliding_window_with_empty_input_array(){
        AverageOfContigiousSubArray instance = new AverageOfContigiousSubArray();
        int[] arr = new int[0];
        int K = 5;
        instance.findAvgSlidingWindow(K, arr);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void test_avg_of_sub_array_greater_than_input_array_brute_force(){
        AverageOfContigiousSubArray instance = new AverageOfContigiousSubArray();
        int[] arr = new int[0];
        int K = 5;
        instance.findAvgBruteForce(K, arr);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void test_avg_of_sub_array_greater_than_input_array_sliding_window(){
        AverageOfContigiousSubArray instance = new AverageOfContigiousSubArray();
        int[] arr = {1, 2, 3};
        int K = 5;
        instance.findAvgSlidingWindow(K, arr);
    }
}
