package com.ds.algos.practice.randomchallenge;

import com.ds.algos.udemy.stack.LinkedListStack;

import java.util.Arrays;

public class StackBasedPalindromeTest {

    public static void main(String[] args) {
        StackBasedPalindromeTest stackBasedPalindromeTest = new StackBasedPalindromeTest();

        System.out.println(stackBasedPalindromeTest.isPalindrome("abccba"));

        System.out.println(stackBasedPalindromeTest.isPalindrome("Was it a car or a cat I saw?"));

        System.out.println(stackBasedPalindromeTest.isPalindrome("I did, did I"));

        System.out.println(stackBasedPalindromeTest.isPalindrome("hello"));

        System.out.println(stackBasedPalindromeTest.isPalindrome("Don't nod"));
    }

    private boolean isPalindrome(String input) {
        String lowercase = input.toLowerCase();
        LinkedListStack<Character> stack = new LinkedListStack<>();
        StringBuilder stringNoPunctuation = new StringBuilder(lowercase.length());
        for (int i=0; i < lowercase.length(); i++) {
            char c = lowercase.charAt(i);
            if(c >='a' && c <= 'z') {
                stringNoPunctuation.append(c);
                stack.push(c);
            }
        }

        StringBuilder reverseString = new StringBuilder();
        while (!stack.isEmpty()){
            Character popItem = (Character) stack.pop();
            reverseString.append(popItem);
        }
        return stringNoPunctuation.toString().equals(reverseString.toString());
    }
}
