package com.ds.algos.coding.patterns.sliding.window;

/**
 * The problem statement is to find maximum sum of any contiguous sub array of size 'k'.
 * Example 1 - [2, 1, 5, 1, 3, 2], k=3
 * max sum - 9
 * Sub array with maximum sum is [5, 1, 3]
 *
 * Example 2 - [2, 3, 4, 1, 5], k=2
 * max sum - 7
 * Sub array with maximum sum is [4, 3]
 * The time complexity here is O(N * K)
 */
public class MaxSumSubArrayOfSizeK {

    public int findMaxSumSubArrayBruteForce(int K, int[] arr) {
        int maxSum = 0, N = arr.length;
        for(int i = 0; i <= N-K; i++) {
            int sum = 0;
            for(int j = i; j < i+K; j++) {
                sum+=arr[j];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    /**
     *The time complexity is improved using this approach to O(N)
     *Space complexity remains O(1) since both algorithms process the result in place.
     */
    public int findMaxSumSubArraySlidingWindow(int K, int[] arr) {
        int maxSum = 0, N = arr.length, windowSum = 0, windowStart = 0;
        for (int windowEnd = 0; windowEnd < N; windowEnd++) {
            windowSum+=arr[windowEnd];
            if(windowEnd >= K-1) {
                maxSum = Math.max(windowSum, maxSum);
                windowSum-=arr[windowStart++];
            }
        }
        return maxSum;
    }
}
