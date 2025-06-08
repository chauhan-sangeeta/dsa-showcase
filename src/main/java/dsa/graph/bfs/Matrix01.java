package dsa.graph.bfs;

import java.util.*;

/*542. 01 Matrix
        Solved
Medium
        Topics
Companies
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two cells sharing a common edge is 1.



Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]


Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
        1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.


Note: This question is the same as 1765: https://leetcode.com/problems/map-of-highest-peak/*/
class Matrix01 {
    private static final int[] row = new int[]{-1, 1, 0, 0};
    private static final int[] col = new int[]{0, 0, -1, 1};

    public static void main(String[] args){
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        Matrix01 matrix01 = new Matrix01();
        System.out.println(Arrays.deepToString(matrix01.updateMatrix(mat)));
    }

    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n= mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
         for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i,j,0});
                    mat[i][j]=-1;
                }
            }
        }
        int [][] ans = new int[m][n];

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1], dist = cell[2];

            // Explore all 4 directions
            for (int i = 0; i < 4; i++) {
                int nr = r + row[i];
                int nc = c + col[i];

                if (nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc] == 1) {
                    queue.offer(new int[]{nr, nc, dist + 1});
                    mat[nr][nc] = -1; 
                    ans[nr][nc] = dist+1;
                }
            }
        }
        return ans;
    }
}