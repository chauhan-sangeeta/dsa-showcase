package com.dsa.showcase.array.prefixSum;

import java.util.HashMap;
import java.util.Map;
/*
Largest subarray with 0 sum
Difficulty: MediumAccuracy: 41.84%Submissions: 411K+Points: 4Average Time: 20m
Given an array arr containing both positive and negative integers, the task is to compute the length of the largest subarray that has a sum of 0.

Examples:

Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
Output: 5
Explanation: The largest subarray with a sum of 0 is [-2, 2, -8, 1, 7].
Input: arr[] = [2, 10, 4]
Output: 0
Explanation: There is no subarray with a sum of 0.
Input: arr[] = [1, 0, -4, 3, 1, 0]
Output: 5
Explanation: The subarray is [0, -4, 3, 1, 0].
Constraints:
        1 ≤ arr.size() ≤ 106
        −103 ≤ arr[i] ≤ 103, for each valid i
*/
class MaximumSizeSubArraySumEquals0 {
    public static void main(String[] args) {
        MaximumSizeSubArraySumEquals0 solution = new MaximumSizeSubArraySumEquals0();
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int result = solution.maxLen(arr);
        System.out.println("The length of the largest subarray with sum 0 is: " + result);
    }
    //similar to longest subarray with sum k, we can use prefix sum and hashmap
    int maxLen(int arr[]) {
        int k=0;
        int sum = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLen = i + 1;
            }
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}