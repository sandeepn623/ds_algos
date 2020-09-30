package com.ds.algos.udemy.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShellSortTest {

    @Test
    public void test_shell_sort_ascending() {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        int[] sortedArrAsc = {-22, -15, 1, 7, 20, 35,55};
        ShellSort shellSort = new ShellSort();
        int[] shellSortedArray = shellSort.sortAscending(arr);
        System.out.println(Arrays.toString(shellSortedArray));
        assertEquals(Arrays.toString(sortedArrAsc), Arrays.toString(shellSortedArray));
    }

    @Test
    public void test_shell_sort_descending() {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        int[] sortedArrDesc = {55, 35, 20, 7, 1, -15, -22};
        ShellSort shellSort = new ShellSort();
        int[] shellSortedArray = shellSort.sortDescending(arr);
        System.out.println(Arrays.toString(shellSortedArray));
        assertEquals(Arrays.toString(sortedArrDesc), Arrays.toString(shellSortedArray));
    }
}
