package com.dsa.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*1162. As Far from Land as Possible
Solved
        Medium
Topics
        Companies
Hint
Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.



Example 1:


Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.
Example 2:


Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
Output: 4
Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.


Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1*/
public class AsFarfromLandAsPossible {
        public int maxDistance(int[][] grid) {
            //bfs
            Queue<int[]> queue = new LinkedList<>();
            int n= grid.length;
            int water=0;
            int land=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==1){
                        queue.add(new int[]{i,j});
                        land++;
                    }else{
                        water++;
                    }
                }
            }
            if(land==0 || water==0) return -1;

            int ans=0;
            int[] row = {1,0,-1,0};     // go in all 4 directions
            int[] col = {0,1,0,-1};
            //bfs
            while(!queue.isEmpty()){
                int size= queue.size();
                while(size-->0){
                    int [] node = queue.remove();
                    int sr=node[0];
                    int sc=node[1];
                    for(int i=0;i<4;i++){
                        int newRow= sr+row[i];
                        int newCol = sc+col[i];
                        if(isValid(newRow,newCol,n) &&grid[newRow][newCol]==0){
                            grid[newRow][newCol] = 1;
                            queue.add(new int[]{newRow,newCol});
                        }
                    }
                }
                ans++;
            }
            return ans-1;
        }
        public boolean isValid(int r, int c, int n){
            return r>=0 && r<n && c>=0 && c<n;
        }
}
