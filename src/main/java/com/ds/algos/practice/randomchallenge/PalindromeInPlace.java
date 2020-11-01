package com.ds.algos.practice.randomchallenge;

public class PalindromeInPlace {

    public static void main(String[] args) {
        PalindromeInPlace palindromeInPlace = new PalindromeInPlace();

        System.out.println(palindromeInPlace.isPalindrome("abccba"));

        System.out.println(palindromeInPlace.isPalindrome("Was it a car or a cat I saw?"));

        System.out.println(palindromeInPlace.isPalindrome("I did, did I"));

        System.out.println(palindromeInPlace.isPalindrome("hello"));

        System.out.println(palindromeInPlace.isPalindrome("Don't nod"));
    }

    private boolean isPalindrome(String input) {
        String toLowerCase = input.toLowerCase();
        StringBuilder noPunctuationsStringBuilder = new StringBuilder();
        for (char character:toLowerCase.toCharArray()) {
            if(character>='a' && character<='z') {
                noPunctuationsStringBuilder.append(character);
            }
        }
        String noPunctuations = noPunctuationsStringBuilder.toString();
        char[] chars = noPunctuations.toCharArray();
        int mid = chars.length/2;

        for(int i=0,j=chars.length-1; i<mid && j > mid; i++,j--){
            if(chars[i] != chars[j]) return false;
        }
        return true;
    }
}
