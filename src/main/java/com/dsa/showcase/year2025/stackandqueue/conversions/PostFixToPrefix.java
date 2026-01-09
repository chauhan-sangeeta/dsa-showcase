package com.dsa.showcase.year2025.stackandqueue.conversions;// User function Template for Java

import java.util.Stack;
/*Postfix to Prefix Conversion
Difficulty: MediumAccuracy: 76.83%Submissions: 26K+Points: 4Average Time: 30m
You are given a string that represents the postfix form of a valid mathematical expression. Convert it to its prefix form.

Example 1:

Input:
ABC/-AK/L-*
Output:
        *-A/BC-/AKL
Explanation:
The above output is its valid prefix form.

Example 2:

Input:
ab+
Output:
        +ab
Explanation:
The above output is its valid prefix form.
Your Task:

Complete the function string postToPre(string post_exp), which takes a postfix string as input and returns its prefix form.

Expected Time Complexity: O(post_exp.length()).

Expected Auxiliary Space: O(post_exp.length()).

Constraints:

        3<=post_exp.length()<=16000*/
public class PostFixToPrefix {
    public static void main(String[] args) {
        PostFixToPrefix pftp = new PostFixToPrefix();
        String postfix = "ab+cde+fgh*+^*i-";
        String prefix = pftp.postToPre(postfix);
        System.out.println("Postfix: " + postfix);
        System.out.println("Prefix: " + prefix);
    }
    static String postToPre(String exp) {
        Stack<String> st = new Stack<>();
        for(char c: exp.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                st.push(Character.toString(c));
            }else{
                String second = st.pop();
                String first = st.pop();
                StringBuilder sb = new StringBuilder();
                sb.append(c).append(first).append(second);
                st.push(new String(sb));
                
            }
        }
        return st.pop();
    }
}
