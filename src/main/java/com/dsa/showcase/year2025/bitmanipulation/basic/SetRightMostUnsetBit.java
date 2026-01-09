package com.dsa.showcase.year2025.bitmanipulation.basic;

// User function Template for Java
public class SetRightMostUnsetBit {
    public static void main(String[] args) {
        SetRightMostUnsetBit setRightMostUnsetBit = new SetRightMostUnsetBit();
        int n = 10; // Example input
        System.out.println("Original number: " + n);
        System.out.println("Number after setting rightmost unset bit: " + setRightMostUnsetBit.setBit(n));
        System.out.println("Number after setting rightmost unset bit using constant time: " + setRightMostUnsetBit.setBitUsingConstantTime(n));
    }

    //time complexity: O(log n)
    int setBit(int n) {
        // code here
        int mask = 1;
        int original = n;
        while ((n & 1) == 1) {
            n = n >> 1;
            mask = mask << 1;
        }
        return mask | original;
    }

    //time complexity: O(1)
    int setBitUsingConstantTime(int n) {
        return n | (~n & (n + 1));
    }
}