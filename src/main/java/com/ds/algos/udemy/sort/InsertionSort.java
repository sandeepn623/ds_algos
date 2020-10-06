package com.ds.algos.udemy.sort;

// {20, 35, -15, 7, 55, 1, -22}
public class InsertionSort {

    public int[] sortAscending(int[] arr) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
            int newElement = arr[firstUnsortedIndex];
            int j;
            for(j = firstUnsortedIndex; j > 0 && arr[j-1] > newElement; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = newElement;
        }
        return arr;
    }

    public int[] sortDescending(int[] arr) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
            int newElement = arr[firstUnsortedIndex];
            int j;
            for(j = firstUnsortedIndex; j > 0 && arr[j-1] < newElement; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = newElement;
        }
        return arr;
    }
}
