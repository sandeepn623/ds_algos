package com.ds.algos.hackerrank;

import java.util.*;

public class SalesByMatch {

    public static void main(String[] args) {
        System.out.println("solution1 total pairs: " + sockMerchant1(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));
        System.out.println("solution2 total pairs: " + sockMerchant2(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));
    }

    static int sockMerchant1(int n, int[] ar) {
        long start = System.currentTimeMillis();
        int pairs = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            if(!set.contains(ar[i])){
                set.add(ar[i]);
            } else {
                pairs++;
                set.remove(ar[i]);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("solution1 duration; " + (end-start));
        return pairs;
    }

    static int sockMerchant2(int n, int[] ar) {
        long start = System.currentTimeMillis();
        int pairs = 0;
        Map<Integer, Integer> socksCounterMap = new HashMap<>();
        for(int i=0; i<n; i++) {
            socksCounterMap.put(ar[i], socksCounterMap.getOrDefault(ar[i], 0)+1);
        }
        Iterator<Map.Entry<Integer, Integer>> itr = socksCounterMap.entrySet().iterator();
        while(itr.hasNext()) {
            pairs += itr.next().getValue().intValue()/2;
        }
        long end = System.currentTimeMillis();
        System.out.println("solution2 duration; " + (end-start));
        return pairs;
    }
}
