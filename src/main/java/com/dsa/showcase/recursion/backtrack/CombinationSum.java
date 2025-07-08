package com.dsa.showcase.recursion.backtrack;

import java.util.ArrayList;
import java.util.List;

/*39. Combination Sum
Solved
        Medium
Topics
conpanies icon
Companies
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



        Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
        2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []


Constraints:

        1 <= candidates.length <= 30
        2 <= candidates[i] <= 40
All elements of candidates are distinct.
        1 <= target <= 40*/
public class CombinationSum {
    private final List<List<Integer>> output = new ArrayList<>();

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);
        System.out.println(result); // Output: [[2,2,3],[7]]

        // Example using include/exclude approach
        List<List<Integer>> resultUsingIncludeExclude = combinationSum.combinationSumUsingExcludeInclude(candidates, target);
        System.out.println(resultUsingIncludeExclude); // Output: [[2,2,3],[7]]
    }

    public void backtrack(int start, ArrayList<Integer> curr, int[] nums, int n, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            output.add(new ArrayList<>(curr));
            return;
        }
        // Add the current subset to the output
        // Generate subsets starting from the current index
        for (int i = start; i < n; ++i) {
            curr.add(nums[i]);
            backtrack(i, curr, nums, n, target - nums[i]);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> currCombo = new ArrayList<Integer>();
        backtrack(0, currCombo, candidates, candidates.length, target); // One call generates all subsets
        return output;
    }

    public void backtrackUsingExcludeInclude(int first, ArrayList<Integer> curr, int[] nums,int n,int target) {
        if(target==0){
            output.add(new ArrayList<>(curr));
            return ;
        }
        if(first==n || target<0){
            return ;
        }
        backtrackUsingExcludeInclude(first + 1, curr, nums,n,target);
        curr.add(nums[first]);
        backtrackUsingExcludeInclude(first, curr, nums,n,target-nums[first]); //include current element
        curr.remove(curr.size() - 1);
    }

    public List<List<Integer>> combinationSumUsingExcludeInclude(int[] candidates, int target) {
        ArrayList<Integer> currCombo = new ArrayList<Integer>();
        backtrackUsingExcludeInclude(0,currCombo, candidates,candidates.length,target); // One call generates all subsets
        return output;
    }
}