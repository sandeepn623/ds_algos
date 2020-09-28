package com.ds.algos.coding.patterns.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

    /**
     * Given an array of characters where each character represents a fruit tree,
     * you are given two baskets and your goal is to put maximum number of fruits in each basket.
     * The only restriction is that each basket can have only one type of fruit.
     * You can start with any tree, but once you have started you can’t skip a tree.
     * You will pick one fruit from each tree until you cannot, i.e.,
     * you will stop when you have to pick from a third fruit type.
     * Write a function to return the maximum number of fruits in both the baskets.
     * Ex: Fruit = {'A', 'B', 'C', 'A', 'C'}
     * result = 3 {C, A, C}
     */
    public int findLength(char[] arr) {
        if(arr == null)
            throw new IllegalArgumentException();

        int windowStart = 0, maxLength = 0, k=2;
        Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char rightFruit = arr[windowEnd];
            fruitFrequencyMap.put(rightFruit, fruitFrequencyMap.getOrDefault(rightFruit, 0) + 1);
            while(fruitFrequencyMap.size() > k) {
                char leftFruit = arr[windowStart];
                fruitFrequencyMap.put(leftFruit, fruitFrequencyMap.get(leftFruit) - 1);
                if(fruitFrequencyMap.get(leftFruit) == 0) {
                    fruitFrequencyMap.remove(leftFruit);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, (windowEnd - windowStart + 1));
        }
        return maxLength;
    }
}
