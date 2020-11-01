package com.ds.algos.practice.randomchallenge;

import java.lang.annotation.ElementType;
import java.util.*;

public class FindRandomCharacter {

    public static void main(String[] args) {
        System.out.println(findFirstUniqueCharacter("iiii"));
    }

    static char findFirstUniqueCharacter(String s) {
        Map<Character, Integer> counter = new LinkedHashMap<>();
        for(int i=0; i<s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) +1);
        }

        Iterator<Map.Entry<Character, Integer>> itr = counter.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Character, Integer> entry = itr.next();
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '0';
    }
}
