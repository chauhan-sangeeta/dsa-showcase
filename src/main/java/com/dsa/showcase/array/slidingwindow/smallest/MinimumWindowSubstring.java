package com.dsa.showcase.array.slidingwindow.smallest;

import java.util.HashMap;
import java.util.Map;

/*76. Minimum Window Substring
        Solved
Hard
        Topics
conpanies icon
Companies
        Hint
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.



        Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
        Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.


Follow up: Could you find an algorithm that runs in O(m + n) time?*/
class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String result = solution.minWindow(s, t);
        System.out.println("The minimum window substring is: " + result);
    }

    // To find the minimum window substring that contains all characters of t in s,
    // we can use a sliding window approach with two pointers and a hashmap to keep track of the characters in t.
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        // Create a map to count the characters in t
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> sMap = new HashMap<>();
        int start = 0;
        int min = Integer.MAX_VALUE;
        int validCount = 0;
        int startingInd = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If the character is in t, we add it to the sMap and check if it matches the count in tMap
            if (tMap.containsKey(c)) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                // If the count of the character in sMap matches the count in tMap, we increase the validCount
                if (tMap.get(c).intValue() == sMap.get(c).intValue()) {
                    validCount++;
                }
            }
            // If we have a valid window (all characters in t are present in sMap)
            while (validCount == tMap.size()) {
                if (min > i - start + 1) {
                    min = i - start + 1;
                    startingInd = start;
                }
                char rmChar = s.charAt(start);
                if (sMap.containsKey(rmChar)) {
                    // If the character to be removed is in tMap, we check if it matches the count in tMap
                    if (tMap.get(rmChar).intValue() == sMap.get(rmChar).intValue()) {
                        validCount--;
                    }
                    sMap.put(rmChar, sMap.get(rmChar) - 1);
                }
                start++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(startingInd, startingInd + min);

    }
}