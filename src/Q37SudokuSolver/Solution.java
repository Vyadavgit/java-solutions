package Q37SudokuSolver;
/*
* Q.37. Sudoku Solver
Write a program to solve a Sudoku puzzle by filling the empty cells.
A sudoku solution must satisfy all of the following rules:
Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

Example 1:
Input: board = [
* ["5","3",".",".","7",".",".",".","."],
* ["6",".",".","1","9","5",".",".","."],
* [".","9","8",".",".",".",".","6","."],
* ["8",".",".",".","6",".",".",".","3"],
* ["4",".",".","8",".","3",".",".","1"],
* ["7",".",".",".","2",".",".",".","6"],
* [".","6",".",".",".",".","2","8","."],
* [".",".",".","4","1","9",".",".","5"],
* [".",".",".",".","8",".",".","7","9"]
* ]
Output: [
* ["5","3","4","6","7","8","9","1","2"],
* ["6","7","2","1","9","5","3","4","8"],
* ["1","9","8","3","4","2","5","6","7"],
* ["8","5","9","7","6","1","4","2","3"],
* ["4","2","6","8","5","3","7","9","1"],
* ["7","1","3","9","2","4","8","5","6"],
* ["9","6","1","5","3","7","2","8","4"],
* ["2","8","7","4","1","9","6","3","5"],
* ["3","4","5","2","8","6","1","7","9"]
* ]
 *
 * */
// Time complexity:
// for every cell trying n^2 times
// hence, time complexity = O(9^(n^2))

// Space complexity: O(n^2)

//public class Solution {
//    public static void main(String[] args) {
//        char[][] board = {
//                {'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}};
//        display(board);
//        System.out.println();
//        if(solve(board)){
//            display(board);
//        }else {
//            System.out.println("cannot solve");
//        }
//    }
//
//    public static void display(char[][] board){
//        for(int i = 0; i < board.length; i++){
//            for(int j = 0; j < board.length; j++){
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    public static boolean solve(char[][] board) {
//        int n = board.length;
//        int row = -1;
//        int col = -1;
//
//        boolean emptyLeft = true;
//
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                if(board[i][j] == '.'){
//                    row = i;
//                    col = j;
//                    emptyLeft = false;
//                    break;
//                }
//            }
//
//            // '.' found so break
//            if(emptyLeft == false){
//                break;
//            }
//        }
//
//        if(emptyLeft == true){
//            return true;
//        }
//
//        // fill or backtrack
//        for(int number = 1; number <= 9; number++){
//            char ch = Integer.toString(number).charAt(0);
//            if(isSafe(board, row, col, ch)){
//                board[row][col] = ch;
//                if(solve(board)){
//                    // found the answer
//                    return true;
//                }else {
//                    // backtrack
//                    board[row][col] = '.';
//                }
//            }
//        }
//        return false;
//    }
//
//    public static boolean isSafe(char[][] board, int row, int col, char num){
//        // check the row
//        for(int c = 0; c < board.length; c++){
//            if(board[row][c] == num){
//                return false;
//            }
//        }
//
//        // check the col
//        for(char[] nums: board){
//            if(nums[col] == num){
//                return false;
//            }
//        }
//
//        // now check inside the box
//        int sqrt = (int) Math.sqrt(board.length);
//        int rowStart = row - row % sqrt; // row of the internal box
//        int colStart = col - col % sqrt; // col of the internal box
//        for(int r = rowStart; r < rowStart + sqrt; r++){
//            for(int c = colStart; c < colStart + sqrt; c++){
//                if(board[r][c] == num){
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }
//}


// SUBMITTED ANS
class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }


    public boolean solve(char[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '.'){
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }

            // '.' found so break
            if(emptyLeft == false){
                break;
            }
        }

        if(emptyLeft == true){
            return true;
        }

        // fill or backtrack
        for(int number = 1; number <= 9; number++){
            char ch = Integer.toString(number).charAt(0);
            if(isSafe(board, row, col, ch)){
                board[row][col] = ch;
                if(solve(board)){
                    // found the answer
                    return true;
                }else {
                    // backtrack
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    public boolean isSafe(char[][] board, int row, int col, char num){
        // check the row
        for(int c = 0; c < board.length; c++){
            if(board[row][c] == num){
                return false;
            }
        }

        // check the col
        for(char[] nums: board){
            if(nums[col] == num){
                return false;
            }
        }

        // now check inside the box
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - row % sqrt; // row of the internal box
        int colStart = col - col % sqrt; // col of the internal box
        for(int r = rowStart; r < rowStart + sqrt; r++){
            for(int c = colStart; c < colStart + sqrt; c++){
                if(board[r][c] == num){
                    return false;
                }
            }
        }

        return true;
    }
}
