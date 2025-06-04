package codemaze.array.binarysearch.answerspace;

/*410. Split Array Largest Sum
Solved
        Hard
Topics
conpanies icon
Companies
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.



        Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.


Constraints:

        1 <= nums.length <= 1000
        0 <= nums[i] <= 106
        1 <= k <= min(50, nums.length)*/
class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        SplitArrayLargestSum solution = new SplitArrayLargestSum();
        int result = solution.splitArray(nums, k);
        System.out.println("The minimized largest sum of the split is: " + result);
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int left = findMax(nums);
        int right = findTotal(nums);


        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = getSplit(nums, mid);
            if (count <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getSplit(int[] nums, int sum) {
        int split = 1;
        int subArraySum = 0;
        for (int num : nums) {
            if (subArraySum + num <= sum) {
                subArraySum += num;
            } else {
                split++;
                subArraySum = num;
            }
        }
        return split;
    }

    private int findMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    private int findTotal(int[] nums) {
        int sum = nums[0];
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}