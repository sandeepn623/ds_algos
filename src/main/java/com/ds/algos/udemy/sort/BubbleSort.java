package com.ds.algos.udemy.sort;

import java.util.Arrays;

public class BubbleSort {

    public enum SortingOrder {
        ASCENDING, DESCENDING;
    }

    public int[] sort(int[] arr, SortingOrder sortOrder) {
        for(int lastUnsortedIndex = arr.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--){
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if(sortOrder == SortingOrder.ASCENDING)
                    sortAscending(arr, i);
                else
                    sortDescending(arr, i);
            }
        }
        return arr;
    }

    private void sortAscending(int arr[], int i) {
        if(arr[i] > arr[i+1]) {
            swap(arr, i, i + 1);
        }
    }

    private void sortDescending(int arr[], int i) {
        if(arr[i] < arr[i+1]) {
            swap(arr, i, i + 1);
        }
    }

    private void swap(int[] arr, int i, int j) {
        if(i == j)
            return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
