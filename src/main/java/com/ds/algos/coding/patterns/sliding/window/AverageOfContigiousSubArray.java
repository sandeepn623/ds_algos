package com.ds.algos.coding.patterns.sliding.window;

import java.util.Arrays;

public class AverageOfContigiousSubArray {

    /*
        The solution below though provides correct result is highly inefficient.
        The time complexity O(N * K) since this algorithm computes sum for all the input N wiht sub array Size of K.
        The inefficiency is also due to sum being computed again and again. For instance in the below Example
        [1, 3, 2, 6, -1, 4, 1, 8, 2] and K = 5
        on the 1st iteration the sum of 1st sub array of length 5 [1, 3, 2, 6, -1] is calculated
        and again in the 2nd iteration the sum of 2nd sub array [3, 2, 6, -1, 4] is recomputed
        though the array values from index 1 to 4 was already computed in the 1st pass. We could make this algorithm efficient
        by reusing the calculated sum which is shown in 2nd approach.
    */
    public double[] findAvgBruteForce(int K, int[] arr) {
        int N = arr.length;
        double[] avg = new double[N-K+1];
        for(int i = 0; i < N-K+1; i++) {
            double sum = 0;
            for(int j = i; j < i+K; j++) {
                sum += arr[j];
            }
            avg[i] = sum/K;
        }
        return avg;
    }

    /*
        By reusing the sum computed in the previous iteration using sliding window pattern,
        the alorithm becomes more efficient.
        The time complexity is now O(N) which is btter than O(N * K) from previous brute force approach.
     */
    public double[] findAvgSlidingWindow(int K, int[] arr){
        int N = arr.length;
        double[] avg = new double[N-K+1];
        double sum = 0;
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < N; windowEnd++) {
            sum += arr[windowEnd];
            if(windowEnd >= K-1) {
                avg[windowStart] = sum / K;
                sum -= arr[windowStart++];
            }
        }
        return avg;
    }
}
