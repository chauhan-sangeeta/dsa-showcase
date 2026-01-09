package com.dsa.showcase.year2025.array.prefixSum;

import java.util.HashMap;
import java.util.Map;
/*523. Continuous Subarray Sum
        Solved
Medium
        Topics
conpanies icon
Companies
Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

A good subarray is a subarray where:

its length is at least two, and
the sum of the elements of the subarray is a multiple of k.
Note that:

A subarray is a contiguous part of the array.
An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.


Example 1:

Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
Example 2:

Input: nums = [23,2,6,4,7], k = 6
Output: true
Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
        42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
        Example 3:

Input: nums = [23,2,6,4,7], k = 13
Output: false


Constraints:

        1 <= nums.length <= 105
        0 <= nums[i] <= 109
        0 <= sum(nums[i]) <= 231 - 1
        1 <= k <= 231 - 1*/

public class CheckSubarraySum {
    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        CheckSubarraySum checkSubarraySum = new CheckSubarraySum();
        boolean result = checkSubarraySum.checkSubarraySum(nums, k);
        System.out.println("Does the array have a good subarray? " + result);
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);// Initialize with 0 sum at index -1 to handle cases where the subarray starts from index 0
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % k;
            if (map.containsKey(sum)) {// Check if this sum has been seen before
                if (i - map.get(sum) >= 2) return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}