package com.ds.algos.udemy.sort;

public class SelectionSort{

    public int[] sort(int[] arr, SortOrder sortOrder) {

        for (int lastUnsortedIndex = arr.length -1; lastUnsortedIndex > 0 ; lastUnsortedIndex--) {
            int largest = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if(sortOrder == SortOrder.ASCENDING) {
                    if (arr[i] > arr[largest])
                        largest = i;
                } else {
                    if (arr[i] < arr[largest])
                        largest = i;
                }

            }
            swap(arr, largest, lastUnsortedIndex);
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        if(i == j)
            return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
