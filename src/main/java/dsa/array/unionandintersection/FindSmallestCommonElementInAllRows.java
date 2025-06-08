package dsa.array.unionandintersection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/*
Code
        Testcase
Testcase
Test Result
1198. Find Smallest Common Element in All Rows
        Solved
Medium
        Topics
conpanies icon
Companies
        Hint
Given an m x n matrix mat where every row is sorted in strictly increasing order, return the smallest common element in all rows.

If there is no common element, return -1.



Example 1:

Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
Output: 5
Example 2:

Input: mat = [[1,2,3],[2,3,4],[2,3,5]]
Output: 2


Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 500
        1 <= mat[i][j] <= 104
mat[i] is sorted in strictly increasing order.*/
class FindSmallestCommonElementInAllRows {
    public static void main(String[] args) {
        int[][] nums = {
            {3, 1, 2, 4, 5},
            {1, 2, 3, 4},
            {3, 4, 5, 6}
        };
        FindSmallestCommonElementInAllRows commonElementInAllRows = new FindSmallestCommonElementInAllRows();
        int result = commonElementInAllRows.smallestCommonElement(nums);
        System.out.println("Smallest common element: " + result);
    }
    //optimal solution for intersection of multiple arrays
    public int smallestCommonElement(int[][] mat) {
        int rowsLen = mat.length;
        int colsLen = mat[0].length;
        // Initialize pointers for each row
        //mainly used to track the current index in each row
        int[] pointers = new int [rowsLen];
        for(int col = 0;col< colsLen; col++){
            int candidate = mat[0][col];
            boolean isCommon = true;
            for(int row =1;row<rowsLen ; row++){
                // Move the pointer for the current row until we find a value >= candidate
                while(pointers[row]<colsLen && mat[row][pointers[row]]<candidate){
                    pointers[row]++;
                }
                // If we reach the end of the row, it means candidate is not common
                if(pointers[row]==colsLen){
                    return -1;
                }
                // Check if the current row's value matches the candidate
                if(mat[row][pointers[row]] != candidate){
                    isCommon = false;
                    break;
                }
            }
            // If the candidate is common across all rows, return it
            if(isCommon){
                return candidate;
            }
        }
        return -1;
    }
    public int smallestCommonElementUsingCountMap(int[][] nums) {
        Map<Integer,Integer> countMap = new TreeMap<>();
        int n=nums.length;
        for (int[] ints : nums) {
            for (int num : ints) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }
        List<Integer> result = new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()){
            if(entry.getValue()==n){
                return entry.getKey();
            }
        }
        return -1;
    }
}