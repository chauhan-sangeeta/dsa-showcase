package com.dsa.showcase.array.sumproblem;

import java.util.HashMap;
import java.util.Map;
/*1. Two Sum
Solved
        Easy
Topics
conpanies icon
Companies
        Hint
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



        Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

        2 <= nums.length <= 104
        -109 <= nums[i] <= 109
        -109 <= target <= 109
Only one valid answer exists.


        Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?*/
class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i]))
                return new int[]{map.get(target-nums[i]),i};
            map.put(nums[i],i);
         }
         return new int[]{};
    }
    // Two-pointer approach assumes the array is sorted
    public int twoSumUsingTwoPointers(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return nums[left] * nums[right];
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return -1; // Return -1 if no such pair exists
    }
}