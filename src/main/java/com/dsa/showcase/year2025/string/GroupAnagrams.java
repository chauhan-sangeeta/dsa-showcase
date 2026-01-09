package com.dsa.showcase.year2025.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*49. Group Anagrams
Solved
        Medium
Topics
conpanies icon
Companies
Given an array of strings strs, group the anagrams together. You can return the answer in any order.



        Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
        Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]



Constraints:

        1 <= strs.length <= 104
        0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.*/
public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println("Grouped Anagrams: " + result); // Expected output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String key = buildKey(s); // O(k)
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s); // cleaner
        }

        return new ArrayList<>(map.values());
    }

    private String buildKey(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Use a delimiter to avoid ambiguity (e.g. [1, 11] vs [11, 1])
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(count[i]).append('#'); // delimiter
        }

        return sb.toString();
    }
}
