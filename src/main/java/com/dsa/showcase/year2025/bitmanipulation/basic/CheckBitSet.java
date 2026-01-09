package com.dsa.showcase.year2025.bitmanipulation.basic;

public class CheckBitSet {
    public static void main(String[] args) {
        int n = 5; // Binary: 101
        int k = 2; // Check if the 2nd bit is set (0-indexed)
        System.out.println("Is the " + k + "th bit of " + n + " set? " + checkKthBit(n, k));
    }
    //time complexity: O(1)
    static boolean checkKthBit(int n, int k) {
        // code here
        n = n>>k;
        return (n&1)==1;
    }
}