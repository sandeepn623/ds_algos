package com.ds.algos.practice.randomchallenge;

import java.util.*;

public class MaximumSlidingWindow {

    public static void main(String[] args) {
        int[] windowSize = {3, 4, 5};
        long start = System.currentTimeMillis();
        for (int i = 0; i < windowSize.length; i++) {
            findMaxSlidingWindowSolutionOne(new int[] {1, 2, 3, 4, 3, 2, 1, 2, 5}, windowSize[i]);
        }
        long end = System.currentTimeMillis();
        System.out.println("total duration solution 1: " + (end-start) + "ms");
        start = System.currentTimeMillis();
        for (int i = 0; i < windowSize.length; i++) {
            findMaxSlidingWindowSolutionTwo(new int[] {1, 2, 3, 4, 3, 2, 1, 2, 5}, windowSize[i]);
        }
        end = System.currentTimeMillis();
        System.out.println("total duration solution 2: " + (end-start) + "ms");
    }

    public static ArrayDeque<Integer> findMaxSlidingWindowSolutionOne(int[] arr, int windowSize) {

        ArrayDeque<Integer> result = new ArrayDeque<>(); // ArrayDeque for storing values
        Deque<Integer> list = new LinkedList<Integer>(); // creating a linked list

        if(arr.length > 0) {
            if( arr.length < windowSize) // Invalid State
                return result;
            for(int i = 0; i < windowSize; ++i) {
                // Removing last smallest element index
                while(!list.isEmpty() && arr[i] >= arr[list.peekLast()]){
                    list.removeLast();
                }

                // Adding newly picked element index
                list.addLast(i);
            }

            for(int i = windowSize; i < arr.length; ++i) {
                result.add(arr[list.peek()]);

                // Removing all the elements indexes which are not in the current window
                while((!list.isEmpty()) && list.peek() <= i-windowSize)
                    list.removeFirst();

                // Removing the smaller elements indexes which are not required
                while((!list.isEmpty()) && arr[i] >= arr[list.peekLast()])
                    list.removeLast();

                // Adding newly picked element index
                list.addLast(i);
            }

            // Adding the max number of the current window in the result
            result.add(arr[list.peek()]);
            System.out.println("Max soln1: " + result);
            return result; // returning result

        }
        else
            return result;
    }

    public static ArrayDeque<Integer> findMaxSlidingWindowSolutionTwo(int[] arr, int windowSize) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        LinkedList<Integer> list = new LinkedList<>();

        int windowStart = 0;
        if(arr.length<windowSize) {
            return result;
        }
        for(int windowEnd=0; windowEnd<arr.length; windowEnd++) {
            while(!list.isEmpty() && arr[windowEnd] >= list.getLast()) {
                list.removeLast();
            }

            list.addLast(arr[windowEnd]);
            if(windowEnd+1 >= windowSize) {
                result.add(list.peek());
                if(list.peek() == arr[windowEnd+1-windowSize]) {
                    list.pop();
                }
            }
        }
        System.out.println("Max soln2: " + result);
        return result;
    }
}
