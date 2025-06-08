package com.dsa.showcase.array.prefixSum;

import java.util.HashMap;
import java.util.Map;

/*560. Subarray Sum Equals K
Solved
        Medium
Topics
conpanies icon
Companies
        Hint
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.



        Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2


Constraints:

        1 <= nums.length <= 2 * 104
        -1000 <= nums[i] <= 1000
        -107 <= k <= 107*/
class CountSubArrayWithSumK {
    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        CountSubArrayWithSumK countSubArray = new CountSubArrayWithSumK();
        int result = countSubArray.subarraySumUsingSlidingWindow(nums, k);
        System.out.println("The number of subarrays that sum to " + k + " is: " + result);
    }

    //prefix sum
    // we can use a hashmap to store the prefix sum and its frequency
    //when we find a prefix sum that is equal to k, we can increment the count
    // when we find a prefix sum that is equal to currSum-k, we can increment the count
    // we can also use sliding window technique to find the number of subarrays that sum to k
    public int subarraySumUsingPrefixSumTechnique(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        int count = 0;
        // Initialize the map with 0 sum to handle the case where a subarray starts from index 0
        map.put(0, 1);
        for (int num : nums) {
            currSum += num;
            count += map.getOrDefault(currSum - k, 0);
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }

    // sliding window technique
    public int subarraySumUsingSlidingWindow(int[] nums, int goal) {
        return find(nums, goal) - find(nums, goal - 1);
    }

    public int find(int[] nums, int goal) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;
        while (r < nums.length) {
            sum += nums[r];
            // If the sum exceeds the goal, move the left pointer to reduce the sum
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
}