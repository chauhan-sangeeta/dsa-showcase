package dsa.array.unionandintersection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*350. Intersection of Two Arrays II
        Solved
Easy
        Topics
conpanies icon
Companies
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.



        Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.


        Constraints:

        1 <= nums1.length, nums2.length <= 1000
        0 <= nums1[i], nums2[i] <= 1000


Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?*/
class IntersectionOfTwoArraysMaintainCount {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        IntersectionOfTwoArraysMaintainCount intersection = new IntersectionOfTwoArraysMaintainCount();
        int[] result = intersection.intersect(nums1, nums2);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    public int[] intersect(int[] nums1, int[] nums2) {
                // Always iterate over smaller array for efficiency
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer,Integer> smallMap = new HashMap<>();
        for (int num : nums1) {
            smallMap.put(num,smallMap.getOrDefault(num,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> resultMap = new HashMap<>();
        for (int num : nums2) {
            if (smallMap.containsKey(num)) {
                list.add(num);
                 smallMap.put(num,smallMap.getOrDefault(num,0)-1);
                 if(smallMap.get(num)==0){
                    smallMap.remove(num);
                 }
            }
        }
        // Convert set to array
        int[] result = new int[list.size()];
        int i = 0;
        for (int num : list) {
            result[i++] = num;
        }
        return result;
    }
}