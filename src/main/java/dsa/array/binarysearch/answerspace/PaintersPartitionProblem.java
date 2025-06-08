package dsa.array.binarysearch.answerspace;
/*The Painter's Partition Problem-II
Difficulty: HardAccuracy: 27.52%Submissions: 137K+Points: 8
Dilpreet wants to paint his dog's home that has n boards with different lengths. The length of ith board is given by arr[i] where arr[] is an array of n integers. He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board.

Return the minimum time to get this job done if all painters start together with the constraint that any painter will only paint continuous boards, say boards numbered [2,3,4] or only board [1] or nothing but not boards [2,4,5].

Examples:

Input: arr[] = [5, 10, 30, 20, 15], k = 3
Output: 35
Explanation: The most optimal way will be: Painter 1 allocation : [5,10], Painter 2 allocation : [30], Painter 3 allocation : [20,15], Job will be done when all painters finish i.e. at time = max(5+10, 30, 20+15) = 35
Input: arr[] = [10, 20, 30, 40], k = 2
Output: 60
Explanation: The most optimal way to paint: Painter 1 allocation : [10,20,30], Painter 2 allocation : [40], Job will be complete at time = 60
Input: arr[] = [100, 200, 300, 400], k = 1
Output: 1000
Explanation: There is only one painter, so the painter must paint all boards sequentially. The total time taken will be the sum of all board lengths, i.e., 100 + 200 + 300 + 400 = 1000.
Constraints:
        1 ≤ arr.size() ≤ 105
        1 ≤ arr[i] ≤ 105
        1 ≤ k ≤ 105*/
class PaintersPartitionProblem {
    public static void main(String[] args) {
        int[] boards = {5, 10, 30, 20, 15};
        int k = 3;
        PaintersPartitionProblem solution = new PaintersPartitionProblem();
        int result = solution.minTime(boards, k);
        System.out.println("Minimum time to paint all boards: " + result);
    }

    /**
     * Solves the Painter's Partition Problem.
     *
     * @param nums array representing length of each board
     * @param k number of painters
     * @return minimum time to paint all boards using k painters
     */
    public int minTime(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return -1;  // Invalid input
        }

        int left = findMax(nums);      // Minimum time is the longest board
        int right = findTotal(nums);   // Maximum time is painting all boards by one painter

        while (left < right) {
            int mid = left + (right - left) / 2;
            int requiredPainters = getRequiredPainters(nums, mid);

            if (requiredPainters <= k) {
                // Try with less time
                right = mid;
            } else {
                // Need more painters => try more time
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * Helper method to find how many painters are needed if each can paint at most maxTime.
     */
    private int getRequiredPainters(int[] nums, int maxTime) {
        int painters = 1;
        int currentLoad = 0;

        for (int length : nums) {
            if (length > maxTime) {
                return Integer.MAX_VALUE; // One board exceeds maxTime, invalid
            }

            if (currentLoad + length <= maxTime) {
                currentLoad += length;
            } else {
                painters++;
                currentLoad = length;
            }
        }
        return painters;
    }

    /**
     * Returns the maximum board length.
     */
    private int findMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    /**
     * Returns the total sum of board lengths.
     */
    private int findTotal(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
