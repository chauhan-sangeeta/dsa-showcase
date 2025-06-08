package com.dsa.array.binarysearch.answerspace;
/*Allocate Minimum Pages
Difficulty: MediumAccuracy: 35.51%Submissions: 277K+Points: 4Average Time: 35m
You are given an array arr[] of integers, where each element arr[i] represents the number of pages in the ith book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

Each student receives atleast one book.
Each student is assigned a contiguous sequence of books.
No book is assigned to more than one student.
The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

        Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

Examples:

Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
Explanation: Allocation can be done in following ways:
        [12] and [34, 67, 90] Maximum Pages = 191
        [12, 34] and [67, 90] Maximum Pages = 157
        [12, 34, 67] and [90] Maximum Pages = 113.
Therefore, the minimum of these cases is 113, which is selected as the output.
Input: arr[] = [15, 17, 20], k = 5
Output: -1
Explanation: Allocation can not be done.
        Input: arr[] = [22, 23, 67], k = 1
Output: 112
Constraints:
        1 <=  arr.size() <= 106
        1 <= arr[i] <= 103
        1 <= k <= 103*/
class AllocateBooks {
    public static void main(String[] args) {
        int[] nums = {12, 34, 67, 90};
        int k = 2;
        AllocateBooks solution = new AllocateBooks();
        int result = solution.findPages(nums, k);
        System.out.println("The minimum of the maximum pages assigned to any student is: " + result);
    }

    /**
     * Finds the minimum possible maximum number of pages assigned to a student 
     * when dividing the array of book pages into k contiguous partitions.
     * 
     * @param nums - array representing pages in each book
     * @param k - number of students
     * @return the minimum of the maximum pages assigned to any student, or -1 if allocation is impossible
     */
    public  int findPages(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return -1;  // Invalid input
        }
        
        int n = nums.length;
        if (n < k) {
            // Not enough books for all students
            return -1;
        }

        int left = findMax(nums);    // Minimum possible max pages is the largest single book
        int right = findTotal(nums); // Maximum possible max pages is sum of all books

        // Binary search between left and right for optimal maximum pages
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Calculate how many students are needed if max pages allowed is mid
            int requiredStudents = getSplit(nums, mid);

            if (requiredStudents <= k) {
                // If we can allocate with mid or fewer students, try to reduce max pages
                right = mid;
            } else {
                // Need more than k students, increase allowed max pages
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * Helper method to calculate how many students are required to allocate books
     * such that no student gets more than 'maxPages' pages.
     * 
     * @param nums - array of book pages
     * @param maxPages - max pages a student can be assigned
     * @return the number of students required for this allocation
     */
    private  int getSplit(int[] nums, int maxPages) {
        int students = 1;
        int currentSum = 0;

        for (int pages : nums) {
            if (pages > maxPages) {
                // If a single book has more pages than maxPages, allocation impossible
                return Integer.MAX_VALUE;
            }

            if (currentSum + pages <= maxPages) {
                currentSum += pages;
            } else {
                students++;
                currentSum = pages;
            }
        }
        return students;
    }

    /**
     * Finds the maximum value in the array.
     * 
     * @param nums - input array
     * @return the maximum element in nums
     */
    private  int findMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    /**
     * Finds the total sum of elements in the array.
     * 
     * @param nums - input array
     * @return sum of all elements in nums
     */
    private  int findTotal(int[] nums) {
        int sum = 0; // Fixed initialization from original (was nums[0], which is incorrect)
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
