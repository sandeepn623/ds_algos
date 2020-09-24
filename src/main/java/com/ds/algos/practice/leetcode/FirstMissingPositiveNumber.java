package com.ds.algos.practice.leetcode;

/*
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:
Input: [1,2,0]
Output: 3

Example 2:
Input: [3,4,-1,1]
Output: 2

Example 3:
Input: [7,8,9,11,12]
Output: 1

Follow up:
Your algorithm should run in O(n) time and uses constant extra space.

Solution:
This problem can be approached by iterating over the array and subtracting the number by 1.
let's consider the example 1. So by iterating and subtracting the array contents by 1, we should have
[0, 1, -1]
Now use this result after subtracting at each step as index of the array. considering same example 1
we have 0 representing 0th index, 1 representing 1st index and since the last is -1 lets ignore it.
Now we check if the value at the respective index is equal to the value at index-1 and not negative,
if they are equal it means we have nothing to do, in case the the value does not match the given index
we swap the contents until the value at given index is at the right index.
If the value at given index is negative or out of range of the given array then we simply ignore and continue.

Lets go through an example
in the example 1:
[1, 2, 0]
 0  1  2
so during the iteration the above array becomes
[0, 2, 0] 1st iteration subtract value at index 0 by 1
 0  1  2  no need to swap as they value and index are equal
[0, 1, 0] 2d iteration subtract value at index 1 by 1
 0  1  2  no need to swap as they value and index are equal
[0, 1,-1] 3rd iteration subtract value at index 2 by 1
 0  1  2  no need to swap as they value is negative
To demonstrate swapping lets consider the example 2
[3, 4, -1, 1]
 0  1   2  3

[2, 4, -1, 1] 1st iteration subtract value at index 0 by 1
 0  1   2  3  the value is not equal to the index but the right position would be index 2
[-1 4   3  1] now again checking the value at index 0, since it is negative we ignore and continue.
 0  1   2  3
[-1, 3, 3, 1] 2nd iteration subtract value at index 1 by 1.
 0   1  2  3  since the value is not equal to index swap it to right index 3
[-1, 1, 3, 4] now the swapped value is equal to the index so we continue.
  0  1  2  3  In some cases it maybe the case where swapped value is not equal to the index, in which case we continue until the values are put in the right index.
[-1, 1, 2, 4] 3rd iteration subtract value at index 2 by 1.
  0  1  2  3  As the index and the value are equal we continue.
[-1, 1, 2, 3] 4th iteration subtract value at index 3 by 1.
  0  1  2  3  As the index and the value are equal we stop as we reached the end of the array.
The in place swap can be considered constant time as there can be fewer iteration compared to iterating the whole array
and the traversing the whole array of length N the time complexity is O(N).
As a final step iterate over this sorted array and return the first index whose value does not match. In the above examples. Time complexity is O(N)
example 1 it is 3
example 2 it is 1.
so overall time complexity is O(N) + O(N) = O(2N) = O(N)
Space complexity is constant space as the algo operates on the same array in place which is O(1).
*/

public class FirstMissingPositiveNumber {
    public int firstMissingPositive(int[] nums) {

        int N = nums.length;

        for(int i = 0; i < N; i++){
            int correctIndex = nums[i] - 1;
            while(1 <= nums[i] && nums[i] < N && nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
                correctIndex = nums[i] - 1;
            }
        }

        for(int j = 0; j < N; j++){
            if(j+1 != nums[j]) {
                return j+1;
            }
        }
        return N+1;
    }
}
