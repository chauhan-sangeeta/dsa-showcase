package com.dsa.showcase.array;

import java.util.ArrayList;
import java.util.List;
/*119. Pascal's Triangle II
Solved
        Easy
Topics
conpanies icon
Companies
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:




Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]


Constraints:

        0 <= rowIndex <= 33


Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?*/
public class GetPascalTriangleRow {
    public static void main(String[] args) {
        GetPascalTriangleRow solution = new GetPascalTriangleRow();
        int rowIndex = 3; // Example input
        List<Integer> result = solution.getRow(rowIndex);
        System.out.println("Row " + rowIndex + " of Pascal's Triangle: " + result);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> prevList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        prevList = list;

        for (int i = 1; i <= rowIndex; i++) {
            list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < prevList.size(); j++) {
                list.add(prevList.get(j - 1) + prevList.get(j));
            }
            list.add(1);
            prevList = list;
        }
        return list;
    }
}