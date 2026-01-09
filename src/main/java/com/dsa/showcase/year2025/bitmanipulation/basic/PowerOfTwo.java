package com.dsa.showcase.year2025.bitmanipulation.basic;
/*231. Power of Two
        Solved
Easy
        Topics
conpanies icon
Companies
Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.



        Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1
Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16
Example 3:

Input: n = 3
Output: false


Constraints:

        -231 <= n <= 231 - 1


Follow up: Could you solve it without loops/recursion?*/
public class PowerOfTwo {
    public static void main(String[] args) {
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        int n = 16; // Example input
        System.out.println("Is " + n + " a power of two? " + powerOfTwo.isPowerOfTwo(n));
        System.out.println("Is " + n + " a power of two (constant time)? " + powerOfTwo.isPowerOfTwoInConstantTime(n));
    }

    //time complexity: O(log n)
    public boolean isPowerOfTwo(int n) {
        boolean isPower = false;
        while (n >= 1) {
            if ((n & 1) == 1) {
                if (isPower)
                    return false;
                else {
                    isPower = true;
                }
            }

            n = n >> 1;
        }
        return isPower;
    }

    public boolean isPowerOfTwoInConstantTime(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}