package com.dsa.showcase.string;
/*125. Valid Palindrome
Solved
        Easy
Topics
conpanies icon
Companies
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



        Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
        Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.


        Constraints:

        1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.*/
public class IsPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        IsPalindrome solution = new IsPalindrome();
        boolean result = solution.isPalindrome(s);
        System.out.println("Is the string a palindrome? " + result); // Expected output: true

    }
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j)
        {
            
            while(i<=j && isAlphaNumeric(s.charAt(i)))
                i++;
             while(j>=0 && isAlphaNumeric(s.charAt(j)))
                j--;
            if(i<j && Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j)))
                return false;
            else
            {
                i++;
                j--;
            }
        }
        return true;
        
    }
     boolean isAlphaNumeric(char ch) {
    if ((ch >= '0' & ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
      return false;
    return true;
  }
}