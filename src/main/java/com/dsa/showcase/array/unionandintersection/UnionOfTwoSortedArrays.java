package com.dsa.showcase.array.unionandintersection;

import java.util.ArrayList;

class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 6};
        int[] b = {2, 3, 5, 7};

        ArrayList<Integer> result = findUnion(a, b);
        System.out.println("Union of two sorted arrays: " + result);
    }
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        int i = 0, j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int lastAdded = Integer.MIN_VALUE;

        while (i < a.length && j < b.length) {
            // Skip duplicates within array A
            while (i < a.length && a[i] == lastAdded) i++;
            // Skip duplicates within array B
            while (j < b.length && j < b.length && b[j] == lastAdded) j++;

            if (i >= a.length || j >= b.length) break;

            if (a[i] == b[j]) {
                list.add(a[i]);
                lastAdded = a[i];
                i++;
                j++;
            } else if (a[i] < b[j]) {
                list.add(a[i]);
                lastAdded = a[i];
                i++;
            } else {
                list.add(b[j]);
                lastAdded = b[j];
                j++;
            }
        }

        // Add remaining elements of A
        while (i < a.length) {
            if (a[i] != lastAdded) {
                list.add(a[i]);
                lastAdded = a[i];
            }
            i++;
        }

        // Add remaining elements of B
        while (j < b.length) {
            if (b[j] != lastAdded) {
                list.add(b[j]);
                lastAdded = b[j];
            }
            j++;
        }

        return list;
    }
}
