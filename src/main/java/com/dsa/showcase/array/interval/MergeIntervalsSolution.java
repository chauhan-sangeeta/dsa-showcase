package com.dsa.showcase.array.interval;

import java.util.*;
/*56. Merge Intervals
Solved
        Medium
Topics
conpanies icon
Companies
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


        Constraints:

        1 <= intervals.length <= 104
intervals[i].length == 2
        0 <= starti <= endi <= 104*/
public class MergeIntervalsSolution {
    public static void main(String[] args) {
        MergeIntervalsSolution solution = new MergeIntervalsSolution();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] mergedIntervals = solution.merge(intervals);
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
    /**
     * Merges overlapping intervals.
     * @param intervals Array of intervals where each interval is [start, end]
     * @return Merged non-overlapping intervals
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                // No overlap, safely clone interval to avoid mutation
                merged.add(new int[]{interval[0], interval[1]});
            } else {
                // Overlap exists, merge by updating the end time
                int[] last = merged.get(merged.size() - 1);
                last[1] = Math.max(last[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
