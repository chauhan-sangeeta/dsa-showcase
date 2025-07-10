package com.dsa.showcase.recursion.backtrack;

import java.util.ArrayList;
import java.util.List;

/*131. Palindrome Partitioning
Solved
        Medium
Topics
conpanies icon
Companies
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.



        Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]


Constraints:

        1 <= s.length <= 16
s contains only lowercase English letters.*/
public class PalindromePartitioning {
    List<List<String>> result = new ArrayList<>();
    Boolean[][] dp;

    public static void main(String[] args) {
        PalindromePartitioning solution = new PalindromePartitioning();
        String s = "aab";
        List<List<String>> partitions = solution.partition(s);
        System.out.println(partitions); // Output: [["a","a","b"],["aa","b"]]
    }

    public List<List<String>> partition(String s) {
        ArrayList<String> curr = new ArrayList<>();
        int n = s.length();
        dp = new Boolean[n][n];
        backtrack(s, 0, s.length(), curr);
        return result;
    }

    public void backtrack(String s, int start, int n, ArrayList<String> curr) {
        if (start == n) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < n; i++) {
            if (isPalindrome(s, start, i)) {
                curr.add(s.substring(start, i + 1));
                backtrack(s, i + 1, n, curr);
                curr.remove(curr.size() - 1);
            }
        }
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