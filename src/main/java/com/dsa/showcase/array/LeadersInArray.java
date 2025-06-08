package com.dsa.showcase.array;

import java.util.ArrayList;
/*Array Leaders
Difficulty: EasyAccuracy: 29.94%Submissions: 877K+Points: 2Average Time: 15m
You are given an array arr of positive integers. Your task is to find all the leaders in the array. An element is considered a leader if it is greater than or equal to all elements to its right. The rightmost element is always a leader.

        Examples:

Input: arr = [16, 17, 4, 3, 5, 2]
Output: [17, 5, 2]
Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.*/
class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        LeadersInArray leadersInArray = new LeadersInArray();
        ArrayList<Integer> leaders = leadersInArray.leaders(arr);
        System.out.println("Leaders in the array: " + leaders);
    }
    public ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer>  result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        // code here
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>=max){
                result.add(0,arr[i]);
                max=arr[i];
            }   
        }
        return result;
    }
}
