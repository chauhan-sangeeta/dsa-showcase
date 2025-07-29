package com.dsa.showcase.stackandqueue.imp;

import java.util.Deque;
import java.util.LinkedList;

/*42. Trapping Rain Water
        Solved
Hard
        Topics
conpanies icon
Companies
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



        Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
1 <= n <= 2 * 104
        0 <= height[i] <= 105*/
public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = solution.trap(height);
        System.out.println("Trapped rainwater: " + result); // Output: 6
    }

    //time complexity O(n) and space complexity O(1)
    public int trap(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int answer = 0;
        while (start < end) {
            if (height[start] <= height[end]) {
                leftMax = Math.max(leftMax, height[start]);
                answer += leftMax - height[start];
                start++;
            } else {
                rightMax = Math.max(rightMax, height[end]);
                answer += rightMax - height[end];
                end--;
            }
        }
        return answer;
    }

    //time complexity O(n) and space complexity O(n)
    public int trapUsingMonotonicStack(int[] height) {
        Deque<Integer> st = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                int top = height[st.pop()];
                if (st.isEmpty()) break;
                int distance = i - st.peek() - 1;
                int boundedHeight = Math.min(height[i], height[st.peek()]) - top;
                ans += distance * boundedHeight;
            }
            st.push(i);
        }
        return ans;
    }
}