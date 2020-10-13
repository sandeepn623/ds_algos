package com.ds.algos.udemy.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadixSortTest {

    @Test
    public void test_radix_sort_ascending() {
        int[] intArray = {4725, 4586, 1330, 8792, 1594, 5729};
        int[] sortedArray = {1330, 1594 , 4586 , 4725, 5729, 8792};
        RadixSortIntegers radixSortIntegers = new RadixSortIntegers();
        radixSortIntegers.radixSort(intArray, 10, Integer.toString(intArray[0]).length());
        System.out.println(Arrays.toString(intArray));
        assertEquals(Arrays.toString(sortedArray), Arrays.toString(intArray));
    }

    @Test
    public void test_radix_sort_binary_ascending() {
        String[] binaryArray = {"0001", "0100", "0110", "1000", "1001", "0011", "0010", "0101"};
        String[] sortedArray = {"0001", "0010", "0011" , "0100", "0101", "0110", "1000", "1001"};
        int[] intArray = new int[binaryArray.length];
        for(int i=0; i<binaryArray.length; i++) {
            intArray[i] = Integer.parseInt(binaryArray[i], 2);
        }
        System.out.println(Arrays.toString(intArray));
        RadixSortIntegers radixSortIntegers = new RadixSortIntegers();
        radixSortIntegers.radixSort(intArray, 10, Integer.toString(intArray[0]).length());
        System.out.println(Arrays.toString(intArray));
        for(int i=0; i<binaryArray.length; i++) {
            binaryArray[i] = Integer.toBinaryString(0x10 | intArray[i]).substring(1);
        }
        System.out.println(Arrays.toString(binaryArray));
        assertEquals(Arrays.toString(sortedArray), Arrays.toString(binaryArray));
    }

    @Test
    public void test_radix_sort_ascending_empty_input() {
        int[] intArray = {};
        int[] sortedArray = {};
        RadixSortIntegers radixSortIntegers = new RadixSortIntegers();
        radixSortIntegers.radixSort(intArray, 10, Integer.toString(intArray.length!=0?intArray[0]:0).length());
        System.out.println(Arrays.toString(intArray));
        assertEquals(Arrays.toString(sortedArray), Arrays.toString(intArray));
    }

    @Test
    public void test_radix_sort_ascending_string() {
        String[] stringArray = {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};
        String[] sortedArray = {"abcde", "bbbbb", "bcdef", "dbaqc", "omadd"};
        RadixSortStrings radixSortStrings = new RadixSortStrings();
        radixSortStrings.radixSort(stringArray, 26, stringArray.length != 0 ? stringArray[0].length() : 0);
        System.out.println(Arrays.toString(stringArray));
        assertEquals(Arrays.toString(sortedArray), Arrays.toString(stringArray));
    }
}
