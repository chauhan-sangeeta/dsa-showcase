package com.dsa.showcase.stackandqueue.imp;

import java.util.ArrayDeque;
import java.util.Deque;
/*907. Sum of Subarray Minimums
Solved
        Medium
Topics
conpanies icon
Companies
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.



Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation:
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444


Constraints:

        1 <= arr.length <= 3 * 104
        1 <= arr[i] <= 3 * 104*/
public class SumSubarrayMins {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        SumSubarrayMins ssm = new SumSubarrayMins();
        int[] nums = {3, 1, 2, 4};
        int result = ssm.sumSubarrayMins(nums);
        System.out.println("Sum of Subarray Minimums: " + result);
    }

    public int sumSubarrayMins(int[] nums) {
        int[] nextSmaller = nse(nums);
        int[] prevSmallerOrEqual = psee(nums);
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = i - prevSmallerOrEqual[i];
            int right = nextSmaller[i] - i;
            long contribution = (long) nums[i] * left * right;
            res = (int) ((res + contribution) % MOD);
        }

        return res;
    }
    public long sumSubarrayMinsLongVersion(int[] nums) {
        int[] nextSmaller = nse(nums);
        int[] prevSmallerOrEqual = psee(nums);
        long res = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = i - prevSmallerOrEqual[i];
            int right = nextSmaller[i] - i;
            long contribution = (long) nums[i] * left * right;
            res = res + contribution;
        }

        return res;
    }

    // Previous Smaller or Equal Element (PSEE)
    public int[] psee(int[] nums) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[i] < nums[st.peek()]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return ans;
    }

    // Next Smaller Element (NSE)
    public int[] nse(int[] nums) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[i] < nums[st.peek()]) {
                ans[st.pop()] = i;
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            ans[st.pop()] = n;
        }

        return ans;
    }
}
