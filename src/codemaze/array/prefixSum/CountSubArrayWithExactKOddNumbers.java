package codemaze.array.prefixSum;

import java.util.HashMap;
import java.util.Map;
/*1248. Count Number of Nice Subarrays
        Solved
Medium
        Topics
conpanies icon
Companies
        Hint
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.



        Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16


Constraints:

        1 <= nums.length <= 50000
        1 <= nums[i] <= 10^5
        1 <= k <= nums.length*/
class CountSubArrayWithExactKOddNumbers {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        CountSubArrayWithExactKOddNumbers solution = new CountSubArrayWithExactKOddNumbers();
        int result = solution.numberOfSubarraysUsingPrefixSum(nums, k);
        System.out.println("The number of subarrays with exactly " + k + " odd numbers is: " + result);
    }
    // To find the number of subarrays with exactly k odd numbers, we can use prefix sum and a hashmap.
    public int numberOfSubarraysUsingPrefixSum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        int count = 0;
        // Initialize the map with 0 sum to handle the case where a subarray starts from index 0
        map.put(0, 1);
        for (int num : nums) {
            // Increment currSum by 1 if the number is odd, otherwise by 0
            currSum += (num%2);
            // Check if there is a prefix sum that gives us exactly k odd numbers
            count += map.getOrDefault(currSum - k, 0);
            // Update the map with the current prefix sum
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }
    // To find the number of subarrays with exactly k odd numbers, we can use the sliding window technique.
    public int numberOfSubarraysUsingSlidingWindowTrick(int[] nums, int k) {
        return findAtMostKOddNumbers(nums,k)-findAtMostKOddNumbers(nums,k-1);
    }
    public int findAtMostKOddNumbers(int[] nums, int k) {
        int start = 0;
        int odd = 0;
        int count =0;
        for(int i =0; i < nums.length; i++){
            // Increment odd count if the current number is odd
            if(nums[i]%2!=0){
                odd++;
            }
            // If the count of odd numbers exceeds k, move the start pointer to reduce the count
            while(start<nums.length && odd>k){
                if(nums[start]%2!=0){
                    odd--;
                }
                start++;
            }
            count+=i-start+1;
        }
        return count;
    }
}