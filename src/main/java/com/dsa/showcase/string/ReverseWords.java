package com.dsa.showcase.string;
/*151. Reverse Words in a String
        Solved
Medium
        Topics
conpanies icon
Companies
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.



Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


        Constraints:

        1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.


Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?*/
public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords solution = new ReverseWords();
        String input = "the sky is blue";
        String result = solution.reverseWords(input);
        System.out.println("Result: " + result); // Expected output: "blue is sky the"
    }
    public String reverseWords(String s) {
        int n = s.length();
        int i = n - 1;
        StringBuilder sb = new StringBuilder();
        String ans = "";
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
                continue;
            }
            if (i < 0) break;
            int j = i - 1;
            while (j >= 0 && s.charAt(j) != ' ') j--;
            sb.append(" ");
            sb.append(s,j + 1, i + 1);
            i = j - 1;

        }
        if (!sb.isEmpty()) sb.deleteCharAt(0);
        return sb.toString();
    }
}