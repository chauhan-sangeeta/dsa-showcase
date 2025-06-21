package com.dsa.showcase.string;

/*242. Valid Anagram
Solved
        Easy
Topics
conpanies icon
Companies
Given two strings s and t, return true if t is an anagram of s, and false otherwise.



        Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false



Constraints:

        1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.


Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?*/
public class IsAnagram {
    public static void main(String[] args) {
        IsAnagram solution = new IsAnagram();
        String s = "anagram";
        String t = "nagaram";
        boolean result = solution.isAnagram(s, t);
        System.out.println("Are the strings anagrams? " + result); // Expected output: true
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] anagram = new int[26];
        for (char c : s.toCharArray()) {
            anagram[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (anagram[c - 'a'] == 0)
                return false;
            anagram[c - 'a']--;
        }
        return true;
    }
}
