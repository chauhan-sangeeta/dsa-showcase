package com.dsa.showcase.year2025.bitmanipulation;

/*1486. XOR Operation in an Array
        Solved
Easy
        Topics
conpanies icon
Companies
        Hint
You are given an integer n and an integer start.

Define an array nums where nums[i] = start + 2 * i (0-indexed) and n == nums.length.

Return the bitwise XOR of all elements of nums.



        Example 1:

Input: n = 5, start = 0
Output: 8
Explanation: Array nums is equal to [0, 2, 4, 6, 8] where (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8.
Where "^" corresponds to bitwise XOR operator.
        Example 2:

Input: n = 4, start = 3
Output: 8
Explanation: Array nums is equal to [3, 5, 7, 9] where (3 ^ 5 ^ 7 ^ 9) = 8.


Constraints:

        1 <= n <= 1000
        0 <= start <= 1000
n == nums.length*/
public class XorFromStart {
    public static void main(String[] args) {
        XorFromStart xorFromStart = new XorFromStart();
        int n = 5; // Example input
        int start = 0; // Example start value
        System.out.println("XOR operation result: " + xorFromStart.xorOperation(n, start));
        System.out.println("XOR operation using pattern: " + xorFromStart.xorOperationUsingXorPattern(n, start));
    }

    public int xorOperation(int n, int start) {
        int xorr = 0;
        for (int i = 0; i < n; i++) {
            xorr = xorr ^ (start + 2 * i);
        }
        return xorr;
    }

    public int xorOperationUsingXorPattern(int n, int start) {
        // This function calculates the XOR of the array defined by nums[i] = start + 2 * i
        int s = start >> 1;// right shift start by 1 to get the base value for the XOR operation
        int xorPart = find(s - 1) ^ find(s + n - 1);// calculate the XOR from 1 to (s + n - 1) and XOR it with the XOR from 1 to (s - 1)
        return (xorPart << 1) | (start & n & 1);// left shift the xorPart by 1 and combine it with the last bit of start if n is odd
    }

    // This function calculates the XOR from 1 to n
    public static int find(int n) {
        //xor from 1 to n;
        if (n < 0) return 0;
        if (n % 4 == 1) return 1;
        if (n % 4 == 2) return n + 1;
        if (n % 4 == 3) return 0;
        return n;
    }
}