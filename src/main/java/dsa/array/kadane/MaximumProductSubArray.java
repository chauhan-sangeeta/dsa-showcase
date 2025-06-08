package dsa.array.kadane;
/*152. Maximum Product Subarray
        Solved
Medium
        Topics
Companies
Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


Constraints:

        1 <= nums.length <= 2 * 104
        -10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.*/
class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        MaximumProductSubArray maximumProductSubArray = new MaximumProductSubArray();
        System.out.println(maximumProductSubArray.maxProduct(arr));
    }
    //kadane algo
    public int maxProduct(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int result=nums[0];
        int currMin=nums[0];
        int currMax=nums[0];
        for(int i=1;i<nums.length;i++){
            int temp= Math.max(Math.max(currMax*nums[i],currMin*nums[i]),nums[i]);
            currMin= Math.min(Math.min(currMax*nums[i],currMin*nums[i]),nums[i]);
            currMax=temp;
            result=Math.max(result,currMax);
        }
        return result;
    }
}