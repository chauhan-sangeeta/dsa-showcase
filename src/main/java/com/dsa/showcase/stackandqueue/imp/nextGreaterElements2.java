package com.dsa.showcase.stackandqueue.imp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
/*503. Next Greater Element II
Solved
        Medium
Topics
conpanies icon
Companies
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.



Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number.
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]


Constraints:

        1 <= nums.length <= 104
        -109 <= nums[i] <= 109*/
public class nextGreaterElements2 {
    public static void main(String[] args) {
        nextGreaterElements2 nge = new nextGreaterElements2();
        int[] nums = {1, 2, 1};
        int[] result = nge.nextGreaterElements(nums);
        System.out.println("Next Greater Elements: " + Arrays.toString(result));

        // Using single loop
        int[] resultSingleLoop = nge.nextGreaterElementsUsingSingleLoop(nums);
        System.out.println("Next Greater Elements (Single Loop): " + Arrays.toString(resultSingleLoop));
    }
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Deque<Integer> st = new ArrayDeque<>();
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                ans[st.pop()] = nums[i];
            }
            st.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                ans[st.pop()] = nums[i];
            }
        }
        return ans;
    }

    public int[] nextGreaterElementsUsingSingleLoop(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        Arrays.fill(ans, -1);
        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                ans[st.pop()] = nums[i % n];
            }
            if (i < n) {
                st.push(i);
            }
        }
        return ans;
    }
}