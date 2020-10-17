package com.ds.algos.practice.randomchallenge.hashtables.challenge;

//Write a hash function so that all the values are in the nums array.
public class HashtableChallengeOne {

    public static void main(String[] args) {

        int[] numbers = new int[10];
        int[] numbersToAdd = { 59382, 43, 6894, 500, 99, -58 };
        for (int i = 0; i < numbersToAdd.length; i++) {
            numbers[hash(numbersToAdd[i])] = numbersToAdd[i];
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    public static int hash(int value) {
        int hashedKey = Math.abs(value % 10);
        return hashedKey;
    }
}
