package com.dsa.showcase.stackandqueue.imp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
/*Smaller on Left
Difficulty: MediumAccuracy: 54.85%Submissions: 74K+Points: 4Average Time: 15m
Given an array arr[] of integers, for each element in the array, find the nearest smaller element on its left. If there is no such smaller element, return -1 for that position.

Input: arr[] = [1, 6, 2]
Output: [-1, 1, 1]
Explaination:
There is no number to the left of 1, so we return -1.
        After that, the number is 6, and the nearest smaller number on its left is 1.
Next, the number is 2, and the nearest smaller number on the left is also 1.
Input: arr[] = [1, 5, 0, 3, 4, 5]
Output: [-1, 1, -1, 0, 3, 4]
Explaination:
There is no number to the left of 1,  so we return -1.
        After that, the number is 5,  and the nearest smaller number on its left is 1.
Next, the number is 0, and there is no smaller number on the left, so we return -1.
Then comes 3, and the nearest smaller number on its left is 0.
        After that, the number is 4, and the nearest smaller number on the left is 3.
Finally, the number is 5, and the nearest smaller number on its left is 4.
Constraints:
        1 ≤ arr.size()≤ 106
        1 ≤ arr[i] ≤ 103*/
public class PreviousSmallerElement {
    public static void main(String[] args) {
        PreviousSmallerElement lnse = new PreviousSmallerElement();
        int[] nums = {4, 5, 2, 10, 8};
        int[] result = lnse.leftSmaller(nums);
        System.out.print("Left Smaller Elements: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    public int[] leftSmaller(int[] nums) {
        // code here
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[i] <= nums[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) ans[i] = -1;
            else ans[i] = nums[st.peek()];
            st.push(i);
        }
        return ans;
    }
}
