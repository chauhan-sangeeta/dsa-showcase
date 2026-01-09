package com.dsa.showcase.year2025.math;
/*9. Palindrome Number
Solved
        Easy
Topics
conpanies icon
Companies
        Hint
Given an integer x, return true if x is a palindrome, and false otherwise.



        Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
        Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


Constraints:

        -231 <= x <= 231 - 1


Follow up: Could you solve it without converting the integer to a string?*/
public class IsPalindromeInteger {
    public static void main(String[] args) {
        IsPalindromeInteger solution = new IsPalindromeInteger();
        int x = 121;
        boolean result = solution.isPalindrome(x);
        System.out.println("Is the integer " + x + " a palindrome? " + result); // Expected output: true

        x = -121;
        result = solution.isPalindrome(x);
        System.out.println("Is the integer " + x + " a palindrome? " + result); // Expected output: false

        x = 10;
        result = solution.isPalindrome(x);
        System.out.println("Is the integer " + x + " a palindrome? " + result); // Expected output: false
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int dup = x;
        int num = 0;
        while (x != 0) {
            int digit = x % 10;
            num = num * 10 + digit;
            x = x / 10;
        }
        return num == dup;
    }
}