package com.dsa.showcase.bitmanipulation;

import java.util.Arrays;
import java.util.List;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        SwapTwoNumbers swapTwoNumbers = new SwapTwoNumbers();
        int a = 5, b = 10;
        System.out.println("Before swap: a = " + a + ", b = " + b);
        List<Integer> swapped = swapTwoNumbers.get(a, b);
        System.out.println("After swap: a = " + swapped.get(0) + ", b = " + swapped.get(1));
    }

    //time complexity: O(1)
    public List<Integer> get(int a, int b) {
        // code here
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        return Arrays.asList(a, b);
    }
}