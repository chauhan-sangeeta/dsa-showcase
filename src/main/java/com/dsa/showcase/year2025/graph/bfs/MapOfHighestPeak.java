package com.dsa.showcase.year2025.graph.bfs;

/*
1765. Map of Highest Peak
Solved
        Medium
Topics
        Companies
Hint
You are given an integer matrix isWater of size m x n that represents a map of land and water cells.

If isWater[i][j] == 0, cell (i, j) is a land cell.
If isWater[i][j] == 1, cell (i, j) is a water cell.
You must assign each cell a height in a way that follows these rules:

The height of each cell must be non-negative.
If the cell is a water cell, its height must be 0.
Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
Find an assignment of heights such that the maximum height in the matrix is maximized.

Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.



Example 1:



Input: isWater = [[0,1],[0,0]]
Output: [[1,0],[2,1]]
Explanation: The image shows the assigned heights of each cell.
The blue cell is the water cell, and the green cells are the land cells.
Example 2:



Input: isWater = [[0,0,1],[1,0,0],[0,0,0]]
Output: [[1,1,0],[0,1,1],[1,2,2]]
Explanation: A height of 2 is the maximum possible height of any assignment.
Any height assignment that has a maximum height of 2 while still meeting the rules will also be accepted.


Constraints:

m == isWater.length
n == isWater[i].length
1 <= m, n <= 1000
isWater[i][j] is 0 or 1.
There is at least one water cell.*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {
        public static void main(String[] args){
            int[][] grid = {{0,0,1},{1,0,0},{0,0,0}};
            MapOfHighestPeak mapOfHighestPeak = new MapOfHighestPeak();
            System.out.println(Arrays.deepToString(mapOfHighestPeak.highestPeak(grid)));
        }
        public int[][] highestPeak(int[][] grid) {
            //bfs
            Queue<int[]> queue = new LinkedList<>();
            int m= grid.length;
            int n= grid[0].length;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==1){
                        queue.add(new int[]{i,j,0});
                    }
                }
            }
            int[][] ans = new int[m][n];
            int[] row = {1,0,-1,0};     // go in all 4 directions
            int[] col = {0,1,0,-1};
            //bfs
            while(!queue.isEmpty()){
                int size= queue.size();
                while(size-->0){
                    int [] node = queue.remove();
                    int sr=node[0];
                    int sc=node[1];
                    int dist=node[2];
                    for(int i=0;i<4;i++){
                        int newRow= sr+row[i];
                        int newCol = sc+col[i];
                        if(isValid(newRow,newCol,m,n) &&grid[newRow][newCol]==0 && dist+1>ans[newRow][newCol]){
                            ans[newRow][newCol] = dist+1;
                            grid[newRow][newCol]=1;
                            queue.add(new int[]{newRow,newCol,ans[newRow][newCol]});
                        }
                    }
                }
            }
            return ans;
        }
        public boolean isValid(int r, int c, int m, int n) {
            return r >= 0 && r < m && c >= 0 && c < n;
        }
}
