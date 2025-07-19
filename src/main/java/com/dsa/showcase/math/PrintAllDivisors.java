package com.dsa.showcase.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*All divisors of a Number
Difficulty: EasyAccuracy: 46.73%Submissions: 63K+Points: 2Average Time: 10m
Given an integer n, print all the divisors of N in the ascending order.

        Examples:

Input : n = 20
Output: 1 2 4 5 10 20
Explanation: 20 is completely divisible by 1, 2, 4, 5, 10 and 20.
Input: n = 21191
Output: 1 21191
Explanation: As 21191 is a prime number, it has only 2 factors(1 and the number itself).
Constraints:
        1 ≤ n ≤ 109*/
public class PrintAllDivisors {
    public static void main(String[] args) {
        int n = 28; // Example input
        System.out.print("Divisors of " + n + ":");
        print_divisors(n); // Expected output: 1 2 4 7 14 28
    }
    public static void print_divisors(int n) {
        // code here
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                list.add(i);
                if(n/i !=i){
                    list.add(n/i);
                }
            }
        }
        Collections.sort(list);
        for(int num : list){
            System.out.print(" "+num);
        }
    }
}
