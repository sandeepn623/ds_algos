package com.ds.algos.udemy.search;

public class BinarySearchIterative {

    //{-22,-15,1,7,20,35,55}
    public int binarySearch(int[] arr, int key) {
        int start=0, end=arr.length;
        while(start < end) {
            int mid = (start+end)/2;
            if(arr[mid] == key) {
                return mid;
            }
            else if(arr[mid] > key) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
}
