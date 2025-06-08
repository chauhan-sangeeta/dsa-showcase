package dsa.array.binarysearch.answerspace;

import java.util.Arrays;
/*Aggressive Cows
Difficulty: MediumAccuracy: 59.57%Submissions: 134K+Points: 4Average Time: 30m
You are given an array with unique elements of stalls[], which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. Your task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.

        Examples :

Input: stalls[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at stalls[0],
the second cow can be placed at stalls[2] and
the third cow can be placed at stalls[3].
The minimum distance between cows, in this case, is 3, which also is the largest among all possible ways.
        Input: stalls[] = [10, 1, 2, 7, 5], k = 3
Output: 4
Explanation: The first cow can be placed at stalls[0],
the second cow can be placed at stalls[1] and
the third cow can be placed at stalls[4].
The minimum distance between cows, in this case, is 4, which also is the largest among all possible ways.
        Input: stalls[] = [2, 12, 11, 3, 26, 7], k = 5
Output: 1
Explanation: Each cow can be placed in any of the stalls, as the no. of stalls are exactly equal to the number of cows.
The minimum distance between cows, in this case, is 1, which also is the largest among all possible ways.
        Constraints:
        2 <= stalls.size() <= 106
        0 <= stalls[i] <= 108
        2 <= k <= stalls.size()*/
class AggressiveCows {
    public  void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9};
        int k = 3;
        AggressiveCows solution = new AggressiveCows();
         // Call the method to find the largest minimum distance
         // between cows placed in the stalls
        int result = solution.aggressiveCows(stalls, k);
        System.out.println("The largest minimum distance between cows is: " + result);
    }

    /**
     * Finds the largest minimum distance between any two cows placed in the stalls.
     * 
     * @param stalls - array representing stall positions
     * @param k - number of cows to place
     * @return the largest minimum distance possible between any two cows
     */
    public  int aggressiveCows(int[] stalls, int k) {
        if (stalls == null || stalls.length == 0 || k <= 0) {
            return 0;  // Edge cases: no stalls or invalid number of cows
        }

        Arrays.sort(stalls);
        int n = stalls.length;

        // Minimum possible distance is 1 (since stall positions are integers)
        int left = 1;

        // Maximum possible distance is difference between last and first stall after sorting
        int right = stalls[n - 1] - stalls[0];

        int maxMinDistance = 0;

        // Binary search to find the maximum minimum distance
        while (left <= right) {
            int midDistance = left + (right - left) / 2;

            if (canPlaceCows(stalls, k, midDistance)) {
                // If it is possible to place all cows with at least midDistance apart,
                // try for a bigger distance
                maxMinDistance = midDistance;
                left = midDistance + 1;
            } else {
                // If not possible, try smaller distance
                right = midDistance - 1;
            }
        }
        return maxMinDistance;
    }

    /**
     * Helper method to check if cows can be placed in stalls such that minimum distance 
     * between any two cows is at least 'distance'.
     * 
     * @param stalls - sorted array of stall positions
     * @param cows - number of cows to place
     * @param distance - minimum required distance between cows
     * @return true if possible to place all cows with given distance, else false
     */
    private boolean canPlaceCows(int[] stalls, int cows, int distance) {
        int count = 1;  // Place first cow in the first stall
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= distance) {
                count++;
                lastPosition = stalls[i];
                if (count == cows) {
                    return true;  // All cows placed successfully
                }
            }
        }
        return false;  // Not all cows could be placed
    }
}
