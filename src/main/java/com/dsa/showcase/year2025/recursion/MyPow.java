package com.dsa.showcase.year2025.recursion;
/*50. Pow(x, n)
Solved
        Medium
Topics
conpanies icon
Companies
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).



Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25


Constraints:

        -100.0 < x < 100.0
        -231 <= n <= 231-1
n is an integer.
Either x is not zero or n > 0.
        -104 <= xn <= 104*/
public class MyPow {
    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        System.out.println(myPow.myPow(2.0, 10)); // Output: 1024.0
        System.out.println(myPow.myPow(2.1, 3));  // Output: 9.261
        System.out.println(myPow.myPow(2.0, -2)); // Output: 0.25
        System.out.println(myPow.myPowIterative(2.0, -2)); // Output: 0.25
    }
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return pow(x, N);
    }

    public double pow(double x, long n) {
        if(n==0){
            return 1.0;
        }
        double temp=pow(x,n/2);
        temp*=temp; //multiple two half
        if(n%2==1){
            temp*=x;
        }
        return temp;
    }

    //time complexity O(log n) and space complexity O(1)
    public double myPowIterative(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double result = 1.0;
        while (N > 0) {
            if (N % 2 == 1) {
                result *= x;
            }
            x *= x;
            N /= 2;
        }
        return result;
    }
}