package com.ds.algos.udemy.sort;

public class BubbleSort {

    //growing sorted array on right
    public int[] sortAscending(int[] arr) {
        for(int lastUnsortedIndex = arr.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if(arr[i] > arr[i+1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
        return arr;
    }

    //growing sorted array on left
    public int[] sortAscendingLeft(int[] arr) {
        for(int lastUnsortedIndex = 0; lastUnsortedIndex < arr.length; lastUnsortedIndex++) {
            for (int i = arr.length-1; i > lastUnsortedIndex; i--) {
                if(arr[i] < arr[i-1]) {
                    swap(arr, i, i - 1);
                }
            }
        }
        return arr;
    }

    //growing sorted array on right
    public int[] sortDescending(int[] arr) {
        for(int lastUnsortedIndex = arr.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if(arr[i] < arr[i+1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
        return arr;
    }

    //growing sorted array on left
    public int[] sortDescendingLeft(int[] arr) {
        for(int lastUnsortedIndex = 0; lastUnsortedIndex < arr.length; lastUnsortedIndex++) {
            for (int i = arr.length-1; i > lastUnsortedIndex; i--) {
                if(arr[i] > arr[i-1]) {
                    swap(arr, i, i - 1);
                }
            }
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
