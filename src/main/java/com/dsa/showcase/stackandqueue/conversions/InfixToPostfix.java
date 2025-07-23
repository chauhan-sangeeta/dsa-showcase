package com.dsa.showcase.stackandqueue.conversions;

import java.util.Stack;

/*Infix to Postfix
Difficulty: MediumAccuracy: 52.94%Submissions: 135K+Points: 4
Given an infix expression in the form of string s. Convert this infix expression to a postfix expression.

Infix expression: The expression of the form a op b. When an operator is in between every pair of operands.
Postfix expression: The expression of the form a b op. When an operator is followed for every pair of operands.
Note: The order of precedence is: ^ greater than * equals to / greater than + equals to -. Ignore the right associativity of ^.

Examples :

Input: s = "a+b*(c^d-e)^(f+g*h)-i"
Output: abcd^e-fgh*+^*+i-
Explanation: After converting the infix expression into postfix expression, the resultant expression will be abcd^e-fgh*+^*+i-
Input: s = "A*(B+C)/D"
Output: ABC+*D/
Explanation: After converting the infix expression into postfix expression, the resultant expression will be ABC+*D/
Input: s = "(a+b)*(c+d)"
Output: ab+cd+*
Constraints:
        1 ≤ s.length ≤ 30*/
public class InfixToPostfix {
    public static void main(String[] args) {
        InfixToPostfix itp = new InfixToPostfix();
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        String postfix = itp.infixToPostfix(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + postfix);
    }
    public String infixToPostfix(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {  //Character.isLetterOrDigit(c)
                ans.append(c);
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans.append(st.pop());
                }
                st.pop();
            } else {
                while (!st.isEmpty() && getPriority(c) <= getPriority(st.peek())) {
                    ans.append(st.pop());
                }
                st.push(c);
            }
        }
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return new String(ans);
    }

    public int getPriority(Character op) {
        switch (op) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return -1;
        }
    }
}