package com.dsa.showcase.array;

/*2965. Find Missing and Repeated Values
        Solved
Easy
        Topics
conpanies icon
Companies
You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.

Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.



        Example 1:

Input: grid = [[1,3],[2,2]]
Output: [2,4]
Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].
Example 2:

Input: grid = [[9,1,7],[8,9,2],[3,4,6]]
Output: [9,5]
Explanation: Number 9 is repeated and number 5 is missing so the answer is [9,5].


Constraints:

        2 <= n == grid.length == grid[i].length <= 50
        1 <= grid[i][j] <= n * n
For all x that 1 <= x <= n * n there is exactly one x that is not equal to any of the grid members.
For all x that 1 <= x <= n * n there is exactly one x that is equal to exactly two of the grid members.
For all x that 1 <= x <= n * n except two of them there is exactly one pair of i, j that 0 <= i, j <= n - 1 and grid[i][j] == x.*/
class FindMissingAndRepeatedValuesSolution {
    public static void main(String[] args) {
        FindMissingAndRepeatedValuesSolution solution = new FindMissingAndRepeatedValuesSolution();
        int[][] grid = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 1} // Example with repeated value '1'
        };
        int[] result = solution.findMissingAndRepeatedValues(grid);
        System.out.println("Repeated: " + result[0] + ", Missing: " + result[1]);

    }

    public int[] findMissingAndRepeatedValuesUsingHashTable(int[][] grid) {
        int n = grid.length * grid.length;
        int[] hashtable = new int[n + 1];

        // Initialize the hashtable
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                hashtable[grid[i][j]]++;
            }
        }
        int repeated = -1;
        int missing = -1;
        for (int i = 1; i <= n; i++) {
            // Check for missing and repeated values
            if (hashtable[i] == 0) {
                missing = i;
            }
            // Check for repeated values
            if (hashtable[i] == 2) {
                repeated = i;
            }
        }

        return new int[]{repeated, missing};

    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n = grid.length * grid.length;
        long xSum = 0L;
        long xSumSquare = 0L;
        // Calculate the expected sums for 1 to n
        long ySum = (long) (n * (n + 1)) / 2;
        // Calculate the expected sum of squares for 1 to n
        long ySumSquare = (long) (n * (n + 1) * (2 * n + 1)) / 6;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // Calculate the sum and sum of squares of the elements in the grid
                xSum += grid[i][j];
                // Calculate the sum of squares
                xSumSquare += (grid[i][j] * grid[i][j]);
            }
        }
        // Calculate the difference between the actual sums and expected sums
        long sumDiff = xSum - ySum;
        // Calculate the difference between the actual sum of squares and expected sum of squares
        long sumSquareDiff = xSumSquare - ySumSquare;

        // Using the equations:
        int repeated = (int) (sumSquareDiff / sumDiff + sumDiff) / 2;
        int missing = (int) (sumSquareDiff / sumDiff - sumDiff) / 2;

        return new int[]{repeated, missing};


    }
}