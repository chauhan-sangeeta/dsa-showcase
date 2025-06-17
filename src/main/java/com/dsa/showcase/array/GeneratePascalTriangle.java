package com.dsa.showcase.array;

import java.util.ArrayList;
import java.util.List;
/*118. Pascal's Triangle
Solved
        Easy
Topics
conpanies icon
Companies
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:




Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]


Constraints:

        1 <= numRows <= 30*/
public class GeneratePascalTriangle {
    public static void main(String[] args) {
        GeneratePascalTriangle solution = new GeneratePascalTriangle();
        int numRows = 5; // Example input
        List<List<Integer>> result = solution.generate(numRows);
        System.out.println("Pascal's Triangle with " + numRows + " rows:");
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);

        for (int i = 1; i < numRows; i++) {
            list = new ArrayList<>();
            List<Integer> prevList = result.get(result.size() - 1);
            list.add(1);
            for (int j = 1; j < prevList.size(); j++) {
                list.add(prevList.get(j - 1) + prevList.get(j));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }
}