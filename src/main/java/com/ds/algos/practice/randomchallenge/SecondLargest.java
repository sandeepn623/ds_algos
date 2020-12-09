package com.ds.algos.practice.randomchallenge;

/**
 * First round Goldmansachs
 */
public class SecondLargest {

    public static void main(String[] args) {
        int[] a ={0};
        int[] b ={0,1};
        int[] c ={0,1,1,0};
        int[] d ={4,3,2,1};
        int[] e ={1,2,3,4};
        int[] f ={1,1,2,2,3,3,4,4};
        int[] g ={13,12,8,11,10,33,23,42};
        System.out.println(getSecondSmallestNumber(d));
    }

    private static int getSecondSmallestNumber(int[] x) {
        int smallest, secondSmallest = x.length;
        if(x.length<2){
            return 0;
        }

        smallest = secondSmallest = Integer.MAX_VALUE;
        for (int i = 0; i < x.length; i++) {
            if(x[i]<smallest) {
                secondSmallest=smallest;
                smallest = x[i];
            }

            if(x[i]!=smallest && x[i]<secondSmallest){
                secondSmallest = x[i];
            }
        }
        return secondSmallest;
    }
}
