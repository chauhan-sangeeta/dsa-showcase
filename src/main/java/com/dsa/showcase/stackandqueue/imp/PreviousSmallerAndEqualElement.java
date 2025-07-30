package com.dsa.showcase.stackandqueue.imp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
public class PreviousSmallerAndEqualElement {
    public static void main(String[] args) {
        PreviousSmallerAndEqualElement lnse = new PreviousSmallerAndEqualElement();
        int[] nums = {4, 5, 2, 10, 8};
        int[] result = lnse.previousSmallerAndEqual(nums);
        System.out.print("Left Smaller Elements: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public int[] previousSmallerAndEqual(int[] nums) {
        // code here
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[i] < nums[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) ans[i] = -1;
            else ans[i] = nums[st.peek()];
            st.push(i);
        }
        return ans;
    }
}
