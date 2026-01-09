package com.dsa.showcase.year2025.array.slidingwindow.smallest;
/*209. Minimum Size Subarray Sum
Solved
        Medium
Topics
conpanies icon
Companies
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



        Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0


Constraints:

        1 <= target <= 109
        1 <= nums.length <= 105
        1 <= nums[i] <= 104


Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).*/
class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        MinimumSizeSubArraySum solution = new MinimumSizeSubArraySum();
        int result = solution.minSubArrayLen(target, nums);
        System.out.println("The minimum length of a contiguous subarray with sum at least " + target + " is: " + result);
    }
    public int minSubArrayLen(int target, int[] nums) {
        int start =0;
        int min =Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            // Shrink the window from the left as long as the sum is greater than or equal to the target
            while(sum>=target){
                min=Math.min(min,i-start+1);
                sum-=nums[start];
                start++;
            }
        }
        // If min is still Integer.MAX_VALUE, it means no valid subarray was found
        return min==Integer.MAX_VALUE?0:min;
    }
}