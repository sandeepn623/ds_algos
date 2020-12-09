package com.ds.algos.udemy.search;

public class BinarySearchRecursive {

    //{-22,-15,1,7,20,35,55}
    public int binarySearch(int[] arr, int key) {
        return binarySearch(arr, key, 0, arr.length);
    }

    private int binarySearch(int[] arr, int key, int start, int end) {
        if(start >= end) return -1;
        int mid = (start+end)/2;
        if(arr[mid] == key) {
            return mid;
        }
        else if(arr[mid] > key) {
            end = mid;
        } else {
            start = mid+1;
        }
        return binarySearch(arr, key, start, end);
    }
}
