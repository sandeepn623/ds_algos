package com.ds.algos.coding.patterns.sliding.window;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LongestSubstringKDistinctTest {

    @Test
    public void test_longest_substring_sliding_window(){
        LongestSubstringKDistinct instance = new LongestSubstringKDistinct();
        int maxLength = instance.findLengthSmallestWindow("araaaiai", 2);
        System.out.println("sliding window long substring length is : " + maxLength);
        assertEquals(6, maxLength);
    }

    @Test
    public void test_longest_substring_original_solution(){
        LongestSubstringKDistinct instance = new LongestSubstringKDistinct();
        int maxLength = instance.findMaxLength("cbbebi", 3);
        System.out.println("sliding window long substring length is : " + maxLength);
        assertEquals(5, maxLength);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_longest_substring_empty_input_string(){
        LongestSubstringKDistinct instance = new LongestSubstringKDistinct();
        instance.findMaxLength("", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_longest_substring_null_input(){
        LongestSubstringKDistinct instance = new LongestSubstringKDistinct();
        instance.findMaxLength(null, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_longest_substring_distinct_char_greater_than_input_string(){
        LongestSubstringKDistinct instance = new LongestSubstringKDistinct();
        instance.findMaxLength("xyz", 6);
    }
}
