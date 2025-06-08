package com.dsa.showcase.array.binarysearch.basic;
/*744. Find Smallest Letter Greater Than Target
Solved
        Easy
Topics
conpanies icon
Companies
        Hint
You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.



        Example 1:

Input: letters = ["c","f","j"], target = "a"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
Example 2:

Input: letters = ["c","f","j"], target = "c"
Output: "f"
Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
Example 3:

Input: letters = ["x","x","y","y"], target = "z"
Output: "x"
Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].


Constraints:

        2 <= letters.length <= 104
letters[i] is a lowercase English letter.
letters is sorted in non-decreasing order.
letters contains at least two different characters.
target is a lowercase English letter.*/
class NextGreatestLetter {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'a';
        NextGreatestLetter nextGreatestLetter = new NextGreatestLetter();
        char result = nextGreatestLetter.nextGreatestLetter(letters, target);
        System.out.println("Next greatest letter: " + result);
    }
    //upper bound binary search to find the next greatest letter
    public char nextGreatestLetter(char[] letters, char target) {
        int n=letters.length;
        int left =0;
        int right =n-1;
        int ans =0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(letters[mid]>target){
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid +1;
            }
        }
        return letters[ans];
    }
}