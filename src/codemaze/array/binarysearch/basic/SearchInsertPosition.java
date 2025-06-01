package codemaze.array.binarysearch.basic;

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
    //Lower bound binary search is used to find the first position where the target can be inserted
    public int searchInsert(int[] nums, int target) {
        // code here
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int start = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                start = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return start;
    }
}