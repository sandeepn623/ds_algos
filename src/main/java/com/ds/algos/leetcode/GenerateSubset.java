package com.ds.algos.leetcode;

import java.util.ArrayList;
import java.util.List;

/** For a given input array generate all possible non repeating sub-array (the power set)
 * eg input : [1,2,3]
 * output : [3]
 *          [2]
 *          [1]
 *          [1, 2, 3]
 *          [1, 2]
 *          [2, 3]
 *          [1, 3]
 *          []
 */



public class GenerateSubset {

    public static void main(String[] args) {
        System.out.println(subsets(new int[] {1,2,3}));
    }

    public static List<List<Integer>> subsets(int[] numbers) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(0, numbers, new ArrayList<Integer>(), subsets);
        return subsets;
    }

    /**
     * [] i = 0; index = 0
     * [1] i=1 index = 1
     * [1, 2] i=2 index=2
     * [1, 2, 3] i=3 index=3
     * [1, 3] i=2 index = 3
     * [2] i=1 index = 2
     * [2, 3] i=2 index = 3
     *,[3]
     */
    private static void generateSubsets(int index, int[] numbers, ArrayList<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));
        for(int i=index; i<numbers.length; i++) {
            current.add(numbers[i]);
            generateSubsets(i+1, numbers, current, subsets);
            current.remove(current.size()-1);
        }
    }
}
