package com.ds.algos.udemy.sort;

public class ShellSort {

    public int[] sortAscending(int[] arr) {
        for(int gap =arr.length/2; gap > 0; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                int newElement = arr[i];
                int j;
                for(j = i; j >= gap && arr[j-gap] > newElement; j-=gap){
                    arr[j] = arr[j-gap];
                }
                arr[j] = newElement;
            }
        }
        return arr;
    }

    public int[] sortDescending(int[] arr) {
        for(int gap = arr.length; gap > 0; gap/=2) {
            for(int i = gap; i < arr.length; i++) {
                int newElement = arr[i];
                int j=i;
                while(j>=gap && arr[j-gap] < newElement) {
                    arr[j] = arr[j-gap];
                    j-=gap;
                }
                arr[j]=newElement;
            }
        }
        return arr;
    }
}

