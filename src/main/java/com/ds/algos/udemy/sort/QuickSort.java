package com.ds.algos.udemy.sort;

public class QuickSort {

    //{20, 35,-15, 7, 55, 1, -22}
    public void quickSort(int [] arr, int start, int end) {
        if(end -start < 2)
            return;
        int partitionIndex = partition(arr, start, end);
        quickSort(arr, start, partitionIndex);
        quickSort(arr, partitionIndex+1, end);

    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start, j = end;

        while (i < j) {

            // empty loop trying to find the index of a value from right subarray which is lesser than pivot so that it can be moved after pivot.
            while(i < j && arr[--j] >= pivot);
            if(i < j) {
                arr[i] = arr[j];
            }

            // empty loop trying to find the index of a value from left subarray which is greater than pivot so that it can be moved after pivot.
            while(i < j && arr[++i] <= pivot);
            if(i < j) {
                arr[j] = arr[i];
            }
        }
        arr[j] = pivot;
        return j;
    }
}
