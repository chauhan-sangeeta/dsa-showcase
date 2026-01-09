package com.dsa.showcase.year2025.math;

import java.util.Arrays;
/*204. Count Primes
Solved
        Medium
Topics
conpanies icon
Companies
        Hint
Given an integer n, return the number of prime numbers that are strictly less than n.



        Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0


Constraints:

        0 <= n <= 5 * 106*/
public class CountPrimes {
    public static void main(String[] args) {
        CountPrimes solution = new CountPrimes();
        int n = 10; // Example input
        int result = solution.countPrimes(n);
        System.out.println("Number of primes less than " + n + ": " + result); // Expected output: 4
    }
    //sieve of eratosthenes
    //time complexity O(n+n log log n+n) and space complexity O(n)
    public int countPrimes(int n) {
        if(n<=1){
            return 0;
        }
        int [] prime  = new int [n];
        Arrays.fill(prime,1);

        int count =0;
        for (int i=2;i*i<n;i++){
            if(prime[i]==1){
                for(int j=i*i;j<n;j+=i){
                    prime[j]=0;
                }
            }
        }
        //count prime less than n
        for(int i=2;i<n;i++){
            if(prime[i]==1){
                count++;
            }
        }
        return count;
    }
}