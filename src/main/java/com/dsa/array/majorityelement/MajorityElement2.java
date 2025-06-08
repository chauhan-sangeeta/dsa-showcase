package com.dsa.array.majorityelement;

import java.util.ArrayList;
import java.util.List;
/*229. Majority Element II
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.



        Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]


Constraints:

        1 <= nums.length <= 5 * 104
        -109 <= nums[i] <= 109


Follow up: Could you solve the problem in linear time and in O(1) space?*/
class MajorityElement2 {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        MajorityElement2 majorityElement = new MajorityElement2();
        System.out.println(majorityElement.majorityElement(arr));
    }
    //Boyer-Moore Voting Algorithm optimized
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list =new ArrayList<>();
        if(nums.length==0){
            return list;
        }
        Integer candidate1=null;
        Integer candidate2=null;
        int count1=0;
        int count2=0;
        for(int i=0;i<nums.length;i++){
            if(candidate1!=null &&  candidate1==nums[i]){
                count1++; 
            }else if(candidate2!=null&& candidate2==nums[i]){
                count2++;
            }else if(count1==0){
                candidate1=nums[i];
                count1++;
            }else if(count2==0){
                candidate2=nums[i];
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i=0;i<nums.length;i++){
            if(candidate1!=null && nums[i]==candidate1)count1++;
            if(candidate2!=null && nums[i]==candidate2)count2++;
        }
        if(count1>nums.length/3)list.add(candidate1);
        if(count2>nums.length/3)list.add(candidate2);
        return list;

    }
}