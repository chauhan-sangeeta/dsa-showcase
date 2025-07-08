package com.dsa.showcase.recursion.backtrack;

import java.util.ArrayList;
import java.util.List;

/*216. Combination Sum III
        Solved
Medium
        Topics
conpanies icon
Companies
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.



        Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
        1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
        1 + 2 + 6 = 9
        1 + 3 + 5 = 9
        2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
        Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.


        Constraints:

        2 <= k <= 9
        1 <= n <= 60*/
public class CombinationSum3 {
    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        int k = 3; // Example input for k
        int n = 7; // Example input for n
        List<List<Integer>> result = combinationSum3.combinationSum3(k, n);
        System.out.println(result); // Output: [[1,2,4]]

        // Example using exclude/include approach
        List<List<Integer>> resultUsingExcludeInclude = combinationSum3.combinationSum3UsingExcludeInclude(k, n);
        System.out.println(resultUsingExcludeInclude); // Output: [[1,2,4]]
    }

    private final List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<Integer> curr = new ArrayList<>();
        backtrack(1, curr, k, n);
        return output;

    }

    public void backtrack(int start, ArrayList<Integer> curr, int k, int target) {
        if (k == 0) {
            if (target == 0) output.add(new ArrayList<>(curr));
            return;
        }
        if (k < 0 || target < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            curr.add(i);
            backtrack(i + 1, curr, k - 1, target - i);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3UsingExcludeInclude(int k, int n) {
        ArrayList<Integer> curr = new ArrayList<>();
        backtrackUsingExcludeInclude(1, curr, k, n);
        return output;

    }

    public void backtrackUsingExcludeInclude(int start, ArrayList<Integer> curr, int k, int target) {
        if (k == 0) {
            if (target == 0)
                output.add(new ArrayList<>(curr));
            return;
        }
        if (k < 0 || target < 0) {
            return;
        }
        backtrack(start + 1, curr, k, target);
        curr.add(start);
        backtrack(start + 1, curr, k - 1, target - start);
        curr.remove(curr.size() - 1);
    }
}