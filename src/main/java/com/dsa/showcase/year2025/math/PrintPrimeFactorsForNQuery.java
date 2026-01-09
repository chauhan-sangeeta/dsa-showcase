package com.dsa.showcase.year2025.math;// User function Template for Java

import java.util.ArrayList;
import java.util.List;

public class PrintPrimeFactorsForNQuery {
    // You must implement this function
    static int n = 200001;
    static int[] prime = new int[n];

    public static void main(String[] args) {
        sieve(); // Precompute prime factors for all numbers up to n
        int[] queries = {10, 15, 20}; // Example queries
        for (int query : queries) {
            List<Integer> factors = findPrimeFactors(query);
            System.out.println("Prime factors of " + query + ": " + factors);
        }
    }

    static void sieve() {
        for (int i = 2; i < n; i++) {
            prime[i] = i;
        }
        for (int i = 2; i * i < n; i++) {
            if (prime[i] == i) {
                for (int j = i * i; j < n; j += i) {
                    if (prime[j] == j)
                        prime[j] = i;
                }
            }
        }
    }

    static List<Integer> findPrimeFactors(int N) {
        List<Integer> result = new ArrayList<>();
        while (N > 1) {
            result.add(prime[N]);
            N /= prime[N];
        }
        return result;
    }
}
