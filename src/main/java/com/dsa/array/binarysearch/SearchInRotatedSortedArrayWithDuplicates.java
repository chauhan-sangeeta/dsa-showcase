package com.dsa.array.binarysearch;
/*81. Search in Rotated Sorted Array II
Solved
        Medium
Topics
conpanies icon
Companies
There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.



        Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false


Constraints:

        1 <= nums.length <= 5000
        -104 <= nums[i] <= 104
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104


Follow up: This problem is similar to Search in Rotated Sorted Array, but nums may contain duplicates. Would this affect the runtime complexity? How and why?*/
class SearchInRotatedSortedArrayWithDuplicates {
    public static void main(String[] args) {
        SearchInRotatedSortedArrayWithDuplicates searchInRotatedSortedArrayWithDuplicates = new SearchInRotatedSortedArrayWithDuplicates();
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        boolean result = searchInRotatedSortedArrayWithDuplicates.search(nums, target);
        System.out.println("Is target found: " + result);
    }

    // This method searches for a target in a rotated sorted array that may contain duplicates.
    // It returns true if the target is found, otherwise false.
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[left] == nums[mid] && nums[mid] == nums[right]) {// when left, mid and right are same then we cannot decide which side is sorted
                right--;
                left++;
            } else if (nums[left] <= nums[mid]) { //it ensure left side is sorted
                if (target >= nums[left] && target < nums[mid]) {//target lie in left sorted side
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {//right side is sorted from mid
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}