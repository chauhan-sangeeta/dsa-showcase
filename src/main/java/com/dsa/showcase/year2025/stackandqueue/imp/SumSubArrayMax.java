package com.dsa.showcase.year2025.stackandqueue.imp;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumSubArrayMax {
    public long sumSubarrayMaxs(int[] nums) {
        int[] nextLarger = nle(nums);
        int[] prevLargerOrEqual = plee(nums);
        long res =0;
        for (int i = 0; i < nums.length; i++){
            int left = i - prevLargerOrEqual[i];
            int right = nextLarger[i] - i;
            long contribution = (long) nums[i] * left * right;
            res = res + contribution;
        }
        return res;
    }
    public int[] plee(int[] nums) {
        // code here
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] nle(int nums[]) {
        // code here
        Deque<Integer> st = new ArrayDeque<>();
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                ans[st.pop()] = i;
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            ans[st.pop()] = nums.length;
        }
        return ans;
    }
}