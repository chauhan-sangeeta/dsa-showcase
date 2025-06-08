package com.dsa.array.sumproblem;

import java.util.Arrays;
/*259. 3Sum Smaller
Solved
        Medium
Topics
conpanies icon
Companies
Given an array of n integers nums and an integer target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.



Example 1:

Input: nums = [-2,0,1,3], target = 2
Output: 2
Explanation: Because there are two triplets which sums are less than 2:
        [-2,0,1]
        [-2,0,3]
Example 2:

Input: nums = [], target = 0
Output: 0
Example 3:

Input: nums = [0], target = 0
Output: 0


Constraints:

n == nums.length
0 <= n <= 3500
        -100 <= nums[i] <= 100
        -100 <= target <= 100*/
class ThreeSumSmallerSolution {
    public static void main(String[] args) {
        ThreeSumSmallerSolution solution = new ThreeSumSmallerSolution();
        int[] nums = {-2, 0, 1, 3};
        int target = 2;
        int result = solution.threeSumSmaller(nums, target);
        System.out.println(result); // Output: 2
    }
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {

            int j = i + 1, k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < target) {
                    count+=k-j;
                    j++;
                } else{
                    k--;
                }
            }
        }

        return count;   
    }
}