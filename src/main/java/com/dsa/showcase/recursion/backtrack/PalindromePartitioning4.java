package com.dsa.showcase.recursion.backtrack;
/*1745. Palindrome Partitioning IV
        Attempted
Hard
        Topics
conpanies icon
Companies
        Hint
Given a string s, return true if it is possible to split the string s into three non-empty palindromic substrings. Otherwise, return false.​​​​​

A string is said to be palindrome if it the same string when reversed.



Example 1:

Input: s = "abcbdd"
Output: true
Explanation: "abcbdd" = "a" + "bcb" + "dd", and all three substrings are palindromes.
Example 2:

Input: s = "bcbddxy"
Output: false
Explanation: s cannot be split into 3 palindromes.


        Constraints:

        3 <= s.length <= 2000
s​​​​​​ consists only of lowercase English letters.*/
public class PalindromePartitioning4 {

    Boolean[][] dp;

    public static void main(String[] args) {
        PalindromePartitioning4 solution = new PalindromePartitioning4();
        String s = "abccba";
        boolean result = solution.checkPartitioning(s);
        System.out.println(result); // Output: true
    }

    //TODO: Optimize this solution using memoization or dynamic programming
    public boolean checkPartitioning(String s) {
        if (s.length() < 3) return false;
        int n = s.length();
        dp = new Boolean[n][n];
        return backtrack(s, 0, s.length(), 0);
    }

    public boolean backtrack(String s, int start, int n, int count) {
        if (count == 3) {
            return start == n;
        }
        for (int i = start; i < n; i++) {
            if (isPalindrome(s, start, i)) {
                if (backtrack(s, i + 1, n, count + 1)) return true;
            }
        }
        return false;
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