package codemaze.array.binarysearch;
/*35. Search Insert Position
        Solved
Easy
        Topics
Companies
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4


Constraints:

        1 <= nums.length <= 104
        -104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
        -104 <= target <= 104*/
class SearchInsertPosition {

    // Method to find the index where the target should be inserted in a sorted array
    public int searchInsert(int[] nums, int target) {
        int left = 0; // Initialize the left pointer
        int right = nums.length - 1; // Initialize the right pointer

        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            // If the target is found, return its index
            if (nums[mid] == target) {
                return mid;
            }
            // If the target is greater, search in the right half
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            // If the target is smaller, search in the left half
            else {
                right = mid - 1;
            }
        }

        // If the target is not found, return the index where it should be inserted
        return left;
    }
}