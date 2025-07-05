package com.dsa.showcase.recursion.backtrack;

import java.util.LinkedList;
import java.util.List;

/*3211. Generate Binary Strings Without Adjacent Zeros
Solved
        Medium
Topics
conpanies icon
Companies
        Hint
You are given a positive integer n.

A binary string x is valid if all substrings of x of length 2 contain at least one "1".

Return all valid strings with length n, in any order.



        Example 1:

Input: n = 3

Output: ["010","011","101","110","111"]

Explanation:

The valid strings of length 3 are: "010", "011", "101", "110", and "111".

Example 2:

Input: n = 1

Output: ["0","1"]

Explanation:

The valid strings of length 1 are: "0" and "1".



Constraints:

        1 <= n <= 18*/
public class GenerateBinaryStringsWithoutConsecutiveZeros {
    public static void main(String[] args) {
        GenerateBinaryStringsWithoutConsecutiveZeros generator = new GenerateBinaryStringsWithoutConsecutiveZeros();
        int n = 3; // Example input
        // Generate binary strings of length n without consecutive zeros
        List<String> result = generator.validStrings(n);
        System.out.println(result); // Output: ["111", "110", "101", "100", "011", "010", "001"]

        // Generate binary strings of length n without consecutive ones
        List<String> resultWithoutConsecutiveOne = generator.validStringsWithoutConsecutiveOne(n);
        System.out.println(resultWithoutConsecutiveOne); // Output: ["000", "001", "010", "011", "100", "101", "110"]

        // Generate all binary strings of length n
        List<String> allBinaryStrings = new LinkedList<>();
        generator.backtrack(allBinaryStrings, n, 0, new StringBuilder());
        System.out.println(allBinaryStrings); // Output: All binary strings of length n
    }

    public List<String> validStrings(int n) {
        List<String> result = new LinkedList<>();
        backtrackWithoutConsecutiveZero(result, n, 0, new StringBuilder());
        return result;
    }
    public List<String> validStringsWithoutConsecutiveOne(int n) {
        List<String> result = new LinkedList<>();
        backtrackWithoutConsecutiveOne(result, n, 0, new StringBuilder());
        return result;
    }

    public void backtrackWithoutConsecutiveZero(List<String> result, int n, int i, StringBuilder sb) {
        if (i == n) {
            result.add(new String(sb));
            return;
        }
        sb.append("1");
        backtrackWithoutConsecutiveZero(result, n, i + 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        if (sb.isEmpty() || sb.charAt(sb.length() - 1) == '1') {
            sb.append("0");
            backtrackWithoutConsecutiveZero(result, n, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public void backtrackWithoutConsecutiveOne(List<String> result, int n, int i, StringBuilder sb) {
        if (i == n) {
            result.add(new String(sb));
            return;
        }

        sb.append("0");
        backtrackWithoutConsecutiveOne(result, n, i + 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        if (sb.isEmpty() || sb.charAt(sb.length() - 1) == '0') {
            sb.append("1");
            backtrackWithoutConsecutiveOne(result, n, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public  void backtrack(List<String> result, int n, int i, StringBuilder sb) {
        if (i == n) {
            result.add(new String(sb));
            return;
        }

        sb.append("0");
        backtrack(result, n, i + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("1");
        backtrack(result, n, i + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}