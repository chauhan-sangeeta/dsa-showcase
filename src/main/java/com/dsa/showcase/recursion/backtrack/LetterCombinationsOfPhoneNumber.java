package com.dsa.showcase.recursion.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/*17. Letter Combinations of a Phone Number
Solved
        Medium
Topics
conpanies icon
Companies
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.




Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

        0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].*/
public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber solution = new LetterCombinationsOfPhoneNumber();
        String digits = "23";
        List<String> combinations = solution.letterCombinations(digits);
        System.out.println(combinations); // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    }
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        Map<Character,char []> digitMap=populateMap();
        char [] crr= new char[digits.length()];
        if(digits.isEmpty()) return result;
        letterCombinations(crr,0,digits,digitMap,result);
        return result;

    }
    public void letterCombinations(char [] crr, int count,String digits,Map<Character,char []> digitMap,List<String> result){
        if(count==digits.length())
          {
            result.add(new String(crr));
            return;
          }
        for(char c :digitMap.get(digits.charAt(count))){
            crr[count]=c;
            letterCombinations(crr,count+1,digits,digitMap,result);
        }
    }
    public Map<Character,char []> populateMap(){
/*        Map<Character,char []> digitMap=new HashMap<>();
        digitMap.put('2', new char[]{'a','b','c'});
        digitMap.put('3', new char[]{'d','e','f'});
        digitMap.put('4', new char[]{'g','h','i'});
        digitMap.put('5', new char[]{'j','k','l'});
        digitMap.put('6', new char[]{'m','n','o'});
        digitMap.put('7', new char[]{'p','q','r','s'});
        digitMap.put('8', new char[]{'t','u','v'});
        digitMap.put('9', new char[]{'w','x','y','z'});*/
        return Map.of(
            '2', "abc".toCharArray(),
            '3', "def".toCharArray(),
            '4', "ghi".toCharArray(),
            '5', "jkl".toCharArray(),
            '6', "mno".toCharArray(),
            '7', "pqrs".toCharArray(),
            '8', "tuv".toCharArray(),
            '9', "wxyz".toCharArray()
        );
    }
}