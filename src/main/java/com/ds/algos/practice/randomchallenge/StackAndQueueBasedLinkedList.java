package com.ds.algos.practice.randomchallenge;

import com.ds.algos.udemy.list.DoublyLinkedList;
import com.ds.algos.udemy.queue.ArrayQueue;
import com.ds.algos.udemy.stack.LinkedListStack;

public class StackAndQueueBasedLinkedList {

    public static void main(String[] args) {
        StackAndQueueBasedLinkedList stackAndQueueBasedLinkedList = new StackAndQueueBasedLinkedList();

        System.out.println(stackAndQueueBasedLinkedList.isPalindrome("abccba"));

        System.out.println(stackAndQueueBasedLinkedList.isPalindrome("Was it a car or a cat I saw?"));

        System.out.println(stackAndQueueBasedLinkedList.isPalindrome("I did, did I"));

        System.out.println(stackAndQueueBasedLinkedList.isPalindrome("hello"));

        System.out.println(stackAndQueueBasedLinkedList.isPalindrome("Don't nod"));
    }

    private boolean isPalindrome(String input) {
        LinkedListStack<Character> stack = new LinkedListStack<>();
        ArrayQueue<Character> queue = new ArrayQueue<>();
        String toLowerCase = input.toLowerCase();
        StringBuilder noPunctuationsString = new StringBuilder();
        for(int i=0; i<toLowerCase.length(); i++) {
            char character = toLowerCase.charAt(i);
            if(character>='a' && character<='z') {
                noPunctuationsString.append(character);
                stack.push(character);
                queue.add(character);
            }
        }
        while(!stack.isEmpty()) {
            if(!stack.pop().equals(queue.remove())) return false;
        }

        return true;
    }
}
