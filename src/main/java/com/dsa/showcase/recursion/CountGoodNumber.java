package com.dsa.showcase.recursion;
/*1922. Count Good Numbers
        Solved
Medium
        Topics
conpanies icon
Companies
        Hint
A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.

A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.



        Example 1:

Input: n = 1
Output: 5
Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
Example 2:

Input: n = 4
Output: 400
Example 3:

Input: n = 50
Output: 564908303


Constraints:

        1 <= n <= 1015*/
public class CountGoodNumber{
    public static void main(String[] args) {
        CountGoodNumber solution = new CountGoodNumber();
        System.out.println(solution.countGoodNumbers(1));  // Output: 5
        System.out.println(solution.countGoodNumbers(4));  // Output: 400
        System.out.println(solution.countGoodNumbers(50)); // Output: 562500000
    }
    static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        int even = 5;  // digits at even indices: 0,2,4,6,8
        int prime = 4; // digits at odd indices: 2,3,5,7
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long evenPow = pow(even, evenCount);
        long primePow = pow(prime, oddCount);

        return (int) ((evenPow * primePow) % MOD);
    }

    public long pow(long x, long n) {
        if (n == 0) return 1;

        long temp = pow(x, n / 2) % MOD;
        temp = (temp * temp) % MOD;

        if (n % 2 == 1) {
            temp = (temp * x) % MOD;
        }

        return temp;
    }
}
