package com.dsa.showcase.year2025.string;

/*205. Isomorphic Strings
Solved
        Easy
Topics
conpanies icon
Companies
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



        Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "foo", t = "bar"

Output: false

Explanation:

The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:

Input: s = "paper", t = "title"

Output: true



Constraints:

        1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.*/
public class IsIsomorphic {
    public static void main(String[] args) {
        IsIsomorphic solution = new IsIsomorphic();
        String s = "egg";
        String t = "add";
        boolean result = solution.isIsomorphic(s, t);
        System.out.println("Are the strings isomorphic? " + result); // Expected output: true
    }

    public boolean isIsomorphic(String s, String t) {
        int s1[] = new int[256];
        int t1[] = new int[256];
        int i = 0;
        while (i < s.length()) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            // Check if the characters have been mapped before
            // If they have, they should map to the same index
            if (s1[a] != t1[b])
                return false;
            s1[a] = i + 1;
            t1[b] = i + 1;
            i++;

        }
        return true;
    }
}