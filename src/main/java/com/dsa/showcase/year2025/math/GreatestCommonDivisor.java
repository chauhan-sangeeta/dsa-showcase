package com.dsa.showcase.year2025.math;
/*GCD of two numbers
Difficulty: BasicAccuracy: 51.03%Submissions: 127K+Points: 1
Given two positive integers a and b, find GCD of a and b.

Note: Don't use the inbuilt gcd function

Examples:

Input: a = 20, b = 28
Output: 4
Explanation: GCD of 20 and 28 is 4
Input: a = 60, b = 36
Output: 12
Explanation: GCD of 60 and 36 is 12
Constraints:
        1 ≤ a, b ≤ 109*/
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        int a = 48, b = 18;
        int result = gcd(a, b);
        System.out.println("GCD of " + a + " and " + b + " is: " + result); // Expected output: 6
    }

    /* The GCD is computed using the Euclidean algorithm, which is efficient and works by repeatedly replacing the larger number by its remainder when divided by the smaller number until one of the numbers becomes zero.
     *
     * Time Complexity: O(log(min(a, b)))
     * Space Complexity: O(1)
     */
    public static int gcd(int a, int b) {
        // code here
        while (a > 0 && b > 0) {
            if (a > b) a %= b;
            else b %= a;
        }
        if (a == 0) return b;
        if (b == 0) return a;
        return 0;
    }
}
