package com.dsa.showcase.sorting.hard;// User function Template for Java
/*Number of greater elements to the right
Difficulty: MediumAccuracy: 56.74%Submissions: 41K+Points: 4Average Time: 10m
Given an array of N integers and Q queries of indices. For each query indices[i], determine the count of elements in arr that are strictly greater than arr[indices[i]] to its right (after the position indices[i]).

Examples :

Input: arr[] = [3, 4, 2, 7, 5, 8, 10, 6], queries = 2, indices[] = [0, 5]
Output:  [6, 1]
Explanation: The next greater elements to the right of 3(index 0) are 4,7,5,8,10,6. The next greater elements to the right of 8(index 5) is only 10.
Input: arr[] = [1, 2, 3, 4, 1], queries = 2, indices[] = [0, 3]
Output:  [3, 0]
Explanation: The count of numbers to the right of index 0 which are greater than arr[0] is 3 i.e. (2, 3, 4). Similarly, the count of numbers to the right of index 3 which are greater than arr[3] is 0, since there are no greater elements than 4 to the right of the array.
Constraints:
        1 <= N <= 104
        1 <= arr[i] <= 105
        1 <= queries <= 100
        0 <= indices[i] <= N - 1*/
public class CountOfGreaterNumberAfterSelf {
    public int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        int n = arr.length;
        int[] count = new int[n];
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        mergeSort(arr, indexes, count, 0, n - 1);
        int[] result = new int[queries];
        for (int i = 0; i < queries; i++) {
            result[i] = count[indices[i]];
        }
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
        int n1 = mid + 1 - left;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = indexes[left + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = indexes[mid + 1 + i];
        }
        int i = 0, j = 0, k = left, rightCount = 0;
        while (i < n1 && j < n2) {
            if (arr[L[i]] < arr[R[j]]) {
                count[L[i]] += n2 - j;  // Count how many are greater to the right
                indexes[k++] = L[i++];
            } else {
                indexes[k++] = R[j++];
            }
        }
        while (i < n1) {
            indexes[k++] = L[i++];
        }
        while (j < n2) {
            indexes[k++] = R[j++];
        }
    }
}
