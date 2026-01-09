package com.dsa.showcase.year2025.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
/*934. Shortest Bridge
Solved
        Medium
Topics
        Companies
You are given an n x n binary matrix grid where 1 represents land and 0 represents water.

An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.

You may change 0's to 1's to connect the two islands to form one island.

Return the smallest number of 0's you must flip to connect the two islands.



Example 1:

Input: grid = [[0,1],[1,0]]
Output: 1
Example 2:

Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:

Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1


Constraints:

n == grid.length == grid[i].length
2 <= n <= 100
grid[i][j] is either 0 or 1.
There are exactly two islands in grid.*/

class ShortestBridge {
    private static final int[] row = {0, 0, -1, 1};
    private static final int[] col = {1, -1, 0, 0};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;

        // Step 1: Find the first island and mark it (-1), adding boundary cells to the queue
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    found = true;
                    break;
                }
            }
        }

        // Step 2: Expand from the first island using BFS
        return bfs(grid, queue);
    }

    private void dfs(int[][] grid, int r, int c, Queue<int[]> queue) {
        int n = grid.length;
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != 1) {
            return;
        }

        grid[r][c] = -1; // Mark as visited
        queue.add(new int[]{r, c, 0}); // Add boundary cells to the BFS queue

        for (int i = 0; i < 4; i++) {
            dfs(grid, r + row[i], c + col[i], queue);
        }
    }

    private int bfs(int[][] grid, Queue<int[]> queue) {
        int n = grid.length;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1], dist = cell[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + row[i], nc = c + col[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (grid[nr][nc] == 1) {
                        return dist; // Found the shortest bridge to the second island
                    }
                    if (grid[nr][nc] == 0) {
                        grid[nr][nc] = -1; // Mark water as visited
                        queue.add(new int[]{nr, nc, dist + 1});
                    }
                }
            }
        }
        return -1; // Should never reach here
    }
}
