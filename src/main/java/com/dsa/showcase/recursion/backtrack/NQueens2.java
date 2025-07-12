package com.dsa.showcase.recursion.backtrack;

import java.util.List;

/*52. N-Queens II
Solved
        Hard
Topics
conpanies icon
Companies
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.



Example 1:


Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1


Constraints:

        1 <= n <= 9*/
public class NQueens2 {
    public static void main(String[] args) {
        NQueens2 solution = new NQueens2();
        int n = 4;
        System.out.println("Distinct solutions for " + n + "-Queens: " + solution.totalNQueens(n));
    }
    public int totalNQueens(int n) {
        int[] columns = new int[n];
        //Arrays.fill(columns, -1);
        return backtrack(0, n, columns);
    }

    public int backtrack(int row, int n, int[] columns) {
        int count = 0;
        if (row == n) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(row, i, columns)) {
                columns[row] = i;
                count += backtrack(row + 1, n, columns);
                //columns[row]=-1;
            }
        }
        return count;
    }

    public boolean isValid(int row, int col, int[] columns) {
        for (int i = 0; i < row; i++) {
            int j = columns[i];
            //vertical check
            if (col == j) return false;
            //diagonal check
            //if(row-i == col-j) return false;
            if (Math.abs(row - i) == Math.abs(col - j)) return false;
        }
        return true;
    }
}
