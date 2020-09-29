package com.ds.algos.udemy.sort;

public class BubbleSort {

    public int[] sort(int[] arr, SortOrder sortOrder) {
        for(int lastUnsortedIndex = arr.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--){
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if(sortOrder == SortOrder.ASCENDING)
                    sortAscending(arr, i, i+1);
                else
                    sortDescending(arr, i, i+1);
            }
        }
        return arr;
    }

    private void sortAscending(int arr[], int i, int j) {
        if(arr[i] > arr[j]) {
            swap(arr, i, i + 1);
        }
    }

    private void sortDescending(int arr[], int i, int j) {
        if(arr[i] < arr[j]) {
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
