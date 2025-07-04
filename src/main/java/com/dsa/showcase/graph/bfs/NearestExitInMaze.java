package com.dsa.showcase.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*1926. Nearest Exit from Entrance in Maze
Solved
        Medium
Topics
        Companies
Hint
You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.



Example 1:


Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
Output: 1
Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
Initially, you are at the entrance cell [1,2].
        - You can reach [1,0] by moving 2 steps left.
        - You can reach [0,2] by moving 1 step up.
It is impossible to reach [2,3] from the entrance.
        Thus, the nearest exit is [0,2], which is 1 step away.
Example 2:


Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
Output: 2
Explanation: There is 1 exit in this maze at [1,2].
        [1,0] does not count as an exit since it is the entrance cell.
Initially, you are at the entrance cell [1,0].
        - You can reach [1,2] by moving 2 steps right.
Thus, the nearest exit is [1,2], which is 2 steps away.
Example 3:


Input: maze = [[".","+"]], entrance = [0,0]
Output: -1
Explanation: There are no exits in this maze.


        Constraints:

maze.length == m
maze[i].length == n
1 <= m, n <= 100
maze[i][j] is either '.' or '+'.
entrance.length == 2
        0 <= entrancerow < m
0 <= entrancecol < n
entrance will always be an empty cell.*/
class NearestExitInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        //bfs single source shortest path without weight
        int m= maze.length;
        int n= maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{entrance[0],entrance[1],0});
        maze[entrance[0]][entrance[1]]='+';
        int [] row ={0,0,-1,1};
        int []col ={-1,1,0,0};
        boolean passEntrance=false;
        while(!queue.isEmpty()){
            int[]cell = queue.remove();
            int r = cell[0];
            int c = cell[1];
            int dist= cell[2];
            passEntrance=true;
            for(int i=0;i<4;i++){
                int newRow = r+row[i];
                int newCol= c+col[i];
                if(isValid(newRow,newCol,m,n) && maze[newRow][newCol]=='.'){
                    maze[newRow][newCol]='+';
                    queue.add(new int[]{newRow,newCol,dist+1});
                    if(isBoundry(newRow,newCol,m,n)){
                        return dist+1;
                    }
                }
            }
        }
        return -1;
    }

    public boolean isValid(int r, int c, int m,int n){
        return r>=0 && r<m && c>=0 && c<n;
    }
    public boolean isBoundry(int r, int c,int m, int n){
        return r==0 || r==m-1 || c==0 || c==n-1;
    }
}   