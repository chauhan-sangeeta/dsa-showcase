package codemaze.array;
/*189. Rotate Array
Solved
        Medium
Topics
        Companies
Hint
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



        Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


Constraints:

        1 <= nums.length <= 105
        -231 <= nums[i] <= 231 - 1
        0 <= k <= 105


Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?*/
class RotateArrayByKInRight {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3; // Number of steps to rotate
        RotateArrayByKInRight rotateArray = new RotateArrayByKInRight();
        rotateArray.rotate(arr, k);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    public void rotate(int[] arr, int k) {
        int n=arr.length;
            k=k%n;
        rotate(arr,n-k,n-1);
        rotate(arr,0,n-k-1);
        rotate(arr,0,n-1);
    }
    public void rotate(int [] arr, int i, int j){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}