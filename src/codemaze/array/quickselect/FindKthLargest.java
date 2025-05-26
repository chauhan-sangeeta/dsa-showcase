package codemaze.array.quickselect;

import java.util.Random;

/*
215. Kth Largest Element in an Array
Solved
        Medium
Topics
        Companies
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?



Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4


Constraints:

        1 <= k <= nums.length <= 105
        -104 <= nums[i] <= 104*/
class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4; // Find the 4th largest element
        FindKthLargest finder = new FindKthLargest();
        int result = finder.findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }
    public int findKthLargest(int[] nums, int k) {
        //nums.length - k  - converting it to kth smallest element
        return quickSelect(nums, 0,nums.length - 1, nums.length - k);
    }

    // This method implements the Quickselect algorithm to find the kth largest element
    // in the array. It uses a partitioning approach similar to QuickSort.
    // The time complexity is O(n) on average, but can degrade to O(n^2) in the worst case.
    // The space complexity is O(1) since it operates in-place.

    public int quickSelect(int[] nums, int low, int high, int k) {
        if (low == high) return nums[low];


        int partition = partition(nums, low, high);
        if (partition == k) {
            return nums[partition];
        }
        if (partition < k) {
            partition++;
            while (partition < k && nums[partition] == nums[partition - 1]) {
                partition++;
            }
            return quickSelect(nums, partition, high, k);
        } else {
            partition--;
            while (partition > k && nums[partition] == nums[partition - 1]) {
                partition--;
            }
            return quickSelect(nums, low, partition, k);


        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivotIndex = getRandom(low, high);
        swap(arr, pivotIndex, high);
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int getRandom(int low, int high) {
        Random random = new Random();
        return random.nextInt(high - low + 1) + low;
    }
}
