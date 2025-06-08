package dsa.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
/*1091. Shortest Path in Binary Matrix
        Solved
Medium
        Topics
Companies
        Hint
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.



        Example 1:


Input: grid = [[0,1],[1,0]]
Output: 2
Example 2:


Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1


Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1*/
class ShortestPath {

    private static final int[] row = new int[]{-1, 1, 0, 0, 1, -1, -1, 1};
    private static final int[] col = new int[]{0, 0, -1, 1, 1, -1, 1, -1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length;

        if (grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
         // Mark the cell as visited
            grid[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1], dist = cell[2];

            // If we've reached the bottom-right corner, return the distance
            if (r == n-1 && c == n - 1) {
                return dist;
            }

            // Explore all 8 directions
            for (int i = 0; i < 8; i++) {
                int nr = r + row[i];
                int nc = c + col[i];

                if (nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc] == 0) {
                    queue.offer(new int[]{nr, nc, dist + 1});
                    grid[nr][nc] = 1; // Mark as visited immediately to prevent duplicate processing
                }
            }
        }
        return -1;
    }

}

