package com.dsa.showcase.year2025.recursion.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*40. Combination Sum II
        Solved
Medium
        Topics
conpanies icon
Companies
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.



Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
        [
        [1,1,6],
        [1,2,5],
        [1,7],
        [2,6]
        ]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
        [
        [1,2,2],
        [5]
        ]


Constraints:

        1 <= candidates.length <= 100
        1 <= candidates[i] <= 50
        1 <= target <= 30*/
public class CombinationSum2 {
    private final List<List<Integer>> output = new ArrayList<>();

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = combinationSum2.combinationSum2(candidates, target);
        System.out.println(result); // Output: [[1,1,6],[1,2,5],[1,7],[2,6]]

        // Example using include/exclude approach
        List<List<Integer>> resultUsingIncludeExclude = combinationSum2.combinationSum2UsingIncludeExclude(candidates, target);
        System.out.println(resultUsingIncludeExclude); // Output: [[1,1,6],[1,2,5],[1,7],[2,6]]
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
            if (i > start && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums, n, target - nums[i]);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<Integer> currCombo = new ArrayList<Integer>();
        Arrays.sort(candidates);
        backtrack(0, currCombo, candidates, candidates.length, target); // One call generates all subsets
        return output;
    }

    public void backtrackUsingIncludeExclude(int first, ArrayList<Integer> curr, int[] nums, int n, boolean prevIncluded, int target) {
        if (target == 0) {
            output.add(new ArrayList<>(curr));
            return;
        }
        if (first == n || target < 0) {
            return;
        }
        backtrackUsingIncludeExclude(first + 1, curr, nums, n, false, target);
        if (first == 0 || nums[first] != nums[first - 1] || prevIncluded) {
            curr.add(nums[first]);
            backtrackUsingIncludeExclude(first + 1, curr, nums, n, true, target - nums[first]);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2UsingIncludeExclude(int[] candidates, int target) {
        ArrayList<Integer> currCombo = new ArrayList<Integer>();
        Arrays.sort(candidates);
        backtrackUsingIncludeExclude(0, currCombo, candidates, candidates.length, false, target); // One call generates all subsets
        return output;
    }
}