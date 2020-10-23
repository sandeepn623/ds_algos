package com.ds.algos.udemy.sort;

public class CountingSort {

    //{2, 5, 9, 8 ,2, 8, 7, 10, 4, 3}
    public void countingSortAsc(int[] input, int min, int max) {
        int[] countingArray = new int[(max-min)+1];
        for (int k : input) {
            countingArray[k - min]++;
        }

        int j = 0;
        for(int i = min; i <= countingArray.length; i++) {
            while(countingArray[i-min] > 0) {
                input[j++] = i;
                countingArray[i-min]--;
            }
        }
    }

    public void countingSortDesc(int[] input, int min, int max) {
        int[] countingArray = new int[(max-min)+1];
        for (int k : input) {
            countingArray[k - min]++;
        }
        int j = max-1;
        for(int i = min; i <= countingArray.length; i++) {
            while(countingArray[i-min] > 0) {
                input[j--] = i;
                countingArray[i-min]--;
            }
        }
    }
}
