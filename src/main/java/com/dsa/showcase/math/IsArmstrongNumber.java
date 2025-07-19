package com.dsa.showcase.math;
/*1134. Armstrong Number
Solved
        Easy
Topics
conpanies icon
Companies
        Hint
Given an integer n, return true if and only if it is an Armstrong number.

The k-digit number n is an Armstrong number if and only if the kth power of each digit sums to n.



        Example 1:

Input: n = 153
Output: true
Explanation: 153 is a 3-digit number, and 153 = 13 + 53 + 33.
Example 2:

Input: n = 123
Output: false
Explanation: 123 is a 3-digit number, and 123 != 13 + 23 + 33 = 36.


Constraints:

        1 <= n <= 108*/
public class IsArmstrongNumber {
    public static void main(String[] args) {
        IsArmstrongNumber solution = new IsArmstrongNumber();
        int n = 153;
        boolean result = solution.isArmstrong(n);
        System.out.println("Is the number " + n + " an Armstrong number? " + result); // Expected output: true

        n = 123;
        result = solution.isArmstrong(n);
        System.out.println("Is the number " + n + " an Armstrong number? " + result); // Expected output: false
    }
    public boolean isArmstrong(int n) {
        int k = countDigits(n);
        int dup = n;
        int num = 0;
        while (n != 0) {
            int digit = n % 10;
            num += (int) Math.pow(digit, k);
            n = n / 10;
        }
        return num == dup;
    }

    public int countDigits(int n) {
        // code here
        return (int) Math.log10(n) + 1;
    }
}