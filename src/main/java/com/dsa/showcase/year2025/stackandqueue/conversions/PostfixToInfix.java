package com.dsa.showcase.year2025.stackandqueue.conversions;// User function Template for Java

import java.util.Stack;
/*Postfix to Infix Conversion
Difficulty: MediumAccuracy: 49.41%Submissions: 46K+Points: 4Average Time: 30m
You are given a string that represents the postfix form of a valid mathematical expression. Convert it to its infix form.

Example:

Input:
ab*c+
Output:
        ((a*b)+c)
Explanation:
The above output is its valid infix form.
Your Task:

Complete the function string postToInfix(string post_exp), which takes a postfix string as input and returns its infix form.



Expected Time Complexity: O(N).

Expected Auxiliary Space: O(N).

Constraints:

        3<=post_exp.length()<=104*/
public class PostfixToInfix {
    public static void main(String[] args) {
        PostfixToInfix pti = new PostfixToInfix();
        String postfix = "ab+cde+fgh*+^*i-";
        String infix = pti.postToInfix(postfix);
        System.out.println("Postfix: " + postfix);
        System.out.println("Infix: " + infix);
    }

    static String postToInfix(String exp) {
        // code here
        Stack<String> st = new Stack<>();
        for (char c : exp.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                st.push(Character.toString(c));
            } else {
                String second = st.pop();
                String first = st.pop();
                StringBuilder sb = new StringBuilder();
                sb.append('(').append(first).append(c).append(second).append(')');
                st.push(new String(sb));

            }
        }
        return st.pop();
    }
}
