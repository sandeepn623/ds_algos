package com.ds.algos.udemy.sort;

import java.util.*;

public class BucketSort {

    public void bucketSort(int[] input, int radix, int position) {
        // could be arraylist or linked list. Both are mutually replaceable

        List<Integer>[] buckets = new List[10];

        for (int i = 0; i < buckets.length; i++) {
            //ArrayList
            //buckets[i] = new ArrayList<>();
            //LinkedList
            buckets[i] = new LinkedList<>();
        }
        // scattering phase
        for (int i : input) {
            int index = hashedKey(i, radix, position);
            buckets[index].add(i);
        }

        // Alternatively can make use of Insertion sort.
        for (List<Integer> bucket: buckets) {
            Collections.sort(bucket);
        }

        // gathering or grouping the sorted values in the original array
        int i = 0;
        for (List<Integer> bucket: buckets) {
            for (int sortedValue: bucket) {
                input[i++] = sortedValue;
            }
        }
    }

    // The hash function should generate hash values such that values in bucket 0 is less than values in bucket1
    //Ex: 43, 46 should go to bucket 0 and 54 should end up in any bucket after bucket 0 and so on.
    private int hashedKey(int value, int radix, int position){
        return value/(int) Math.pow(radix, position);
    }
}
