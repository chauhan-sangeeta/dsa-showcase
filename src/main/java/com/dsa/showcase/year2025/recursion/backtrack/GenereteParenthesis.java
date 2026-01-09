package com.dsa.showcase.year2025.recursion.backtrack;

import java.util.ArrayList;
import java.util.List;
/*22. Generate Parentheses
Solved
        Medium
Topics
conpanies icon
Companies
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

        1 <= n <= 8*/
public class GenereteParenthesis {
    public static void main(String[] args) {
        GenereteParenthesis genereteParenthesis = new GenereteParenthesis();
        int n = 3; // Example input
        List<String> result = genereteParenthesis.generateParenthesis(n);
        System.out.println(result); // Output: ["((()))","(()())","(())()","()(())","()()()"]
    }

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(0, 0, n, new StringBuilder());
        return result;
    }

    //time complexity: O(4^n/sqrt(n)), space complexity: O(4^n/sqrt(n))
    public void generate(int open, int close, int n, StringBuilder sb) {
        if (sb.length() == 2 * n) {
            System.out.println("Adding to result: " + sb.toString());
            result.add(new String(sb));
            return;
        }
        if (open < n) {
            sb.append("(");
            generate(open + 1, close, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            generate(open, close + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}