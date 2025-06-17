package com.dsa.showcase.array.twodimension.spiral;
import java.util.Arrays;

public class SpiralMatrixSolution {
    public static void main(String[] args) {
        SpiralMatrixSolution solution = new SpiralMatrixSolution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        int[][] result = solution.spiralMatrix(2, 2, head);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], -1);
        }
        int top = 0, left = 0, right = n - 1, bottom = m - 1;

        while (top <= bottom && left <= right && head != null) {
            for (int i = left; i <= right; i++) {
                if (head == null) return result;
                result[top][i] = head.val;
                head = head.next;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                if (head == null) return result;
                result[i][right] = head.val;
                head = head.next;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    if (head == null) return result;
                    result[bottom][i] = head.val;
                    head = head.next;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    if (head == null) return result;
                    result[i][left] = head.val;
                    head = head.next;
                }
                left++;
            }
        }
        return result;
    }
}