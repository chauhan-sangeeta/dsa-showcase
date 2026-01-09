package com.dsa.showcase.year2025.recursion.backtrack;

/*79. Word Search
Solved
        Medium
Topics
companies icon
Companies
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.



        Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false


Constraints:

m == board.length
        n = board[i].length
1 <= m, n <= 6
        1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.


Follow up: Could you use search pruning to make your solution faster with a larger board?*/
public class WordSearch {
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        boolean exists = solution.exist(board, word);
        System.out.println("Does the word exist in the board? " + exists); // Output: false
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word.isEmpty()) {
            return false;
        }
        if (!hasEnoughLetters(board, word))
            return false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Check if the board has enough letters to form the word
    private boolean hasEnoughLetters(char[][] board, String word) {
        int[] freq = new int[256];
        // Count every letter on the board
        for (char[] row : board)
            for (char c : row)
                freq[c - '0']++;
        // “Use up” letters for the word
        for (char c : word.toCharArray()) {
            if (--freq[c - '0'] < 0) {
                // We needed more of this letter than the board has
                return false;
            }
        }
        return true;
    }

    public boolean backtrack(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if (valid(newRow, newCol, board.length, board[0].length) && !visited[newRow][newCol]) {
                if (backtrack(board, newRow, newCol, word, index + 1, visited)) {
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }

    public boolean valid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;

    }
}