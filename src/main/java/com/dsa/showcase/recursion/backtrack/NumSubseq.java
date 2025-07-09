package com.dsa.showcase.recursion.backtrack;

import java.util.Arrays;
/*1498. Number of Subsequences That Satisfy the Given Sum Condition
        Attempted
Medium
        Topics
conpanies icon
Companies
        Hint
You are given an array of integers nums and an integer target.

Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.



Example 1:

Input: nums = [3,5,6,7], target = 9
Output: 4
Explanation: There are 4 subsequences that satisfy the condition.
[3] -> Min value + max value <= target (3 + 3 <= 9)
[3,5] -> (3 + 5 <= 9)
        [3,5,6] -> (3 + 6 <= 9)
        [3,6] -> (3 + 6 <= 9)
Example 2:

Input: nums = [3,3,6,8], target = 10
Output: 6
Explanation: There are 6 subsequences that satisfy the condition. (nums can have repeated numbers).
        [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
Example 3:

Input: nums = [2,3,3,4,6,7], target = 12
Output: 61
Explanation: There are 63 non-empty subsequences, two of them do not satisfy the condition ([6,7], [7]).
Number of valid subsequences (63 - 2 = 61).


Constraints:

        1 <= nums.length <= 105
        1 <= nums[i] <= 106
        1 <= target <= 106*/
public class NumSubseq {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        NumSubseq solution = new NumSubseq();
        int[] nums = {3, 5, 6, 7};
        int target = 9;
        int result = solution.numSubseq(nums, target);
        System.out.println("Number of valid subsequences: " + result); // Output: 4
    }

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        return backtrack(0, Integer.MAX_VALUE, Integer.MIN_VALUE, nums, false, target);
    }

    // Backtracking function to count valid subsequences
    //TLE
    //TODO: Optimize this solution using 2-pointer technique or binary search
    public int backtrack(int index, int min, int max, int[] nums, boolean hasPicked, int target) {
        if (index == nums.length) {
            if (hasPicked && (min + max <= target)) return 1;
            return 0;
        }

        int count = 0;

        // Exclude current element
        count += backtrack(index + 1, min, max, nums, hasPicked, target);

        // Include current element
        int newMin = hasPicked ? Math.min(min, nums[index]) : nums[index];
        int newMax = hasPicked ? Math.max(max, nums[index]) : nums[index];
        count += backtrack(index + 1, newMin, newMax, nums, true, target);

        return count % MOD;
    }
}
