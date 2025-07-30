package com.dsa.showcase.array;

public class PrintSubArray {
    public static void main(String[] args) {
        PrintSubArray solution = new PrintSubArray();
        int[] arr = {1, 2, 3};
        solution.printSubArray(arr);
        System.out.println("Using recursion:");
        solution.printSubArrayUsingRecursion(arr, 0, 0);
    }

    public void printSubArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.print("[");
                for (int k = i; k <= j; k++) {
                    if (k > i) {
                        System.out.print(",");
                    }
                    System.out.print(arr[k]);
                }
                System.out.println("]");
            }
        }
    }

    public void printSubArrayUsingRecursion(int[] arr, int start, int end) {
        if (end == arr.length) {
            return;
        }
        if (start > end) {
            printSubArrayUsingRecursion(arr, 0, end + 1);
            return;
        }
        System.out.print("[");
        for (int i = start; i <= end; i++) {
            if (i > start) {
                System.out.print(",");
            }
            System.out.print(arr[i]);
        }
        System.out.println("]");
        printSubArrayUsingRecursion(arr, start + 1, end);
    }
}