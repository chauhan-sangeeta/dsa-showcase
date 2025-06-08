package dsa.array;
/*1351. Count Negative Numbers in a Sorted Matrix
        Solved
Easy
        Topics
conpanies icon
Companies
        Hint
Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.



        Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
        Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
        -100 <= grid[i][j] <= 100


Follow up: Could you find an O(n + m) solution?*/
class CountNegativeNumbersInSortedMatrix {
    public static void main(String[] args) {
        int[][] grid = {
            {4, 3, 2, -1},
            {3, 2, 1, -1},
            {1, 1, -1, -2},
            {-1, -1, -2, -3}
        };
        CountNegativeNumbersInSortedMatrix countNegatives = new CountNegativeNumbersInSortedMatrix();
        int result = countNegatives.countNegatives(grid);
        System.out.println("Count of negative numbers: " + result);
    }
    //can be solved using binary search in each row
    public int countNegatives(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int i=0;
        int j=n-1;
        int count=0;
        while(i<m && j>=0){
            if(grid[i][j]<0){
                count+=m-i;
                j--;
            }
            else{
                i++;
            }
        }
        return count;
    }
}