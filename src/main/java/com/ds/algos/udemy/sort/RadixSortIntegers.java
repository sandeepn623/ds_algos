package com.ds.algos.udemy.sort;

public class RadixSortIntegers {

    //[4725, 4586, 1330, 8792, 1594, 5729]
    public void radixSort(int[] input, int radix, int width) {
        for(int i=0; i<width; i++) {
            radixSingleSort(input, i, radix);
        }
    }

    private void radixSingleSort(int[] input, int position, int radix) {
        int length = input.length;
        int[] countArray = new int[radix];

        for(int value : input) {
            countArray[getDigit(value, position, radix)]++;
        }
        //Adjust the counting array
        for(int i=1; i<countArray.length; i++) {
            countArray[i] += countArray[i-1];
        }
        int[] temp = new int[length];
        for (int tempIndex = length-1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(input[tempIndex], position, radix)]] = input[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < length; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
        //System.arraycopy(temp, 0, input, 0, length);
    }

    private int getDigit(int value, int position, int radix) {
        return value/(int) Math.pow(radix, position) % radix;
    }
}
