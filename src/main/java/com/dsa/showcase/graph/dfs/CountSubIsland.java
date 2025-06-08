package com.dsa.showcase.graph.dfs;
/*1905. Count Sub Islands
        Solved
Medium
        Topics
Companies
        Hint
You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.

An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.

Return the number of islands in grid2 that are considered sub-islands.



        Example 1:


Input: grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
Output: 3
Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
The 1s colored red in grid2 are those considered to be part of a sub-island. There are three sub-islands.
        Example 2:


Input: grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
Output: 2
Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
The 1s colored red in grid2 are those considered to be part of a sub-island. There are two sub-islands.


        Constraints:

m == grid1.length == grid2.length
n == grid1[i].length == grid2[i].length
1 <= m, n <= 500
grid1[i][j] and grid2[i][j] are either 0 or 1.*/
class CountSubIsland {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        if (grid1 == null || grid2 == null || grid1.length == 0 || grid2.length == 0) {
            return 0;
        }

        int rows = grid1.length, cols = grid1[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int subIslandCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid2[r][c] == 1 && !visited[r][c]) {
                    if (isSubIsland(grid1, grid2, visited, r, c)) {
                        subIslandCount++;
                    }
                }
            }
        }
        return subIslandCount;
    }

    private boolean isSubIsland(int[][] grid1, int[][] grid2, boolean[][] visited, int r, int c) {
        if (!isValid(grid2, r, c) || visited[r][c] || grid2[r][c] == 0) {
            return true;
        }

        visited[r][c] = true;
        boolean isSubIsland = (grid1[r][c] == 1); // Check if this cell exists in grid1

        for (int[] dir : DIRECTIONS) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];

            if (!isSubIsland(grid1, grid2, visited, newRow, newCol)) {
                isSubIsland = false; // If any part is not a sub-island, the entire island fails
            }
        }

        return isSubIsland;
    }

    private boolean isValid(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
