package com.dsa.showcase.year2025.stackandqueue;

import java.util.Stack;
/*20. Valid Parentheses
Solved
        Easy
Topics
conpanies icon
Companies
        Hint
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


        Example 1:

        Input: s = "()"

        Output: true

        Example 2:

        Input: s = "()[]{}"

        Output: true

        Example 3:

        Input: s = "(]"

        Output: false

        Example 4:

        Input: s = "([])"

        Output: true

        Example 5:

        Input: s = "([)]"

        Output: false



        Constraints:

        1 <= s.length <= 104
        s consists of parentheses only '()[]{}'.*/
public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        String s = "{[()]}";
        System.out.println("Is the string \"" + s + "\" valid? " + vp.isValid(s));

        s = "{[(])}";
        System.out.println("Is the string \"" + s + "\" valid? " + vp.isValid(s));
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '}' || c == ')' || c == ']') {
                if (st.isEmpty()) return false;
                char top = st.pop();
                if ((c == '}' && top != '{') || (c == ')' && top != '(') || (c == ']' && top != '[')) {
                    return false;
                }
            } else
                st.push(c);
        }
        return st.isEmpty();

    }
}