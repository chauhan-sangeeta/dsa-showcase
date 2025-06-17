package com.dsa.showcase.array.prefixSum;

import java.util.HashMap;
import java.util.Map;

/*Count Subarrays with given XOR
Difficulty: MediumAccuracy: 58.86%Submissions: 42K+Points: 4
Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

        Examples:

Input: arr[] = [4, 2, 2, 6, 4], k = 6
Output: 4
Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6]. Hence, the answer is 4.
Input: arr[] = [5, 6, 7, 8, 9], k = 5
Output: 2
Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]. Hence, the answer is 2.
Input: arr[] = [1, 1, 1, 1], k = 0
Output: 4
Explanation: The subarrays are [1, 1], [1, 1], [1, 1] and [1, 1, 1, 1].
Constraints:

        1 ≤ arr.size() ≤ 105
        0 ≤ arr[i] ≤105
        0 ≤ k ≤ 105*/
public class SubarrayXorSolution {
    public static void main(String[] args) {
        SubarrayXorSolution solution = new SubarrayXorSolution();
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        long result = solution.subarrayXor(arr, k);
        System.out.println("The number of subarrays with XOR equal to " + k + " is: " + result);
    }

    public long subarrayXor(int arr[], int k) {
        // Using a HashMap to store the frequency of prefix XORs
        Map<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        int count = 0;
        map.put(0, 1);
        for (int a : arr) {
            // Calculate the current prefix XOR
            currSum ^= a;
            // Check if there is a prefix XOR that, when XORed with currSum, equals k
            count += map.getOrDefault(currSum ^ k, 0);
            // Update the frequency of the current prefix XOR in the map
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }
}