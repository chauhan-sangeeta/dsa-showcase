package com.dsa.showcase.recursion.backtrack;

import java.util.ArrayList;

/*377. Combination Sum IV
        Attempted
Medium
        Topics
conpanies icon
Companies
Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.



Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
        (1, 1, 1, 1)
        (1, 1, 2)
        (1, 2, 1)
        (1, 3)
        (2, 1, 1)
        (2, 2)
        (3, 1)
Note that different sequences are counted as different combinations.
        Example 2:

Input: nums = [9], target = 3
Output: 0


Constraints:

        1 <= nums.length <= 200
        1 <= nums[i] <= 1000
All the elements of nums are unique.
1 <= target <= 1000


Follow up: What if negative numbers are allowed in the given array? How does it change the problem? What limitation we need to add to the question to allow negative numbers?*/
public class CombinationSum4 {
    public static void main(String[] args) {
        CombinationSum4 combinationSum4 = new CombinationSum4();
        int[] nums = {1, 2, 3};
        int target = 4;
        int result = combinationSum4.combinationSum4(nums, target);
        System.out.println(result); // Output: 7
    }
    public int combinationSum4(int[] nums, int target) {
        ArrayList<Integer> curr = new ArrayList<Integer>();
        return backtrack(curr, nums, nums.length, target);
    }
    //TLE
    //TODO: Memoization and Dynamic Programming can be used to optimize this solution.
    public int backtrack(ArrayList<Integer> curr, int[] nums, int n, int target) {
        int count=0;
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        // Add the current subset to the output
        // Generate subsets starting from the current index
        for (int i = 0; i < n; ++i) {
            curr.add(nums[i]);
            count+=backtrack(curr, nums, n, target - nums[i]);
            curr.remove(curr.size() - 1);
        }
        return count;
    }
}