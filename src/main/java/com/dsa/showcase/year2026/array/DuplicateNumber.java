package com.dsa.showcase.year2026.array;

/*287. Find the Duplicate Number
Solved
        Medium
Topics
premium lock icon
        Companies
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.



Example 1:

Input: nums = [1,3,4,2,2]
Output: 2*/
class DuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        DuplicateNumber solution = new DuplicateNumber();
        int result = solution.findDuplicate(nums);
        System.out.println("The duplicate number is: " + result);
    }

    public int findDuplicate(int[] nums) {
        // Using the negative marking technique to find the duplicate number
        for (int num : nums) {
            // Get the index corresponding to the value
            int ind = Math.abs(num);
            // If the value at that index is negative, it means we have seen this number before
            if (nums[ind] < 0)
                return ind;
            // Mark the value at that index as negative
            nums[ind] = -nums[ind];
        }
        return -1;
    }
}