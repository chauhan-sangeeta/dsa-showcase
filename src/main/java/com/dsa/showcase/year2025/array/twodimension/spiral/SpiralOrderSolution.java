package com.dsa.showcase.year2025.array.twodimension.spiral;

import java.util.ArrayList;
import java.util.List;

/*54. Spiral Matrix
Solved
        Medium
Topics
conpanies icon
Companies
        Hint
Given an m x n matrix, return all elements of the matrix in spiral order.



Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
        -100 <= matrix[i][j] <= 100*/
class SpiralOrderSolution {
    public static void main(String[] args) {
        SpiralOrderSolution solution = new SpiralOrderSolution();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println(result); // Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0, left = 0, right = n - 1, bottom = m - 1;//initializing the boundaries

        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            // Move the top boundary down
            top++;

            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            // Move the right boundary left
            right--;

            // Check if we still have rows to traverse
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                // Move the bottom boundary up
                bottom--;
            }

            // Check if we still have columns to traverse
            if (left <= right) {
                // Traverse from bottom to top
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                // Move the left boundary right
                left++;
            }
        }
        return result;
    }
}