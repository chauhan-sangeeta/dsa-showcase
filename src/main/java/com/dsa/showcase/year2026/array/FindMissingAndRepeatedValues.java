package com.dsa.showcase.year2026.array;
/*2965. Find Missing and Repeated Values
        Solved
Easy
        Topics
premium lock icon
        Companies
You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.

Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.



        Example 1:

Input: grid = [[1,3],[2,2]]
Output: [2,4]
Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].*/
public class FindMissingAndRepeatedValues {
    public static void main(String[] args) {
        FindMissingAndRepeatedValues solution = new FindMissingAndRepeatedValues();
        int[][] grid = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 1} // Example with repeated value '1'
        };
        int[] result = solution.findMissingAndRepeatedValues(grid);
        System.out.println("Repeated: " + result[0] + ", Missing: " + result[1]);
    }
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m*n;
        long expectedSum = (long) ((size*(size+1))/2);
        long expectedSqSum =  (long) ((size*(size+1)*(2L*size+1))/6);
        long actualSum =0;
        long actualSqSum=0;
        for(int i =0 ;i< m;i++){
            for(int j = 0; j< n;j++){
                actualSum+=grid[i][j];
                actualSqSum+=(long)(grid[i][j]*grid[i][j]);
            }
        }
        // A is X-Y and B is X+Y
        long A = actualSum - expectedSum;
        long B = (actualSqSum-expectedSqSum)/A;

        int repeating = (int)((A+B)/2);
        int missing = (int)(repeating - A);
         return new int []{repeating, missing};

    }
}