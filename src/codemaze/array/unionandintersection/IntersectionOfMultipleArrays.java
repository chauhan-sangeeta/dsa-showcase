package codemaze.array.unionandintersection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/*2248. Intersection of Multiple Arrays
Solved
        Easy
Topics
conpanies icon
Companies
        Hint
Given a 2D integer array nums where nums[i] is a non-empty array of distinct positive integers, return the list of integers that are present in each array of nums sorted in ascending order.


Example 1:

Input: nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
Output: [3,4]
Explanation:
The only integers present in each of nums[0] = [3,1,2,4,5], nums[1] = [1,2,3,4], and nums[2] = [3,4,5,6] are 3 and 4, so we return [3,4].
Example 2:

Input: nums = [[1,2,3],[4,5,6]]
Output: []
Explanation:
There does not exist any integer present both in nums[0] and nums[1], so we return an empty list [].


Constraints:

        1 <= nums.length <= 1000
        1 <= sum(nums[i].length) <= 1000
        1 <= nums[i][j] <= 1000
All the values of nums[i] are unique.*/
class IntersectionOfMultipleArrays {
    public static void main(String[] args) {
        int[][] nums = {
            {3, 1, 2, 4, 5},
            {1, 2, 3, 4},
            {3, 4, 5, 6}
        };
        IntersectionOfMultipleArrays intersection = new IntersectionOfMultipleArrays();
        List<Integer> result = intersection.intersection(nums);
        System.out.println("Intersection of multiple arrays: " + result);
    }
    public List<Integer> intersection(int[][] nums) {
        Map<Integer,Integer> countMap = new TreeMap<>();
        int n=nums.length;
        for (int[] ints : nums) {
            for (int num : ints) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        
        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()){
            if(entry.getValue()==n){
                result.add(entry.getKey());
            }
        }
        return result;
    }
}