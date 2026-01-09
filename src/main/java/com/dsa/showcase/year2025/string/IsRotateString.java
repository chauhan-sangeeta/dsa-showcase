package com.dsa.showcase.year2025.string;
/*796. Rotate String
Solved
        Easy
Topics
conpanies icon
Companies
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.


        Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false


Constraints:

        1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.*/
public class IsRotateString {
    public static void main(String[] args) {
        IsRotateString solution = new IsRotateString();
        String s = "abcde";
        String goal = "cdeab";
        boolean result = solution.rotateString(s, goal);
        System.out.println("Can s be rotated to get goal? " + result); // Expected output: true
    }
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        String doubleString=s+s;
        return doubleString.contains(goal);
    }
}