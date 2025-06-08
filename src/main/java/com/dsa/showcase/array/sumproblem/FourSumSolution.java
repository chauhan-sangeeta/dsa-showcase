package com.dsa.showcase.array.sumproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*18. 4Sum
        Solved
Medium
        Topics
conpanies icon
Companies
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

        0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.



        Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]


Constraints:

        1 <= nums.length <= 200
        -109 <= nums[i] <= 109
        -109 <= target <= 109*/
class FourSumSolution {
    public static void main(String[] args) {
        FourSumSolution solution = new FourSumSolution();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = solution.fourSum(nums, target);
        System.out.println(result); // Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
    for (int l = 0; l < n - 3; l++) {
        if (l > 0 && nums[l] == nums[l - 1]) continue;
        for (int i = l+1; i < n - 2; i++) {
            // Skip duplicate elements for the first element
            if (i > l + 1 && nums[i] == nums[i - 1]) continue;

            int j = i + 1, k = n - 1;

            while (j < k) {
                long sum = (long) nums[l] + nums[i] + nums[j] + nums[k];

                if (sum == target) {
                    result.add(Arrays.asList(nums[l],nums[i], nums[j], nums[k]));

                    // Move both pointers and skip duplicates
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;

                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
    }

        return result;
    }
}