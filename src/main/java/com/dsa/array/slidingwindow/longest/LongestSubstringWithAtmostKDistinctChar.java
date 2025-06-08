package com.dsa.array.slidingwindow.longest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/*Most K Distinct Characters
Solved
        Medium
Topics
conpanies icon
Companies
Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.



        Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.


Constraints:

        1 <= s.length <= 5 * 104
        0 <= k <= 50*/
class LongestSubstringWithAtmostKDistinctChar {
    public static void main(String[] args) {
        String str = "eceba";
        int k = 2;
        LongestSubstringWithAtmostKDistinctChar solution = new LongestSubstringWithAtmostKDistinctChar();
        int result = solution.lengthOfLongestSubstringKDistinct(str, k);
        System.out.println("The length of the longest substring with at most " + k + " distinct characters is: " + result);
    }
    // This class finds the length of the longest substring with at most k distinct characters.
    // It uses a sliding window approach with a hashmap to keep track of the characters and their last occurrence indices.
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start =0;
        int max =0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,i);
            if(map.size()>k){
                int lowestIndex = Collections.min(map.values());
                map.remove(s.charAt(lowestIndex));
                start = lowestIndex+1;
            }
            max = Math.max(max, i-start+1);
        }
        return max;
    }
}