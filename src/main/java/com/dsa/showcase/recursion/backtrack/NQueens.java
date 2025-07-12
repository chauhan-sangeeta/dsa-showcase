package com.dsa.showcase.recursion.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*51. N-Queens
        Solved
Hard
        Topics
conpanies icon
Companies
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.



Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]


Constraints:

        1 <= n <= 9*/
public class NQueens {
    public static void main(String[] args) {
        NQueens solution = new NQueens();
        int n = 4;
        List<List<String>> result = solution.solveNQueens(n);
        System.out.println("Distinct solutions for " + n + "-Queens: " + result);
    }
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[] columns = new int[n];
        //Arrays.fill(columns, -1);
        backtrack(0, n, columns);
        return result;
    }

    public void backtrack(int row, int n, int[] columns) {
        if (row == n) {
            generateBoard(n, columns);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(row, i, columns)) {
                columns[row] = i;
                backtrack(row + 1, n, columns);
                //columns[row]=-1;
            }
        }
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

    public void generateBoard(int n, int[] columns) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] crr = new char[n];
            Arrays.fill(crr, '.');
            crr[columns[i]] = 'Q';
            temp.add(new String(crr));
        }
        result.add(temp);
    }
}