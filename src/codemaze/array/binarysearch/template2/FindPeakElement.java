package codemaze.array.binarysearch.template2;

/*Code
        Testcase
Testcase
Test Result
162. Find Peak Element
        Solved
Medium
        Topics
conpanies icon
Companies
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.



Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.


Constraints:

        1 <= nums.length <= 1000
        -231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.*/
class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        FindPeakElement findPeakElement = new FindPeakElement();
        int result = findPeakElement.findPeakElement(nums);
        System.out.println("The peak element is at index: " + result);
    }
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    // Template 1: Find Peak Element with Boundary Conditions
    // This template handles edge cases for the first and last elements
    public int findPeakElementUsingTemplate1(int[] nums) {
        int n = nums.length;
        // Edge cases:
        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;
        int left =1;
        int right =n-2;
        while(left<=right){
            int mid = left + (right-left)/2;
            int leftEle = nums[mid-1];
            int rightEle = nums[mid+1];
            if(nums[mid]>leftEle && nums[mid]>rightEle){
                return mid;
            }if(nums[mid]>leftEle){
                left = mid+1;
            }else{
                right =mid-1;
            }
        }
        return 0;
    }
}