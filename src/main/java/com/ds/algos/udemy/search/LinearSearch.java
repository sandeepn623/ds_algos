package com.ds.algos.udemy.search;

public class LinearSearch {

    //[20, 35, -15, 7, 55, 1, -22]
    public int linearSearch(int[] arr, int searchKey) {

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == searchKey) {
                return i;
            }
        }
        return -1;
    }
}
