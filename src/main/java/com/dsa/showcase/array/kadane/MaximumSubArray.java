package com.dsa.showcase.array.kadane;

import java.util.Arrays;

/*53. Maximum Subarray
Solved
        Medium
Topics
        Companies
Given an integer array nums, find the subarray with the largest sum, and return its sum.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


Constraints:

        1 <= nums.length <= 105
        -104 <= nums[i] <= 104


Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.*/
class MaximumSubArray {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        System.out.println(maximumSubArray.maxSubArray(arr));
    }
    public int maxSubArray(int[] nums) {
        int maxEnd=nums[0];
        int res=nums[0];
        for(int i=1;i<nums.length;i++){
            maxEnd=Math.max(maxEnd+nums[i],nums[i]);
            res=Math.max(res,maxEnd);
        }
        return res;
    }
    public int[] printMaxSubArray(int[] nums) {
        int maxEnd = nums[0];
        int res = nums[0];
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxEnd + nums[i]) {
                maxEnd = nums[i];
                tempStart = i;
            } else {
                maxEnd += nums[i];
            }

            if (maxEnd > res) {
                res = maxEnd;
                start = tempStart;
                end = i;
            }
        }

        return Arrays.copyOfRange(nums, start, end + 1);
    }
}