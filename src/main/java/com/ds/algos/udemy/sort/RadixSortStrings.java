package com.ds.algos.udemy.sort;

public class RadixSortStrings {

    //{"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"}

    //1st pass cr[00000000000000000000000000] pos=4 r=26, input[]
    //2nd pass cr[00113444444444444000000000] pos=3 r=26, input[bbbbb, omadd, abcde, bcdef, dbaqc]
    //3rd pass cr[02340000000000000000000000] pos=2 r=26, input[omadd, dbaqc, bbbbb, abcde, bcdef]
    //4th pass cr[00344444444440000000000000] pos=1 r=26, input[dbaqc, bbbbb, abcde, bcdef, omadd]
    //5th pass cr[01334444444444400000000000] pos=0 r=26, temp[abcde, bbbbb, bcdef, dbaqc, omadd]
    public void radixSort(String[] input, int radix, int width) {

        for (int i = width-1; i >= 0 ; i--) {
            radixSingleSort(input, i, radix);
        }
    }

    private void radixSingleSort(String[] input, int position, int radix) {
        int length = input.length;
        int[] countArray = new int[radix];

        for (String string: input) {
            countArray[getIndex(string.toLowerCase(), position)]++;
        }
        //Adjust the countArray
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i-1];
        }

        String[] temp = new String[length];
        for(int tempIndex= length-1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getIndex(input[tempIndex], position)]] = input[tempIndex];
        }
        //System.arraycopy(temp, 0, input, 0, length);
    }

    private int getIndex(String string, int position) {
        return string.charAt(position)-'a';
    }
}