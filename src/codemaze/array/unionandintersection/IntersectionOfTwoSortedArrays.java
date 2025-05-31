package codemaze.array.unionandintersection;

import java.util.ArrayList;

class IntersectionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 6};
        int[] b = {2, 3, 5, 7};

        IntersectionOfTwoSortedArrays solution = new IntersectionOfTwoSortedArrays();
        ArrayList<Integer> result = solution.intersection(a, b);
        System.out.println("Intersection of two sorted arrays: " + result);
    }

    // Function to find the intersection of two arrays
    ArrayList<Integer> intersection(int[] a, int[] b) {
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
                i++;
            } else {
                j++;
            }
        }

        return list;
    }

}