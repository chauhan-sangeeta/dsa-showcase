package com.dsa.showcase.year2025.recursion.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*90. Subsets II
Solved
        Medium
Topics
conpanies icon
Companies
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

        1 <= nums.length <= 10
        -10 <= nums[i] <= 10*/
public class SubsetsWithDup {
    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = subsetsWithDup.subsetsWithDup(nums);
        System.out.println(result); // Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
    }
    private final List<List<Integer>> output = new ArrayList<>();
    //include exclude
    public void backtrackUsingIncludeExclude(int first, ArrayList<Integer> curr, int[] nums,int n,boolean prevIncluded) {
            if(first==n){ 
                output.add(new ArrayList<>(curr));
                return;
            }
            backtrackUsingIncludeExclude(first + 1, curr, nums,n,false);
            if(first==0 || nums[first]!=nums[first-1]||prevIncluded){
                curr.add(nums[first]);
                backtrackUsingIncludeExclude(first + 1, curr, nums,n,true);
                curr.remove(curr.size() - 1);
            }
    }
    public void backtrack(int first, ArrayList<Integer> curr, int[] nums,int n) {
        // Add the current subset to the output
        output.add(new ArrayList<>(curr));
        // Generate subsets starting from the current index
        for (int i = first; i < n; ++i) {
            if(i>first && nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums,n);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<Integer> currCombo = new ArrayList<Integer>();
        Arrays.sort(nums);
        backtrackUsingIncludeExclude(0, currCombo, nums,nums.length,false); // One call generates all subsets
        return output;
    }
}