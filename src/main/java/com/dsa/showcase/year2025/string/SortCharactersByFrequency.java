package com.dsa.showcase.year2025.string;

import java.util.*;

/*451. Sort Characters By Frequency
Solved
        Medium
Topics
conpanies icon
Companies
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.



        Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
        So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
        Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.


Constraints:

        1 <= s.length <= 5 * 105
s consists of uppercase and lowercase English letters and digits.*/
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        SortCharactersByFrequency solution = new SortCharactersByFrequency();
        String input = "tree";
        String result = solution.frequencySort(input);
        System.out.println("Sorted by frequency: " + result); // Expected output: "eetr" or "eert"
    }

    public String frequencySort(String s) {
        int n = s.length();
        int[] count = new int[256];
        // Count frequency of each character
        Map<Integer, List<Character>> map = new TreeMap<>(Collections.reverseOrder());
        // This map will store characters by their frequency in descending order
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                map.computeIfAbsent(count[i], k -> new ArrayList<>()).add((char) i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
            int freq = entry.getKey();
            for (char c : entry.getValue()) {
                sb.append(String.valueOf(c).repeat(freq));
            }
        }
        return sb.toString();
    }

    public String frequencySortUsingBucketSort(String s) {
        int n = s.length();
        int[] count = new int[256];
        List<Character>[] bucket = new List[n + 1];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (bucket[count[i]] == null) {
                    bucket[count[i]] = new ArrayList<>();
                }
                bucket[count[i]].add((char) i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int freq = n; freq > 0; freq--) {
            if (bucket[freq] != null) {
                for (char c : bucket[freq]) {
                    sb.append(String.valueOf(c).repeat(freq));
                }
            }
        }
        return sb.toString();
    }
}