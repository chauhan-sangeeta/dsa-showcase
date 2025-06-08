package com.dsa.array.binarysearch.partitionIndex;
/*4. Median of Two Sorted Arrays
        Solved
Hard
        Topics
conpanies icon
Companies
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
        0 <= n <= 1000
        1 <= m + n <= 2000
        -106 <= nums1[i], nums2[i] <= 106*/
class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        FindMedianSortedArrays solution = new FindMedianSortedArrays();
        double median = solution.findMedianSortedArrays(nums1, nums2);
        System.out.printf("The median of the two sorted arrays is: %.5f%n", median);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m=nums1.length;
        int n=nums2.length;
        int low=0; int high=m;
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=(m+n+1)/2-mid1;
            int l1=mid1==0?Integer.MIN_VALUE:nums1[mid1-1];
            int l2=mid2==0?Integer.MIN_VALUE:nums2[mid2-1];
            int r1=mid1==m?Integer.MAX_VALUE:nums1[mid1];
            int r2=mid2==n?Integer.MAX_VALUE:nums2[mid2];
            if(l1<=r2 && l2<=r1){//we found exact symmetry
                if((m+n)%2==0){//even numbers
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
                else{
                    return Math.max(l1,l2);
                }
            }
            else if(l1>r2){
               high=mid1-1;
            }
            else
               low=mid1+1;
        }
        return 0.0;
    }
    /**
     * This method finds the median of two sorted arrays in linear time.
     * It merges the two arrays and finds the median based on the total length.
     *
     * @param nums1 First sorted array
     * @param nums2 Second sorted array
     * @return The median of the two sorted arrays
     */
    public double findMedianSortedArraysInLinearTime(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int mid =(nums1.length+nums2.length)/2;
        int count=0;
        int a=0;
        int b=0;
        while(count<=mid&&i<nums1.length && j< nums2.length){
            a=b;
            if(nums1[i]<=nums2[j]){
                b=nums1[i];
                i++;

            }else{
                b=nums2[j];
                j++;
            }
            count++;

        }
        while(count<=mid&&i<nums1.length){
            a=b;
            b=nums1[i];
            i++;
            count++;
        }
        while(count<=mid && j< nums2.length){
            a=b;
            b=nums2[j];
            j++;
            count++;
        }
        if((nums1.length+nums2.length)%2==0)
            return (double)(a+b)/2;
        else
            return (double)b;
    }
}