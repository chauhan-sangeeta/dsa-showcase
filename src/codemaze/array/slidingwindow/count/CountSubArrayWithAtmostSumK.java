package codemaze.array.slidingwindow.count;

import java.util.HashMap;
import java.util.Map;
class CountSubArrayWithAtmostSumK {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 4;
        CountSubArrayWithAtmostSumK countSubArray = new CountSubArrayWithAtmostSumK();
        int result = countSubArray.find(nums, k);
        System.out.println("The number of subarrays that sum to " + k + " is: " + result);
    }
    public int find(int[] nums, int goal) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
}