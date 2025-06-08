package com.dsa.showcase.array.quickselect;

import java.util.Random;

class FindKthSmallest {
    public static void main(String[] args) {
        int[] nums = { 10, 5, 4, 3, 48, 6, 2, 33, 53, 10 };
        int k = 4; // Find the 4th largest element
        FindKthSmallest finder = new FindKthSmallest();
        int result = finder.findKthSmallest(nums, k);
        System.out.println("The " + k + "th Smallest element is: " + result);
    }
    public int findKthSmallest(int[] nums, int k) {
        return quickSelect(nums, 0,nums.length - 1, k-1);
    }
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
