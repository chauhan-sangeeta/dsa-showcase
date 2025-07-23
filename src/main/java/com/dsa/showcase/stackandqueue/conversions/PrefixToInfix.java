package com.dsa.showcase.stackandqueue.conversions;// User function Template for Java

import java.util.Stack;
/*Prefix to Infix Conversion
Difficulty: MediumAccuracy: 69.51%Submissions: 31K+Points: 4Average Time: 30m
You are given a string S of size N that represents the prefix form of a valid mathematical expression. The string S contains only lowercase and uppercase alphabets as operands and the operators are +, -, *, /, %, and ^.Convert it to its infix form.

Example 1:

Input:
        *-A/BC-/AKL
Output:
        ((A-(B/C))*((A/K)-L))
Explanation:
The above output is its valid infix form.
Your Task:

Your task is to complete the function string preToInfix(string pre_exp), which takes a prefix string as input and return its infix form.

Expected Time Complexity: O(N).

Expected Auxiliary Space: O(N).

Constraints:

        3<=|S|<=104*/
public class PrefixToInfix {
    public static void main(String[] args) {
        PrefixToInfix pti = new PrefixToInfix();
        String pre_exp = "-+a*b/cd";
        String infix = pti.preToInfix(pre_exp);
        System.out.println("Prefix: " + pre_exp);
        System.out.println("Infix: " + infix);
    }
    static String preToInfix(String exp) {
        Stack<String> st = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                st.push(Character.toString(c));
            } else {
                String first = st.pop();
                String second = st.pop();
                StringBuilder sb = new StringBuilder();
                sb.append('(').append(first).append(c).append(second).append(')');
                st.push(new String(sb));

            }
        }
        return st.pop();
    }
}
