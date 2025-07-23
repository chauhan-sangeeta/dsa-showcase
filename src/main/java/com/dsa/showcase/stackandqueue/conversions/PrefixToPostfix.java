package com.dsa.showcase.stackandqueue.conversions;// User function Template for Java

import java.util.Stack;
/*Prefix to Postfix Conversion
Difficulty: MediumAccuracy: 75.66%Submissions: 26K+Points: 4Average Time: 30m
You are given a string that represents the prefix form of a valid mathematical expression. Convert it to its postfix form.

Example:

Input:
        *-A/BC-/AKL
Output:
ABC/-AK/L-*
Explanation:
The above output is its valid postfix form.
Your Task:

Complete the function preToPost(string pre_exp), which takes a prefix string as input and returns its postfix form.



Expected Time Complexity: O(N).

Expected Auxiliary Space: O(N).

Constraints:

        3<=pre_exp.length()<=100*/
public class PrefixToPostfix {
    public static void main(String[] args) {
        PrefixToPostfix ptp = new PrefixToPostfix();
        String pre_exp = "-+a*b/cd";
        String postfix = ptp.preToPost(pre_exp);
        System.out.println("Prefix: " + pre_exp);
        System.out.println("Postfix: " + postfix);
    }
    static String preToPost(String exp) {
        Stack<String> st = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                st.push(Character.toString(c));
            } else {
                String first = st.pop();
                String second = st.pop();
                StringBuilder sb = new StringBuilder();
                sb.append(first).append(second).append(c);
                st.push(new String(sb));

            }
        }
        return st.pop();
    }
}
