package com.dsa.showcase.year2025.array.twodimension.spiral;

/*59. Spiral Matrix II
        Solved
Medium
        Topics
conpanies icon
Companies
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.



        Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]


Constraints:

        1 <= n <= 20*/
class GenerateMatrixSolution {
    public static void main(String[] args) {
        GenerateMatrixSolution solution = new GenerateMatrixSolution();
        int n = 3; // Example input
        int[][] result = solution.generateMatrix(n);
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int val = 1;
        int top = 0, left = 0, right = n - 1, bottom = n - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result[top][i] = val++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result[i][right] = val++;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = val++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[i][left] = val++;
                }
                left++;
            }
        }
        return result;
    }
}