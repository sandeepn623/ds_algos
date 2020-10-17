package com.ds.algos.udemy.search;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinearSearchTest {

    @Test
    public void test_linear_search_key_found(){
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        LinearSearch linearSearch = new LinearSearch();
        int position = linearSearch.linearSearch(arr, -22);
        assertEquals(6, position);
    }

    @Test
    public void test_linear_search_key_not_found(){
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        LinearSearch linearSearch = new LinearSearch();
        int position = linearSearch.linearSearch(arr, 100);
        assertEquals(-1, position);
    }
}
