package com.dsa.showcase.array;
/*485. Max Consecutive Ones
        Solved
Easy
        Topics
Companies
        Hint
Given a binary array nums, return the maximum number of consecutive 1's in the array.



Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2


Constraints:

        1 <= nums.length <= 105
nums[i] is either 0 or 1.*/
class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        int result = maxConsecutiveOnes.findMaxConsecutiveOnes(nums);
        System.out.println("The maximum number of consecutive 1's is: " + result);
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int count =0;
        int max=0;
        for(int num : nums){
            if(num==0){
                max = Math.max(max,count);
                count=0;
            }else{
                count++;
            }
        }
        return Math.max(max,count);
        
    }
}