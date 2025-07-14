package com.dsa.showcase.recursion.backtrack.hard;

/*2133. Check if Every Row and Column Contains All Numbers
        Solved
Easy
        Topics
conpanies icon
Companies
        Hint
An n x n matrix is valid if every row and every column contains all the integers from 1 to n (inclusive).

Given an n x n integer matrix matrix, return true if the matrix is valid. Otherwise, return false.



Example 1:


Input: matrix = [[1,2,3],[3,1,2],[2,3,1]]
Output: true
Explanation: In this case, n = 3, and every row and column contains the numbers 1, 2, and 3.
Hence, we return true.
Example 2:


Input: matrix = [[1,1,1],[1,2,3],[1,2,3]]
Output: false
Explanation: In this case, n = 3, but the first row and the first column do not contain the numbers 2 or 3.
Hence, we return false.


Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
        1 <= matrix[i][j] <= n*/
public class CheckRowColBox {
    public static void main(String[] args) {
        CheckRowColBox solution = new CheckRowColBox();
        int[][] matrix = {
            {1, 2, 3},
            {3, 1, 2},
            {2, 3, 1}
        };
        boolean isValid = solution.checkValid(matrix);
        System.out.println("Is the matrix valid? " + isValid);
    }
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        boolean[][] rows = new boolean[n][n];
        boolean[][] cols = new boolean[n][n];
        // Initialize tracking arrays
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int c = matrix[row][col];
                int num = c - 1;
                if (rows[row][num] || cols[col][num]) return false;
                rows[row][num] = true;
                cols[col][num] = true;
            }
        }
        return true;
    }
}