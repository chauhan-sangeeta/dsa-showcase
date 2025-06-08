package dsa.array.slidingwindow.longest;

import java.util.HashMap;
import java.util.Map;
/*3. Longest Substring Without Repeating Characters
        Solved
Medium
        Topics
conpanies icon
Companies
        Hint
Given a string s, find the length of the longest substring without duplicate characters.



        Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


        Constraints:

        0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.*/
class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println("The length of the longest substring without repeating characters is: " + result);
    }
    // To find the length of the longest substring without repeating characters,
    // we can use the sliding window technique with a hashmap to keep track of the characters and their indices.
    // We maintain a start pointer to the beginning of the current substring and expand the end pointer to include new characters.
    // If we encounter a character that is already in the hashmap, we move the start pointer to the right of the last occurrence of that character.
    // Finally, we calculate the maximum length of the substring as we expand the end pointer.
    // This approach runs in O(n) time complexity, where n is the length of the string.
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            char c =s.charAt(i);
            if(map.containsKey(c)){
                // We use Math.max to ensure that we do not move the start pointer backward.
                start = Math.max(start, map.get(c)+1);
            }
            max = Math.max(max,i-start+1);
            map.put(c,i);
        }
        return max;
    }
}