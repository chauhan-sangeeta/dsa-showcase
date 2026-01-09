package com.dsa.showcase.year2025.string;
/*14. Longest Common Prefix
        Solved
Easy
        Topics
conpanies icon
Companies
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


        Constraints:

        1 <= strs.length <= 200
        0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.*/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String[] strs = {"flower", "flow", "flight"};
        String result = solution.longestCommonPrefix(strs);
        System.out.println("Longest common prefix: " + result); // Expected output: "fl"
    }

    //version 1: Using Vertical scanning
    //TODO Horizontal scanning, Divide and conquer, Binary search, Trie
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}