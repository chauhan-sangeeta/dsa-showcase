package com.dsa.showcase.bitmanipulation;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        int dividend = 10;
        int divisor = 3;
        System.out.println("Result of " + dividend + " / " + divisor + " = " + divideTwoIntegers.divide(dividend, divisor));

        dividend = 7;
        divisor = -3;
        System.out.println("Result of " + dividend + " / " + divisor + " = " + divideTwoIntegers.divide(dividend, divisor));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = (dividend >= 0) == (divisor >= 0);

        long num = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long quotient = 0;
        while (num >= d) {
            int count = 0;
            while (num >= (d << (count + 1))) count++;
            quotient += (1 << count);
            num -= (d << count);
        }
        if (quotient > Integer.MAX_VALUE) {
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return sign ? (int) quotient : (int) -quotient;

    }
}