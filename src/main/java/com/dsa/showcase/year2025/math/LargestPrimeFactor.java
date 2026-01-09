package com.dsa.showcase.year2025.math;// User function Template for Java

public class LargestPrimeFactor {
    static int largestPrimeFactor(int n) {
        // code here
        int gcd = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (IsPrimeNumber.isPrime(i)) {
                    gcd = Math.max(gcd, i);
                }
                if (n / i != i && IsPrimeNumber.isPrime(n / i))
                    gcd = Math.max(gcd, n / i);
            }
        }
        return gcd == 0 ? n : gcd;
    }

    //time complexity O(sqrt(n)) and space complexity O(1)
    static int largestPrimeFactorUsingSchoolMath(int n) {
        // code here
        int largest = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                largest = i;
                n /= i;
            }
        }
        if (n>2) return n;
        return largest;
    }

    //time complexity O(sqrt(n)) and space complexity O(1)
    static int largestPrimeFactorMostOptimised(int n) {
        // code here
        int largest = 0;
        while (n % 2 == 0) {
            largest = 2;
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                largest = i;
                n /= i;
            }
        }
        if (n > 2) return n;
        return largest;
    }
}