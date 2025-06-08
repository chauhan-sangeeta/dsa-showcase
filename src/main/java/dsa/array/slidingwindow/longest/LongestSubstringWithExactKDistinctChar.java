package dsa.array.slidingwindow.longest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
class LongestSubstringWithExactKDistinctChar {
    public static void main(String[] args) {
        String str = "aabacbebebe";
        int k = 3;
        LongestSubstringWithExactKDistinctChar solution = new LongestSubstringWithExactKDistinctChar();
        int result = solution.lengthOfLongestSubstringExactKDistinct(str, k);
        System.out.println("The length of the longest substring with Exact " + k + " distinct characters is: " + result);
    }
    public int lengthOfLongestSubstringExactKDistinct(String s, int k) {
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
            if(map.size()==k){
                max = Math.max(max, i-start+1);
            }
        }
        return max;

    }
}
