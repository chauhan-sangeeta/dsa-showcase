package com.dsa.showcase.year2025.array.binarysearch.answerspace.hard;
/*774. Minimize Max Distance to Gas Station
Solved
        Hard
Topics
conpanies icon
Companies
        Hint
You are given an integer array stations that represents the positions of the gas stations on the x-axis. You are also given an integer k.

You should add k new gas stations. You can add the stations anywhere on the x-axis, and not necessarily on an integer position.

        Let penalty() be the maximum distance between adjacent gas stations after adding the k new stations.

Return the smallest possible value of penalty(). Answers within 10-6 of the actual answer will be accepted.



        Example 1:

Input: stations = [1,2,3,4,5,6,7,8,9,10], k = 9
Output: 0.50000
Example 2:

Input: stations = [23,24,36,39,46,56,57,65,84,98], k = 1
Output: 14.00000


Constraints:

        10 <= stations.length <= 2000
        0 <= stations[i] <= 108
stations is sorted in a strictly increasing order.
        1 <= k <= 106*/
class MinMaxGasDistance {
    public static void main(String[] args) {
        int[] stations = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 9;
        MinMaxGasDistance solution = new MinMaxGasDistance();
        double result = solution.minmaxGasDist(stations, k);
        System.out.printf("The smallest possible value of penalty is: %.5f%n", result);
    }
    public double minmaxGasDist(int[] stations, int k) {
        int n = stations.length;

        double left = 0.0;  // minimum possible distance
        double right = stations[n - 1] - stations[0];  // maximum possible distance between any two

        double epsilon = 1e-6;  // required precision

        // Binary search on distance
        while (right - left > epsilon) {
            double mid = (left + right) / 2.0;

            int requiredStations = countRequiredStations(stations, mid);

            if (requiredStations<= k) {
                 right = mid;
            } else {
                left = mid; 
            }
        }

        return left;
    }

    // Helper method: how many stations are needed if we want max gap ≤ distance
    private int countRequiredStations(int[] stations, double distance) {
        int count = 0;

        for (int i = 1; i < stations.length; i++) {
            double gap = stations[i] - stations[i - 1];
            count += (int) (gap / distance);
        }

        return count;
    }
}
