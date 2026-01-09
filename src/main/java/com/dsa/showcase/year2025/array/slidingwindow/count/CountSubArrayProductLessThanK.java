package com.dsa.showcase.year2025.array.slidingwindow.count;

/*713. Subarray Product Less Than K
        Solved
Medium
        Topics
conpanies icon
Companies
        Hint
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.



Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
        [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0


Constraints:

        1 <= nums.length <= 3 * 104
        1 <= nums[i] <= 1000
        0 <= k <= 106*/
class CountSubArrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        CountSubArrayProductLessThanK solution = new CountSubArrayProductLessThanK();
        int result = solution.numSubarrayProductLessThanK(nums, k);
        System.out.println("The number of contiguous subarrays with product less than " + k + " is: " + result);
    }

    // To find the number of contiguous subarrays with product less than k,
    // we can use the sliding window technique.
    // We maintain a product of the elements in the current window and expand the window
    // until the product is less than k. If the product exceeds k, we shrink the window
    // from the left side until the product is less than k again.
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int product = 1;
        int count = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (start < nums.length && product > k - 1) {
                product /= nums[start];
                start++;
            }
            count += i - start + 1;
        }
        return count;
    }
}