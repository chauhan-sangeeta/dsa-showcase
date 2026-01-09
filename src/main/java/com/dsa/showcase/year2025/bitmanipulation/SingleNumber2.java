package com.dsa.showcase.year2025.bitmanipulation;

import java.util.Arrays;

/*137. Single Number II
        Solved
Medium
        Topics
conpanies icon
Companies
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99


Constraints:

        1 <= nums.length <= 3 * 104
        -231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.*/
public class SingleNumber2 {
    public static void main(String[] args) {
        SingleNumber2 singleNumber2 = new SingleNumber2();
        int[] nums = {2, 2, 3, 2};
        System.out.println("The single number is: " + singleNumber2.singleNumber(nums));

        int[] numsBitManipulation = {0, 1, 0, 1, 0, 1, 99};
        System.out.println("The single number using bit manipulation is: " + singleNumber2.singleNumberUsingBitManipulation(numsBitManipulation));

        int[] numsXor = {2, 2, 3, 2};
        System.out.println("The single number using XOR is: " + singleNumber2.singleNumberUsinXor(numsXor));
    }
    //time complexity: O(n log n)
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 3) {
            if (nums[i] != nums[i - 1])
                return nums[i - 1];
        }
        return nums[nums.length - 1];
    }
    //time complexity: O(32n) due to iterating through each bit position
    public int singleNumberUsingBitManipulation(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            int mask = 1 << i;
            for (int num : nums) {
                if ((num & mask) != 0) count++;
            }
            if (count % 3 == 1) {
                result |= mask;
            }
        }
        return result;
    }
    //time complexity: O(n)
    public int singleNumberUsinXor(int[] nums) {
        int ones=0;
        int twos=0;
        for(int num : nums){
            ones = (ones^num)&(~twos);
            twos = (twos^num)&(~ones);
        }
        return ones;
    }
}