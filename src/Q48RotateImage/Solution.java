package Q48RotateImage;

import java.util.Arrays;

// 48. Rotate Image
// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
//
//You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
// Example 1:
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//        Output: [[7,4,1],[8,5,2],[9,6,3]]

// Time complexity: O(n^2)
// Space complexity: O(1)
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        for (int[] mat: matrix) {
            for (int e: mat) {
                System.out.print(e + " | ");
            }
            System.out.println();
        }
        System.out.println("\noutput: ");

        int n = matrix.length;
        // Transpose (swap of elements diagonally)
        for(int r = 0; r < n; r++){
            for(int c = r+1; c < n; c++){
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }

        // Reverse rows
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n/2; c++){
                int temp = matrix[r][c];
                matrix[r][c] = matrix[r][n-1-c];
                matrix[r][n-1-c] = temp;
            }
        }

        for (int[] mat: matrix) {
            for (int e: mat) {
                System.out.print(e + " | ");
            }
            System.out.println();
        }
    }
}
