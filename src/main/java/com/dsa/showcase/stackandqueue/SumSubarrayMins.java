package com.dsa.showcase.stackandqueue;

public class SumSubarrayMins {
    static final int MOD = 1_000_000_007;

    //time limit exceeded
    public int sumSubarrayMins(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                ans = (ans + min) % MOD;
            }
        }
        return ans;
    }
}