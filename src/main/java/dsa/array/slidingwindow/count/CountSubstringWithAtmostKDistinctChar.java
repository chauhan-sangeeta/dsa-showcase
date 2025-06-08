package dsa.array.slidingwindow.count;// User function Template for Java

import java.util.HashMap;
import java.util.Map;

class CountSubstringWithAtmostKDistinctChar {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        CountSubstringWithAtmostKDistinctChar solution = new CountSubstringWithAtmostKDistinctChar();
        int result = solution.countSubstrAtMostK(s, k);
        System.out.println("The number of substrings with atmost " + k + " distinct characters is: " + result);
    }
    int countSubstrAtMostK(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start =0;
        int count =0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.size()>k){
                char removeChar = s.charAt(start);
                map.put(removeChar,map.get(removeChar)-1);
                if(map.get(removeChar)==0){
                    map.remove(removeChar);
                }
                start++;
            }
               count+=i-start+1;
        }
        return count;
    }
}