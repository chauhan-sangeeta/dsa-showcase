package codemaze.array.binarysearch;
/*34. Find First and Last Position of Element in Sorted Array
Solved
        Medium
Topics
        Companies
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Constraints:

        0 <= nums.length <= 105
        -109 <= nums[i] <= 109
nums is a non-decreasing array.
        -109 <= target <= 109*/

class SearchFirstAndLastPosition {

    // Method to find the first and last position of a target in a sorted array
    public int[] searchRange(int[] nums, int target) {
        // Find the first occurrence of the target
        int first = findFirst(nums, target);

        // If the target is not found, return [-1, -1]
        if (first == -1) {
            return new int[]{-1, -1};
        }

        // Find the last occurrence of the target
        int last = findLast(nums, target);

        // Return the range [first, last]
        return new int[]{first, last};
    }

    // Helper method to find the first occurrence of the target
    public int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int first = -1;

        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the target is found, update `first` and move `right` to search for earlier occurrences
            if (nums[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                // If the target is smaller, search in the left half
                right = mid - 1;
            } else {
                // If the target is larger, search in the right half
                left = mid + 1;
            }
        }

        return first;
    }

    // Helper method to find the last occurrence of the target
    public int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int last = -1;

        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the target is found, update `last` and move `left` to search for later occurrences
            if (nums[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                // If the target is larger, search in the right half
                left = mid + 1;
            } else {
                // If the target is smaller, search in the left half
                right = mid - 1;
            }
        }

        return last;
    }
}