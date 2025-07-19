package com.dsa.showcase.math;
/*7. Reverse Integer
Solved
        Medium
Topics
conpanies icon
Companies
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).



Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21


Constraints:

        -231 <= x <= 231 - 1*/
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int x = 123;
        int reversed = reverseInteger.reverse(x);
        System.out.println("Reversed integer: " + reversed); // Expected output: 321

        x = -123;
        reversed = reverseInteger.reverse(x);
        System.out.println("Reversed integer: " + reversed); // Expected output: -321

        x = 1534236469; // This will overflow
        reversed = reverseInteger.reverse(x);
        System.out.println("Reversed integer: " + reversed); // Expected output: 0
    }
    public int reverse(int x) {
        long num = 0;
        while (x != 0) {
            int digit = x % 10;
            num = num * 10 + digit;
            x = x / 10;
        }
        return (num < Integer.MIN_VALUE || num > Integer.MAX_VALUE) ? 0 : (int) num;
    }
}