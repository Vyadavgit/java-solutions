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


// TIMR AND SPACE COMPLEXITY:
// The time complexity of the exist function in the provided code is O(M * N * 4^L), where M is the number of rows in the board, N is the number of columns in the board, and L is the length of the word. This is because for each cell in the board, the function performs a recursive search in four directions (up, down, left, right) for a maximum depth of L (length of the word). Since each recursive call explores four possible directions, the total number of recursive calls is 4^L. Therefore, the overall time complexity is O(M * N * 4^L).

// The space complexity of the exist function is O(L), where L is the length of the word. This is because the function uses a boolean matrix visited of size M * N to keep track of visited cells, which requires O(M * N) space. Additionally, the function uses a string newString to store the current path being explored, which can have a maximum length of L. Therefore, the overall space complexity is O(L).

// this solution is not an optimized approach as it explores all paths
public class Bruteforce_Solution {
    public static void main(String[] args) {
        char[][] board = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board, "SEE"));
    }

    public static boolean exist(char[][] board, String word) {
        boolean exist = false;
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                exist = exist || recursion(board, word, r, c, "", false, new boolean[board.length][board[0].length]);
                if (exist) return true;
            }
        }
        return exist;
    }

    private static boolean recursion(char[][] board, String word, int r, int c, String newString, boolean found, boolean[][] visited){
        if ((r >= 0 && r < board.length) && (c >= 0 && c < board[0].length) && !found) {
            newString = newString + String.valueOf(board[r][c]); 
            visited[r][c] = true;
            
            if (newString.length() == word.length() && newString.equals(word)) {
                return true;
            } else if (newString.length() >= word.length()) {  
                return found;
            } else{
                if(c < board[0].length - 1 && !visited[r][c+1]){
                    found = found || recursion(board, word, r, c+1, newString, found, visited); // Right
                    visited[r][c+1] = false;
                }

                if (c > 0 && !visited[r][c-1]) {
                    found = found || recursion(board, word, r, c-1, newString, found, visited); // Left     
                    visited[r][c-1] = false;               
                }   

                if (r < board.length - 1 && !visited[r+1][c]) {
                    found = found || recursion(board, word, r+1, c, newString, found, visited); // Down
                    visited[r+1][c] = false;
                }

                if (r > 0 && !visited[r-1][c]) {
                    found = found || recursion(board, word, r-1, c, newString, found, visited); // up    
                    visited[r-1][c] = false;                
                }
            }

            visited[r][c] = false;
        }
        return found;
    }
}
