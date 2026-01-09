package com.dsa.showcase.year2025.recursion.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*212. Word Search II
        Solved
Hard
        Topics
conpanies icon
Companies
        Hint
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.



Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []


Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
        1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.*/
public class WordSearch2 {
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        WordSearch2 solution = new WordSearch2();
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> foundWords = solution.findWords(board, words);
        System.out.println("Found words: " + foundWords); // Output: ["eat", "oath"]
    }

    //TLE
    //TODO: Optimize this solution using Trie or Aho-Corasick algorithm
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        if (board == null || board.length == 0 || words == null) {
            return new ArrayList<>();
        }
        int m = board.length;
        int n = board[0].length;
        for (String word : words) {
            if (!hasEnoughLetters(board, word) || set.contains(word)) continue;
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (backtrack(board, i, j, word, 0, visited)) {
                        set.add(word);
                    }
                }
            }
        }
        return new ArrayList(set);
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