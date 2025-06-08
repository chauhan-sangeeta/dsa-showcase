package dsa.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*994. Rotting Oranges
Solved
        Medium
Topics
        Companies
You are given an m x n grid where each cell can have one of three values:

        0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
        Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.



Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
        Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.*/
class RottingOranges {
    public static void main(String[] args){
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        RottingOranges rottingOranges = new RottingOranges();
        System.out.println(rottingOranges.orangesRotting(grid));
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> queue =new LinkedList<>();
        int[][] directions=new int [][]{{0,-1},{0,1},{-1,0},{1,0}};
        int countFresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)
                    queue.add(new int[]{i,j});
                else if(grid[i][j]==1)
                    countFresh++;
            }
        }
        if(countFresh==0){
            return 0;
        }
        int count=-1;
        while(!queue.isEmpty()){
            count++;
            int size=queue.size();
            while(size-->0){
            int [] cell=queue.remove();
            for(int [] dir:directions){
                int row=cell[0]+dir[0];
                int col=cell[1]+dir[1];
                if(isValid(row,col,m,n)&& grid[row][col]==1){
                        countFresh--;
                        queue.add(new int[]{row,col});
                        grid[row][col]=2;
                    }

                }
                }
            }
        if(countFresh==0)
            return count;
        return -1;
    }
    public boolean isValid(int row,int col, int m, int n){
        return row>=0 && row<m&& col>=0 && col<n ;
    }
}