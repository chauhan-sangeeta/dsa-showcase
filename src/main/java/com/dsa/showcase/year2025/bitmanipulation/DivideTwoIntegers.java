package com.dsa.showcase.year2025.bitmanipulation;
/*29. Divide Two Integers
        Solved
Medium
        Topics
conpanies icon
Companies
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.



Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.


Constraints:

        -231 <= dividend, divisor <= 231 - 1
divisor != 0*/
public class DivideTwoIntegers {
    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        int dividend = 10;
        int divisor = 3;
        System.out.println("Result of " + dividend + " / " + divisor + " = " + divideTwoIntegers.divide(dividend, divisor));

        dividend = 7;
        divisor = -3;
        System.out.println("Result of " + dividend + " / " + divisor + " = " + divideTwoIntegers.divide(dividend, divisor));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = (dividend >= 0) == (divisor >= 0);

        long num = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long quotient = 0;
        while (num >= d) {
            int count = 0;
            while (num >= (d << (count + 1))) count++;
            quotient += (1 << count);
            num -= (d << count);
        }
        if (quotient > Integer.MAX_VALUE) {
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return sign ? (int) quotient : (int) -quotient;

    }
}