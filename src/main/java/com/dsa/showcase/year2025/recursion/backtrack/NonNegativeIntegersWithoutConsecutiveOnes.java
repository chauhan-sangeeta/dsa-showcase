package com.dsa.showcase.year2025.recursion.backtrack;

public class NonNegativeIntegersWithoutConsecutiveOnes {
    public int findIntegers(int n) {
        String ele=getBinaryRep(n);
        return backtrack(ele.length(),0,new StringBuilder(),ele);
    }
    public String getBinaryRep(int n){
        return Integer.toBinaryString(n);
    }
    //time complexity: O(2^n), space complexity: O(n)
    //TLE for large n
    //TODO: Optimize the backtracking approach to avoid TLE using dynamic programming or memoization
    public int backtrack(int n,int i,StringBuilder sb,String ele){
        if(i==n){
            if(sb.toString().compareTo(ele)<=0)
                return 1;
            return 0;
        }
        int count=0;
        sb.append("0");
        count+=backtrack(n,i+1,sb,ele);
        sb.deleteCharAt(sb.length() - 1);

        if(sb.isEmpty() || sb.charAt(sb.length()-1)=='0'){
            sb.append("1");
            count+=backtrack(n,i+1,sb,ele);
            sb.deleteCharAt(sb.length() - 1);
        }
        return count;
    }
}