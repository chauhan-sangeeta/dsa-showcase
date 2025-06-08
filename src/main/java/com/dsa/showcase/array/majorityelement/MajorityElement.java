package com.dsa.showcase.array.majorityelement;
/*169. Majority Element
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
        -109 <= nums[i] <= 109


Follow-up: Could you solve the problem in linear time and in O(1) space?*/
class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(arr));
    }
    //Boyer-Moore Voting Algorithm
    public int majorityElement(int[] arr) {
        Integer candidate=null;
        int vote=0;
        for(int i=0;i<arr.length;i++){

            if(candidate!=null && candidate==arr[i])
                vote++;
            else if(vote==0){
                candidate=arr[i];
                vote=1;
            }
            else
                vote--;
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(candidate==arr[i])
                count++;
        }
        return count>arr.length/2?candidate:-1;
    }
}