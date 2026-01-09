package com.dsa.showcase.year2025.recursion.backtrack;

/*132. Palindrome Partitioning II
        Attempted
Hard
        Topics
conpanies icon
Companies
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.



        Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
        Example 2:

Input: s = "a"
Output: 0
Example 3:

Input: s = "ab"
Output: 1


Constraints:

        1 <= s.length <= 2000
s consists of lowercase English letters only.*/
public class PalindromePartitioning2 {
    Boolean[][] dp;

    public static void main(String[] args) {
        PalindromePartitioning2 solution = new PalindromePartitioning2();
        String s = "aab";
        int minCuts = solution.minCut(s);
        System.out.println("Minimum cuts needed: " + minCuts); // Output: 1
    }

    //TODO: Optimize this solution using memoization or dynamic programming
    public int minCut(String s) {
        int n = s.length();
        dp = new Boolean[n][n];
        return backtrack(s, 0, s.length());
    }

    public int backtrack(String s, int start, int n) {
        if (start == n) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i < n; i++) {
            if (isPalindrome(s, start, i)) {
                min = Math.min(min, backtrack(s, i + 1, n) + 1);
            }
        }
        return min;
    }

    public boolean isPalindrome(String s, int i, int j) {
        if (dp[i][j] != null) return dp[i][j];
        int start = i, end = j;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                dp[i][j] = false;
                return false;
            }
            start++;
            end--;
        }
        dp[i][j] = true;
        return true;
    }
}