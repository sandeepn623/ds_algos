package com.ds.algos.practice.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstMissingPositiveNumberTest {

    @Test
    public void find_first_missing_positive_number_all_positive_number_array(){
        FirstMissingPositiveNumber firstMissingPositiveNumber = new FirstMissingPositiveNumber();
        int[] arr = {1, 2, 3};
        int missingPositiveNumber = firstMissingPositiveNumber.firstMissingPositive(arr);
        assertEquals(4, missingPositiveNumber);
    }

    @Test
    public void find_first_missing_positive_number_positive_number_array_with_zero(){
        FirstMissingPositiveNumber firstMissingPositiveNumber = new FirstMissingPositiveNumber();
        int[] arr = {1, 2, 3, 0};
        int missingPositiveNumber = firstMissingPositiveNumber.firstMissingPositive(arr);
        assertEquals(4, missingPositiveNumber);
    }

    @Test
    public void find_first_missing_positive_number_array_with_positive_and_negative_number(){
        FirstMissingPositiveNumber firstMissingPositiveNumber = new FirstMissingPositiveNumber();
        int[] arr = {3, 4, -1, 1, 5};
        int missingPositiveNumber = firstMissingPositiveNumber.firstMissingPositive(arr);
        assertEquals(2, missingPositiveNumber);
    }

    @Test
    public void find_first_missing_positive_number_array_with_only_negative_number(){
        FirstMissingPositiveNumber firstMissingPositiveNumber = new FirstMissingPositiveNumber();
        int[] arr = {-3, -4, -1, -1, -5};
        int missingPositiveNumber = firstMissingPositiveNumber.firstMissingPositive(arr);
        assertEquals(1, missingPositiveNumber);
    }

    @Test
    public void find_first_missing_positive_number_array_with_number_bigger_then_array_size(){
        FirstMissingPositiveNumber firstMissingPositiveNumber = new FirstMissingPositiveNumber();
        int[] arr = {8, 12, 10, 7, 6};
        int missingPositiveNumber = firstMissingPositiveNumber.firstMissingPositive(arr);
        assertEquals(1, missingPositiveNumber);
    }
}
