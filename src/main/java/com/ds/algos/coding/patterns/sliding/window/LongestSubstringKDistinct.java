package com.ds.algos.coding.patterns.sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * Example String="araaci", K=2
 * Result - 4
 *
 */
public class LongestSubstringKDistinct {

    /**
     * Time complexity is O(N)*O(N)=O(N²)
     * Space complexity O(1)
     *
     * To optimize we could make use of the entries in the map instead of clearing and reiterating again using sliding window technique.
     * The char going out of the window can be removed. ex araaci
     *
      */
    public int findLengthBruteForce(String str, int k) {
        char[] originalChars = str.toCharArray();
        int N = originalChars.length;
        int longestSubstringCount = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        long start = System.currentTimeMillis();
        for(int i = 0; i <= N-k; i++) { //O(N) kis very small for large N
            charFrequencyMap.clear();
            for(int j = i; j < N;  j++) { //O(N) kis very small for large N
                if(!charFrequencyMap.containsKey(originalChars[j])){
                    charFrequencyMap.put(originalChars[j], charFrequencyMap.getOrDefault(originalChars[j], 0) +1);
                }
                if(charFrequencyMap.size() > k) {
                    longestSubstringCount = Math.max(longestSubstringCount, j - i);
                    break;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        return longestSubstringCount;
    }

    /**
     * Time complexity O(N)
     * Space Complextiy O(K)
     */
    public int findLengthSmallestWindow(String str, int k) {
        char[] originalChars = str.toCharArray();
        int N = originalChars.length;
        int longestSubstringCount = Integer.MIN_VALUE, windowStart=0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        long start = System.currentTimeMillis();
        for(int windowEnd=0; windowEnd < N; windowEnd++) { //Time Complexity O(N)
            charFrequencyMap.put(originalChars[windowEnd], charFrequencyMap.getOrDefault(originalChars[windowEnd], 0) + 1);
            while(charFrequencyMap.size() > k) {
                longestSubstringCount = Math.max(longestSubstringCount, windowEnd-windowStart);
                charFrequencyMap.put(originalChars[windowStart], charFrequencyMap.get(originalChars[windowStart]) - 1);
                if(charFrequencyMap.get(originalChars[windowStart]) == 0) {
                    charFrequencyMap.remove(originalChars[windowStart]);
                }
                windowStart++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        return longestSubstringCount;
    }

    public static int findLengthFromGrokking(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k)
            throw new IllegalArgumentException();
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        // in the following loop we'll try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringKDistinct instance = new LongestSubstringKDistinct();
        System.out.println("brute force long substring length is : " + instance.findLengthBruteForce("araaci", 1));
        System.out.println("sliding window long substring length is : " + instance.findLengthSmallestWindow("araaci", 1));
    }
}
