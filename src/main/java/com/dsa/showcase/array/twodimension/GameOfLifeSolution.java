package com.dsa.showcase.array.twodimension;
/*289. Game of Life
        Solved
Medium
        Topics
conpanies icon
Companies
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board. In this process, births and deaths occur simultaneously.

Given the current state of the board, update the board to reflect its next state.

Note that you do not need to return anything.



        Example 1:


Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
Example 2:


Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]


Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.


Follow up:

Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?*/
class GameOfLifeSolution {
    public static void main(String[] args) {
        GameOfLifeSolution solution = new GameOfLifeSolution();
        int[][] board = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };
        solution.gameOfLife(board);
        for (int[] row : board) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        // 8 possible directions (neighbors)
        int[][] directions = {
            {-1, 0},  {1, 0},   // Up, Down
            {0, -1},  {0, 1},   // Left, Right
            {-1, -1}, {-1, 1},  // Top-Left, Top-Right
            {1, -1},  {1, 1}    // Bottom-Left, Bottom-Right
        };

        // First pass: mark transitions using temporary markers
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = 0;

                // Count live neighbors
                for (int[] dir : directions) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];

                    if (ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
                        // Use abs() to count original state (1 or -1 means originally alive)
                        if (Math.abs(board[ni][nj]) == 1) {
                            liveNeighbors++;
                        }
                    }
                }

                // Apply Game of Life rules (mark changes in-place)
                if (board[i][j] == 1) {
                    // Live cell with <2 or >3 live neighbors → dies
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = -1; // alive → dead
                    }
                } else if (board[i][j] == 0) {
                    // Dead cell with exactly 3 live neighbors → becomes alive
                    if (liveNeighbors == 3) {
                        board[i][j] = 2; // dead → alive
                    }
                }
            }
        }

        // Second pass: finalize the state transitions
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1; // alive
                } else {
                    board[i][j] = 0; // dead
                }
            }
        }
    }
}
