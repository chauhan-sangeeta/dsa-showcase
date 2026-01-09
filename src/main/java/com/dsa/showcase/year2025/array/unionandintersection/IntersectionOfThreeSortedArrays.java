package com.dsa.showcase.year2025.array.unionandintersection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/*1213. Intersection of Three Sorted Arrays
        Solved
Easy
        Topics
conpanies icon
Companies
        Hint
Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays.



        Example 1:

Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
Output: [1,5]
Explanation: Only 1 and 5 appeared in the three arrays.
        Example 2:

Input: arr1 = [197,418,523,876,1356], arr2 = [501,880,1593,1710,1870], arr3 = [521,682,1337,1395,1764]
Output: []


Constraints:

        1 <= arr1.length, arr2.length, arr3.length <= 1000
        1 <= arr1[i], arr2[i], arr3[i] <= 2000*/
class IntersectionOfThreeSortedArrays {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 6};
        int[] b = {2, 3, 5, 7};
        int[] c = {2, 5, 8};

        IntersectionOfThreeSortedArrays intersection = new IntersectionOfThreeSortedArrays();
        List<Integer> result = intersection.arraysIntersectionUsingThreePointer(a, b, c);
        System.out.println("Intersection of three sorted arrays: " + result);
    }

    //most optimal solution for intersection of three sorted arrays
    public List<Integer> arraysIntersectionUsingThreePointer(int[] a, int[] b, int[] c) {
        int i = 0, j = 0,k=0;
        ArrayList<Integer> list = new ArrayList<>();

        while (i < a.length && j < b.length && k<c.length) {
            if (a[i] == b[j] && b[j]==c[k]) {
                list.add(a[i]);
                i++;
                j++;
                k++;
            } else if (a[i] < b[j]) {
                i++;
            } else if(b[j]<c[k]){
                j++;
            }else{
                k++;
            }
        }

        return list;
    }
    //brute force solution for intersection of three sorted arrays
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Map<Integer,Integer> countMap = new TreeMap<>();
        for (int num : arr1) {
            countMap.put(num,countMap.getOrDefault(num,0)+1);
        }
        for (int num : arr2) {
            countMap.put(num,countMap.getOrDefault(num,0)+1);
        }
        for (int num : arr3) {
            countMap.put(num,countMap.getOrDefault(num,0)+1);
        }
        List<Integer> result = new ArrayList<>();
        
        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()){
            if(entry.getValue()==3){
                result.add(entry.getKey());
            }
        }
        return result;
    }
}