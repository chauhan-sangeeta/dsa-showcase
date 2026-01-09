package com.dsa.showcase.year2025.recursion.backtrack;
/*115. Distinct Subsequences
Attempted
        Hard
Topics
conpanies icon
Companies
Given two strings s and t, return the number of distinct subsequences of s which equals t.

The test cases are generated so that the answer fits on a 32-bit signed integer.



        Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
        rabbbit
rabbbit
Example 2:

Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from s.
babgbag
        babgbag
babgbag
        babgbag
babgbag


Constraints:

        1 <= s.length, t.length <= 1000
s and t consist of English letters.*/
public class DistinctSubsequences {
    public static void main(String[] args) {
        DistinctSubsequences solution = new DistinctSubsequences();
        String s = "rabbbit";
        String t = "rabbit";
        int result = solution.numDistinct(s, t);
        System.out.println("Number of distinct subsequences: " + result); // Output: 3
    }
    public int numDistinct(String s, String t) {
        return backtrackUsingExcludeInclude(0, new StringBuilder(), s,t); 
    }

    //TLE
    //TODO: Optimize this solution using memoization or dynamic programming
    public int backtrackUsingExcludeInclude(int first, StringBuilder sb,String s, String t) {
        int count=0;
        if(sb.toString().equals(t)){
            return 1;
        }
        if(first==s.length()){
            return 0;
        }
        count+=backtrackUsingExcludeInclude(first + 1, sb, s,t);
        sb.append(s.charAt(first));
        count+=backtrackUsingExcludeInclude(first + 1, sb, s,t);
        sb.deleteCharAt(sb.length() - 1);
        return count;
    }
}