package dsa.array.binarysearch.template2;

/*Code
        Testcase
Testcase
Test Result
540. Single Element in a Sorted Array
Solved
        Medium
Topics
conpanies icon
Companies
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.



        Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10


Constraints:

        1 <= nums.length <= 105
        0 <= nums[i] <= 105*/
class SingleElementInSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        SingleElementInSortedArray singleElement = new SingleElementInSortedArray();
        int result = singleElement.singleNonDuplicate(nums);
        System.out.println("The single non-duplicate element is: " + result);
    }

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n ==1){
            return nums[0];
        }
        int left =0;
        int right =n-1;
        while(left<right){
            int mid = left + (right-left)/2;
            // Ensure mid is even to compare with the next element
            if(mid%2==1){
                mid--;
            }
            // Check if the mid element is equal to the next element
            // If they are equal, the single element is in the right half
            if(nums[mid]==nums[mid+1]){
                left = mid+2;
            }else{
                right =mid;
            }
        }
        return nums[left];
        
    }
}