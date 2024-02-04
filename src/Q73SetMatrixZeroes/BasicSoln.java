package Q73SetMatrixZeroes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// You must do it in place.

// Example 1:
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]

// 173 / 176 leetcode testcases passed
// time ccomplexity: O(r*c)
// space complexity: O(r+c) ? 

public class BasicSoln {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{9,8,5,1,8,0,7,3,4,1,2,0},
        {1,4,3,3,8,1,6,9,3,5,7,3},
        {2,5,0,9,5,9,6,4,8,4,7,6},
        {4,5,2,0,8,4,3,1,0,6,4,8},
        {9,0,9,5,7,7,0,9,2,2,0,9},
        {2,7,6,2,1,3,0,7,0,2,7,0},
        {6,0,2,8,9,6,6,0,9,6,7,6},{3,8,8,7,0,8,9,4,7,5,6,0},{0,9,7,3,1,7,3,0,9,7,8,8},{6,7,1,5,3,8,3,8,6,1,7,9},{2,6,3,9,1,2,2,4,1,9,7,4},{8,0,4,8,8,5,8,4,2,9,1,7}};

        // print before transformation
        System.out.println("Before: ");
        Arrays.asList(matrix).forEach(arr -> {
            System.out.println(Arrays.toString(arr));
            });


        setZeroes(matrix);

        // print after transformation
        System.out.println("\nAfter: ");
        Arrays.asList(matrix).forEach(arr -> {
        System.out.println(Arrays.toString(arr));
        });

        // print unmatched e
        int[][] expectedArr = new int[][] {{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,5,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,0,0,9,0,0},{0,0,0,0,0,0,0,0,0,0,0,0}};
        System.out.println("\nExpected: ");
        Arrays.asList(expectedArr).forEach(arr -> {
        System.out.println(Arrays.toString(arr));
        });

        System.out.println("\nExpected with highlighted unmatched elements: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != expectedArr[i][j]) {
                    System.out.print("=");
                } else {
                    System.out.print(matrix[i][j]);
                }
                if (j < matrix.length-1) System.out.print(", ");
            }
            System.out.print("]"+'\n');
        }




    }

    public static void setZeroes(int[][] matrix) {
        Map<String, Integer> memo = new HashMap<>();
        for(int i=0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] == 0 && !memo.containsKey(i+""+j)){
                    setRows(matrix, i, memo);
                    setColumns(matrix, j, memo);
                }
            }
        }
    }

    public static void setRows(int[][] matrix, int r, Map<String, Integer> memo){
        for (int c = 0; c < matrix[r].length; c++){
            if (matrix[r][c] != 0){
                matrix[r][c] = 0;
                memo.put(r+""+c, matrix[r][c]);
            }
        }
    }

    public static void setColumns(int[][] matrix, int c, Map<String, Integer> memo){
        for(int r = 0; r < matrix.length; r++){
            if (matrix[r][c] != 0){
                matrix[r][c] = 0;
                memo.put(r+""+c, matrix[r][c]);
            }
        }
    }
}
