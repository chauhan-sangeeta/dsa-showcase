package com.dsa.showcase.year2025.recursion.backtrack;

import java.util.ArrayList;

/*Rat in a Maze Problem - I
Difficulty: MediumAccuracy: 35.75%Submissions: 351K+Points: 4Average Time: 25m
Consider a rat placed at position (0, 0) in an n x n square matrix mat[][]. The rat's goal is to reach the destination at position (n-1, n-1). The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).

The matrix contains only two possible values:

        0: A blocked cell through which the rat cannot travel.
1: A free cell that the rat can pass through.
Your task is to find all possible paths the rat can take to reach the destination, starting from (0, 0) and ending at (n-1, n-1), under the condition that the rat cannot revisit any cell along the same path. Furthermore, the rat can only move to adjacent cells that are within the bounds of the matrix and not blocked.
If no path exists, return an empty list.

        Note: Return the final result vector in lexicographically smallest order.

Examples:

Input: mat[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
Output: ["DDRDRR", "DRDDRR"]
Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.
        Input: mat[][] = [[1, 0], [1, 0]]
Output: []
Explanation: No path exists as the destination cell is blocked.
        Input: mat = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
Output: ["DDRR", "RRDD"]
Explanation: The rat has two possible paths to reach the destination: 1. "DDRR" 2. "RRDD", These are returned in lexicographically sorted order.
        Constraints:
        2 ≤ mat.size() ≤ 5
        0 ≤ mat[i][j] ≤ 1*/
public class RateInMaze {
    public static void main(String[] args) {
        RateInMaze rateInMaze = new RateInMaze();
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        ArrayList<String> paths = rateInMaze.ratInMaze(maze);
        System.out.println(paths); // Output: [DDRDRR, DRDDRR]
    }

    // Function to find all possible paths
    ArrayList<String> result = new ArrayList<>();
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    char[] symbol = {'R', 'D', 'U', 'L'};

    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n = maze.length;
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) return result;
        boolean[][] visited = new boolean[n][n];
        backtrack(0, 0, maze, n, new StringBuilder(), visited);
        return result;

    }

    public void backtrack(int row, int col, int[][] maze, int n, StringBuilder sb, boolean[][] visited) {
        if (row == n - 1 && col == n - 1) {
            result.add(new String(sb));
            return;
        }
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int[] dir = directions[i];
            char c = symbol[i];
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (isValid(newRow, newCol, n) && maze[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                sb.append(c);
                backtrack(newRow, newCol, maze, n, sb, visited);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        visited[row][col] = false;

    }

    public boolean isValid(int i, int j, int n) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }
}