package com.dsa.showcase.year2025.bitmanipulation.basic;

public class IsEvenOdd {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Is " + n + " even? " + isEven(n));
        System.out.println("Is " + n + " odd? " + isOdd(n));

        n = 11;
        System.out.println("Is " + n + " even? " + isEven(n));
        System.out.println("Is " + n + " odd? " + isOdd(n));
    }
    //time complexity: O(1)
    static boolean isEven(int n) {
        // code here
        return (n&1)==0;
    }
    static boolean isOdd(int n) {
        // code here
        return (n&1)==1;
    }
}