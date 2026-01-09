package com.dsa.showcase.year2025.bitmanipulation;
/*260. Single Number III
        Solved
Medium
        Topics
conpanies icon
Companies
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.



        Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.
        Example 2:

Input: nums = [-1,0]
Output: [-1,0]
Example 3:

Input: nums = [0,1]
Output: [1,0]


Constraints:

        2 <= nums.length <= 3 * 104
        -231 <= nums[i] <= 231 - 1
Each integer in nums will appear twice, only two integers will appear once.*/
public class SingleNumber3 {
    public static void main(String[] args) {
        SingleNumber3 singleNumber3 = new SingleNumber3();
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] result = singleNumber3.singleNumber(nums);
        System.out.println("The two single numbers are: " + result[0] + " and " + result[1]);
    }

    public int[] singleNumber(int[] nums) {
        int xorr = 0;
        for (int num : nums) {
            xorr ^= num;
        }
        int rightSetBit = (xorr & (xorr - 1)) ^ xorr;
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & rightSetBit) != 0) a ^= num;
            else b ^= num;
        }
        return new int[]{a, b};
    }
}