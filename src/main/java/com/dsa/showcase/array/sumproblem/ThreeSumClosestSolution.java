package com.dsa.showcase.array.sumproblem;

import java.util.Arrays;
/*16. 3Sum Closest
Solved
        Medium
Topics
conpanies icon
Companies
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.



        Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).


Constraints:

        3 <= nums.length <= 500
        -1000 <= nums[i] <= 1000
        -104 <= target <= 104*/
class ThreeSumClosestSolution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = Integer.MAX_VALUE;

        for (int i = 0; i < n - 2; i++) {

            int j = i + 1, k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                // Update closest sum if this is closer to the target
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    // Exact match — best possible
                    return target;
                }
            }
        }

        return closestSum;
    }
}
