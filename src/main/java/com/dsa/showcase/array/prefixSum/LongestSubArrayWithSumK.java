package com.dsa.showcase.array.prefixSum;

import java.util.HashMap;
import java.util.Map;

/*325. Maximum Size Subarray Sum Equals k
Solved
        Medium
Topics
conpanies icon
Companies
        Hint
Given an integer array nums and an integer k, return the maximum length of a subarray that sums to k. If there is not one, return 0 instead.



        Example 1:

Input: nums = [1,-1,5,-2,3], k = 3
Output: 4
Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
Example 2:

Input: nums = [-2,-1,2,1], k = 1
Output: 2
Explanation: The subarray [-1, 2] sums to 1 and is the longest.


Constraints:

        1 <= nums.length <= 2 * 105
        -104 <= nums[i] <= 104
        -109 <= k <= 109*/
class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        LongestSubArrayWithSumK maxSubArrayLen = new LongestSubArrayWithSumK();
        int result = maxSubArrayLen.maxSubArrayLen(nums, k);
        System.out.println("The maximum length of a subarray that sums to " + k + " is: " + result);
    }

    //to have a subarray that sums to k, we can use prefix sum and hashmap
    //handle positive and negative numbers and zero
    // if only positive numbers, we can use sliding window technique
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                maxLen = i + 1;
            }
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    //to handle only positive numbers, we can use sliding window technique
    public int longestSubarrayWithSumK_Positive(int[] arr, int K) {
        int left = 0, sum = 0, maxLen = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum > K) {
                sum -= arr[left];
                left++;
            }

            if (sum == K) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }

}
