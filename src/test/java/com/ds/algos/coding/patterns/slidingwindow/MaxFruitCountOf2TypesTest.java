package com.ds.algos.coding.patterns.slidingwindow;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxFruitCountOf2TypesTest {

    @Test
    public void test_max_number_of_fruits(){
        MaxFruitCountOf2Types instance = new MaxFruitCountOf2Types();
        char[] fruits =  {'A', 'B', 'C', 'A', 'C'};
        System.out.println(instance.findLength(fruits));
        assertEquals(3, instance.findLength(fruits));
        char[] fruits1 =  {'A', 'B', 'C', 'B', 'B', 'C'};
        System.out.println(instance.findLength(fruits1));
        assertEquals(5, instance.findLength(fruits1));
    }

    @Test
    public void test_max_number_of_fruits_empty_array(){
        MaxFruitCountOf2Types instance = new MaxFruitCountOf2Types();
        char[] fruits= {};
        System.out.println(instance.findLength(fruits));
        assertEquals(0, instance.findLength(fruits));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_max_number_of_fruits_null_array(){
        MaxFruitCountOf2Types instance = new MaxFruitCountOf2Types();
        char[] fruits=null;
        System.out.println(instance.findLength(fruits));
        assertEquals(0, instance.findLength(fruits));
    }

}
