package Q73SetMatrixZeroes;

// 73. Set Matrix Zeroes
// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
// You must do it in place.

// Example 1:
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]

// time complexity: O(r*c)
// space complexity: O(r+c)
public class Solution {

    public static void setZeroes(int[][] matrix) {
        boolean[] setRows = new boolean[matrix.length];
        boolean[] setColumns = new boolean[matrix[0].length];

        // record the rows and cols to be set to zero
        for (int r = 0; r < setRows.length; r++) {
            for (int c = 0; c < setColumns.length; c++) {
                if (matrix[r][c] == 0) {
                    setRows[r] = true;
                    setColumns[c] = true;
                }
            }
        }

        // set rows and cols to zero
        for (int r = 0; r < setRows.length; r++) {
            for (int c = 0; c < setColumns.length; c++) {
                if (setRows[r] || setColumns[c]) {
                    matrix[r][c] = 0;
                }
            }
        }
    }

}
