package com.dsa.showcase.recursion.backtrack;

import java.util.ArrayList;
import java.util.List;
/*78. Subsets
        Solved
Medium
        Topics
conpanies icon
Companies
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

        1 <= nums.length <= 10
        -10 <= nums[i] <= 10
All the numbers of nums are unique.*/
public class Subsets {

    private final List<List<Integer>> output = new ArrayList<>();
    private int n;

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets.subsets(nums);
        System.out.println(result); // Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    }

    // Time complexity: O(2^n), where n is the length of the input array nums.
    // exclude/include approach
    public void backtrackUsingExcludeInclude(int first, ArrayList<Integer> curr, int[] nums) {
        if(first==n){
            output.add(new ArrayList<>(curr));
            return;
        }
        backtrackUsingExcludeInclude(first + 1, curr, nums);
        curr.add(nums[first]);
        backtrackUsingExcludeInclude(first + 1, curr, nums);
        curr.remove(curr.size() - 1);
    }

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // Add the current subset to the output
        output.add(new ArrayList<>(curr));
        // Generate subsets starting from the current index
        for (int i = first; i < n; ++i) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        ArrayList<Integer> currCombo = new ArrayList<Integer>();
        backtrack(0, currCombo, nums); // One call generates all subsets
        return output;
    }
}