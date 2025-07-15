package com.dsa.showcase.bitmanipulation.basic;

public class NumberOf1Bits {
    public static void main(String[] args) {
        NumberOf1Bits numberOf1Bits = new NumberOf1Bits();
        int n = 11; // Example input
        System.out.println("Number of 1 bits in " + n + ": " + numberOf1Bits.hammingWeight(n));
        System.out.println("Number of 1 bits using Brian Kernighan's algorithm: " + numberOf1Bits.hammingWeightUsingBrianKernighan(n));
    }
    //time complexity: O(log n)
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            if((n&1)==1)
                count++;
            n=n>>1;
        }
        return count;
    }
    //time complexity: O(k) where k is the number of 1 bits in n
    public int hammingWeightUsingBrianKernighan(int n) {
        int count=0;
        while(n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }
}