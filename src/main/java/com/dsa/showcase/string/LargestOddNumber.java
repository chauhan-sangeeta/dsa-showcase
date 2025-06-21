package com.dsa.showcase.string;
/*1903. Largest Odd Number in String
        Solved
Easy
        Topics
conpanies icon
Companies
        Hint
You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.

A substring is a contiguous sequence of characters within a string.



        Example 1:

Input: num = "52"
Output: "5"
Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.
        Example 2:

Input: num = "4206"
Output: ""
Explanation: There are no odd numbers in "4206".
Example 3:

Input: num = "35427"
Output: "35427"
Explanation: "35427" is already an odd number.


        Constraints:

        1 <= num.length <= 105
num only consists of digits and does not contain any leading zeros.*/
public class LargestOddNumber {
    public static void main(String[] args) {
        LargestOddNumber solution = new LargestOddNumber();
        String num = "52";
        String result = solution.largestOddNumber(num);
        System.out.println("Largest odd number: " + result); // Expected output: "5"
    }
    public String largestOddNumber(String num) {
        int n=num.length();
        for(int i=n-1;i>=0;i--){
            // Check if the digit at index i is odd
            // 0 ASCII is 48 and 1 ASCII is 49
            if(num.charAt(i)%2==1){
                return num.substring(0,i+1);
            }
        }
        return "";
    }
}