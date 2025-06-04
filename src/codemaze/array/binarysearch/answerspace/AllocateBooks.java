package codemaze.array.binarysearch.answerspace;

class AllocateBooks {

    /**
     * Finds the minimum possible maximum number of pages assigned to a student 
     * when dividing the array of book pages into k contiguous partitions.
     * 
     * @param nums - array representing pages in each book
     * @param k - number of students
     * @return the minimum of the maximum pages assigned to any student, or -1 if allocation is impossible
     */
    public static int findPages(int[] nums, int k) {
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
    private static int getSplit(int[] nums, int maxPages) {
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
    private static int findMax(int[] nums) {
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
    private static int findTotal(int[] nums) {
        int sum = 0; // Fixed initialization from original (was nums[0], which is incorrect)
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
