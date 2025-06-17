package com.dsa.showcase.sorting.hard;

import java.util.ArrayList;
import java.util.List;

/*315. Count of Smaller Numbers After Self
Solved
        Hard
Topics
conpanies icon
Companies
Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].



Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Example 2:

Input: nums = [-1]
Output: [0]
Example 3:

Input: nums = [-1,-1]
Output: [0,0]


Constraints:

        1 <= nums.length <= 105
        -104 <= nums[i] <= 104*/
public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf solution = new CountOfSmallerNumbersAfterSelf();
        int[] arr = {5, 2, 6, 1};
        List<Integer> result = solution.countSmaller(arr);
        System.out.println("Count of smaller numbers after self: " + result);
    }

    public List<Integer> countSmaller(int[] arr) {
        int[] count = new int[arr.length];
        int[] indexes = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indexes[i] = i;
        }
        mergeSort(arr, indexes, count, 0, arr.length - 1);
        List<Integer> result = new ArrayList<>();
        for (int c : count) result.add(c);
        return result;
    }

    public void mergeSort(int[] arr, int[] indexes, int[] count, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, indexes, count, left, mid);
            mergeSort(arr, indexes, count, mid + 1, right);
            merge(arr, indexes, count, left, mid, right);
        }
    }

    private void merge(int[] arr, int[] indexes, int[] count, int left, int mid, int right) {
        int rightCount = 0;
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = indexes[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = indexes[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (arr[L[i]] > arr[R[j]]) {
                indexes[k++] = R[j++];
                rightCount++;
            } else {
                indexes[k] = L[i++];
                count[indexes[k++]] += rightCount;
            }
        }

        while (i < n1) {
            indexes[k] = L[i++];
            count[indexes[k++]] += rightCount;
        }
        while (j < n2) indexes[k++] = R[j++];
    }
}