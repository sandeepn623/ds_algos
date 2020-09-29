package com.ds.algos.coding.patterns.sliding.window;

/**
 * Given an array of positive numbers and a positive number ‘S’,
 * find the length of the smallest contiguous sub array whose sum is greater than or equal to ‘S’.
 * Return 0, if no such sub array exists.
 *
 * Example1: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 *
 * Example 2: [2, 1, 5, 2, 8], S=7
 * Output: 1
 *
 * Example 3: [3, 4, 1, 1, 6], S=8
 * Output: 3
 *
 */
public class MinSizeSubArraySum {
    /**
     * Space complexity is constant space O(1) as there are no additional memory allocations
     * Time complexity is O(N*K)
     */
    public int findMinSubArrayBruteForce(int S, int[] arr) {
        int minSize = Integer.MAX_VALUE, N = arr.length;
        for(int i=0; i < N; i++) {
            int sum = 0;
            for(int j = i; j < N; j++) {
                sum+=arr[j];
                if(sum >= S) {
                    minSize = Math.min(minSize, (j-i+1));
                    break;
                }
            }
        }
        return minSize==Integer.MAX_VALUE ? 0 : minSize;
    }

    /**
     * Space complexity is constant space O(1) as there are no additional memory allocations
     * Time complexity is O(N)
     * The outer for loop runs for all elements and the inner while loop processes each element only once,
     * therefore the time complexity of the algorithm will be O(N+N) which is asymptotically equivalent to O(N).
     */
    public int findMinSubArraySlidingWindow(int S, int[] arr) {
        int windowStart = 0, windowSum = 0, minSubArraySIze = Integer.MAX_VALUE, N = arr.length;
        for(int windowEnd = 0; windowEnd < N; windowEnd++) {
            windowSum+=arr[windowEnd];
            while(windowSum >= S) {
                minSubArraySIze = Math.min(minSubArraySIze, (windowEnd-windowStart+1));
                windowSum-=arr[windowStart++];
            }
        }
        return minSubArraySIze==Integer.MAX_VALUE ? 0 : minSubArraySIze;
    }
}
