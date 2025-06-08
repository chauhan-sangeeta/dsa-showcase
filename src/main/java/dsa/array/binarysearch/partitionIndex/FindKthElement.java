package dsa.array.binarysearch.partitionIndex;// User function Template for Java

/*K-th element of two Arrays
Difficulty: MediumAccuracy: 37.4%Submissions: 344K+Points: 4Average Time: 15m
Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth position of the combined sorted array.

        Examples :

Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
Output: 6
Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element of this array is 6.
Input: a[] = [100, 112, 256, 349, 770], b[] = [72, 86, 113, 119, 265, 445, 892], k = 7
Output: 256
Explanation: Combined sorted array is [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892]. The 7th element of this array is 256.
Constraints:

        1 <= a.size(), b.size() <= 106
        1 <= k <= a.size() + b.size()
0 <= a[i], b[i] < 108*/
class FindKthElement {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 6, 7, 9};
        int[] nums2 = {1, 4, 8, 10};
        int k = 5;
        FindKthElement solution = new FindKthElement();
        int result = solution.kthElement(nums1, nums2, k);
        System.out.println("The " + k + "th element in the combined sorted array is: " + result);
    }
    public int kthElement(int nums1[], int nums2[], int k) {
        if (nums1.length > nums2.length) {
            return kthElement(nums2, nums1, k);
        }
        int m = nums1.length;
        int n = nums2.length;
        int low = Math.max(0, k - n);
        int high = Math.min(k, m);
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = k - mid1;
            int l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int r1 = mid1 == m ? Integer.MAX_VALUE : nums1[mid1];
            int r2 = mid2 == n ? Integer.MAX_VALUE : nums2[mid2];
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else
                low = mid1 + 1;
        }
        return 0;
    }

    public int kthElementUsingLinearTime(int nums1[], int nums2[], int k) {
        // code here
        int i = 0;
        int j = 0;
        int count = 0;
        int a = 0;
        int b = 0;
        while (count < k && i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                b = nums1[i];
                i++;

            } else {
                b = nums2[j];
                j++;
            }
            count++;

        }
        while (count < k && i < nums1.length) {
            b = nums1[i];
            i++;
            count++;
        }
        while (count < k && j < nums2.length) {
            b = nums2[j];
            j++;
            count++;
        }
        return b;
    }
}