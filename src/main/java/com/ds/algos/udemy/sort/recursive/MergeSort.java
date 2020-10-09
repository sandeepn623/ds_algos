package com.ds.algos.udemy.sort.recursive;

import java.util.Arrays;

public class MergeSort {

    /**
     * split the array into 2 parts left and right until the each array is of size 1.
     * Merge them each array checking by comparing increment the index of the array where the value is less
     *                  {20, 35, -15, 7, 55, 1, -22}
     *                          /                 \
     *                         /                   \
     *                  {20, 35, -15}            {7, 55, 1, -22}
     *                       /    \                  /        \
     *                   {20}   {35, -15}        {7, 55}     {1, -22}
     *                            /    \        /     \       /     \
     *                          {35}  {-15}   {7}    {55}    {1}   {-22}
     */

    // TODO Do a pen and paper once

    //{20, 35, -15, 7, 55, 1, -22}
    public void mergeSort(int[] input, int start, int end, boolean sortAscending) {
        if(end - start < 2) {
            return;
        }
        int mid = (start+end)/2;
        mergeSort(input, start, mid, sortAscending);
        mergeSort(input, mid, end, sortAscending);
        if(sortAscending)
            mergeAscending(input, start, mid, end);
        else
            mergeDescending(input, start, mid, end);
    }

    //{20, 35, -15, 7, 55, 1, -22}
    private void mergeAscending(int[] input, int start, int mid, int end) {
        if(input[mid-1] <= input[mid]) {
            return;
        }
        int i = start, j = mid, tempIndex = 0;
        int[] temp = new int[end-start];
        while(i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }
        System.arraycopy(input, i, input, start+tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }

    //{20, 35, -15, 7, 55, 1, -22}
    private void mergeDescending(int[] input, int start, int mid, int end) {
        if(input[mid-1] >= input[mid]) {
            return;
        }
        int i = start, j = mid, tempIndex = 0;
        int[] temp = new int[end-start];
        while(i < mid && j < end) {
            temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];
        }
        System.arraycopy(input, i, input, start+tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }


}
