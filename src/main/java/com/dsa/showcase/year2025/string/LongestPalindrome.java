package com.dsa.showcase.year2025.string;

/*
5. Longest Palindromic Substring
        Solved
Medium
        Topics
conpanies icon
Companies
        Hint
Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
        Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

        1 <= s.length <= 1000
s consist of only digits and English letters.*/
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome solution = new LongestPalindrome();
        String s = "babad";
        String result = solution.longestPalindrome(s);
        System.out.println("Longest Palindromic Substring: " + result); // Expected output: "bab" or "aba"
    }
    public String longestPalindrome(String s) {
        int start=0;
        int end=0;
        int max=1;
        int n=s.length();
        for(int i=0;i<s.length();i++){
            // Check for odd and even length palindromes
            int odd =palin(s,i,i,n);
            int even=palin(s,i,i+1,n);
            // Update max length found so far
            max=Math.max(odd,even);
            if(max>end-start+1){
                // Update start and end indices for the longest palindrome found
                start =i-(max-1)/2;
                end=i+max/2;
            }
        }
        return s.substring(start,end+1);
        
    }
    public int palin(String s,int low,int high,int n){
        while(low>=0 && high<n && s.charAt(low)==s.charAt(high))
        {
            low--;
            high++;
        }
        high--;
        low++;
        return high-low+1;
    }
}