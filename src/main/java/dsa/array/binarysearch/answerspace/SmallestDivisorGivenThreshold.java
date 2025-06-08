package dsa.array.binarysearch.answerspace;

/*1283. Find the Smallest Divisor Given a Threshold
        Solved
Medium
        Topics
conpanies icon
Companies
        Hint
Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

The test cases are generated so that there will be an answer.



Example 1:

Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).
Example 2:

Input: nums = [44,22,33,11,1], threshold = 5
Output: 44


Constraints:

        1 <= nums.length <= 5 * 104
        1 <= nums[i] <= 106
nums.length <= threshold <= 106*/
class SmallestDivisorGivenThreshold {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        SmallestDivisorGivenThreshold solution = new SmallestDivisorGivenThreshold();
        int result = solution.smallestDivisor(nums, threshold);
        System.out.println("The smallest divisor is: " + result);
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int left = 1;
        int right = findMax(nums);

        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = getSum(nums, mid);
            // Check if the sum of divisions is less than or equal to the threshold
            if (sum <= threshold) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getSum(int[] nums, int div) {
        int sum = 0;
        for (int num : nums) {
            // Calculate the sum of the ceiling of each division
            sum += Math.ceil((double) num / (double) div);
        }
        return sum;
    }

    private int findMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
}