package com.dsa.showcase.stackandqueue.conversions;

import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
        InfixToPrefix itp = new InfixToPrefix();
        String infix = "a+b*(c^d-e)^(f+g*h)-i";

        // Step 1: Reverse and swap brackets
        infix = new StringBuilder(infix).reverse().toString();
        infix = infix.replace('(', '#')
                .replace(')', '(')
                .replace('#', ')');

        // Step 2: Convert to postfix (on reversed and modified input)
        String prefix = itp.infixToPrefix(infix);
        System.out.println("Infix:  a+b*(c^d-e)^(f+g*h)-i");
        System.out.println("Prefix: " + prefix);
    }

    public String infixToPrefix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                ans.append(c);
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans.append(st.pop());
                }
                if (!st.isEmpty()) st.pop(); // pop '('
            } else {
                while (!st.isEmpty() && (
                        getPriority(c) < getPriority(st.peek()) ||
                                (getPriority(c) == getPriority(st.peek()) && c != '^')
                )) {
                    ans.append(st.pop());
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }

    public int getPriority(char op) {
        switch (op) {
            case '^': return 3;
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
            default: return -1;
        }
    }
}
