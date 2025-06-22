package com.dsa.showcase.string;

/*1614. Maximum Nesting Depth of the Parentheses
Solved
        Easy
Topics
conpanies icon
Companies
        Hint
Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.



Example 1:

Input: s = "(1+(2*3)+((8)/4))+1"

Output: 3

Explanation:

Digit 8 is inside of 3 nested parentheses in the string.

        Example 2:

Input: s = "(1)+((2))+(((3)))"

Output: 3

Explanation:

Digit 3 is inside of 3 nested parentheses in the string.

        Example 3:

Input: s = "()(())((()()))"

Output: 3



Constraints:

        1 <= s.length <= 100
s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
It is guaranteed that parentheses expression s is a VPS.*/
public class MaxParenthesesDepth {
    public static void main(String[] args) {
        MaxParenthesesDepth solution = new MaxParenthesesDepth();
        String s = "(1+(2*3)+((8)/4))+1";
        int result = solution.maxDepth(s);
        System.out.println("Maximum nesting depth: " + result); // Expected output: 3
    }

    public int maxDepth(String s) {
        int open = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                open--;
            }
            max = Math.max(max, open);
        }
        return max;

    }
}