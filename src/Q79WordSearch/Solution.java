package Q79WordSearch;

// 79. Word Search

// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

// Example 1:
// Input board:
//     A B C E
//     S F C S 
//     A D E E 

// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true

// DFS and Back tracking technique

// TIME AND SPACE COMPLEXITY
// The time complexity of the exist method is O(M * N * 4^L), where M is the number of rows in the board, N is the number of columns in the board, and L is the length of the word.
// Space completely is O(M * N)
public class Solution {
    public static void main(String[] args) {
        char[][] board = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board, "SEE"));
    }

    public static boolean exist(char[][] board, String word) {
        boolean visited[][] = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)
                        && search(board, word, i, j, 0, new boolean[board.length][board[0].length])) {
                    return true;
                }
            }
        }
        return false;
    }

    // dfs
    public static boolean search(char[][] board, String word, int i, int j, int idx, boolean[][] visited) {
        if (idx == word.length()) {
            return true;
        }

        if (i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!=word.charAt(idx) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        // dfs
        if (search(board, word, i + 1, j, idx + 1, visited) || // down
                search(board, word, i, j + 1, idx + 1, visited) || // right
                search(board, word, i - 1, j, idx + 1, visited) || // up
                search(board, word, i, j - 1, idx + 1, visited) // left
        ) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
