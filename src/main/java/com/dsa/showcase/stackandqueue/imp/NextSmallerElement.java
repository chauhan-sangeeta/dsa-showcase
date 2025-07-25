package com.dsa.showcase.stackandqueue.imp;// User function Template for Java

import java.util.ArrayDeque;
import java.util.Deque;

public class NextSmallerElement {
    public static void main(String[] args) {
        NextSmallerElement nse = new NextSmallerElement();
        int[] nums = {4, 5, 2, 10, 8};
        int[] result = nse.nextSmaller(nums);
        System.out.print("Next Smaller Elements: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    public int[] nextSmaller(int nums[]) {
        // code here
        Deque<Integer> st = new ArrayDeque<>();
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[i] < nums[st.peek()]) {
                ans[st.pop()] = nums[i];
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            ans[st.pop()] = -1;
        }
        return ans;
    }
}