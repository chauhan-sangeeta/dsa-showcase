package com.dsa.showcase.year2025.math;

/*Count Digits
Difficulty: EasyAccuracy: 50.84%Submissions: 30K+Points: 2Average Time: 10m
Given a natural number n. You have to find the number of digits in it and return it.

        Examples:

Input: n = 12
Output: 2
Explanation: 12 has 2 digits
Input: n = 456
Output: 3
Explanation: 456 has 3 digits
Constraints:
        1 ≤ n ≤ 105*/
public class CountDigits {
    public int countDigits(int n) {
        // code here
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    public int countDigitsUsingLog10(int n) {
        // code here
        return (int) Math.log10(n) + 1;
    }
}
