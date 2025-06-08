package com.dsa.array.prefixSum;

import java.util.HashMap;
import java.util.Map;
/*
525. Contiguous Array
Solved
        Medium
Topics
conpanies icon
Companies
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.



Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Example 3:

Input: nums = [0,1,1,1,1,1,0,0,0]
Output: 6
Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.


Constraints:

        1 <= nums.length <= 105
nums[i] is either 0 or 1.*/
class FindMaxLengthForZeroAndOne {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 1, 1, 0, 0, 0};
        FindMaxLengthForZeroAndOne solution = new FindMaxLengthForZeroAndOne();
        int result = solution.findMaxLength(nums);
        System.out.println("The maximum length of a contiguous subarray with equal number of 0 and 1 is: " + result);
    }
    // To find the maximum length of a contiguous subarray with equal number of 0 and 1,
    // we can use the prefix sum technique.
    // We can treat 0 as -1 and 1 as 1, then we can find the maximum length of a subarray that sums to 0.
    public int findMaxLength(int[] nums) {
        int k=0;
        int sum = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                sum+=-1;
            }else{
                sum += nums[i];
            }

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