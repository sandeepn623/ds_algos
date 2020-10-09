package com.ds.algos.udemy.sort.recursive;

import java.util.Arrays;

public class RecursiveInsertionSort {

    //{20,35,-15,7,55,1,-22}
    public void insertionSort(int[] arr, int numberItems) {
        if(numberItems<2) {
            return;
        }

        insertionSort(arr, numberItems-1);
        int currentValue = arr[numberItems-1];
        int j;
        for(j=numberItems-1; j > 0 && arr[j-1] > currentValue; j--) {
            arr[j] = arr[j-1];
        }
        arr[j] = currentValue;

        System.out.println("recursive sorted array for numberItems: " + numberItems);
        System.out.print("{ ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i != arr.length-1)
                System.out.print(", ");
            else
                System.out.println("}");
        }
        System.out.println("------------------------------");

        String s = "abcdef";
        char[] chars = s.toCharArray();
        System.out.println(Arrays.toString(chars));
        System.out.println(chars[0]);
    }
}
