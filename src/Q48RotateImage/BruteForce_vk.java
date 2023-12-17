package Q48RotateImage;
// 48. Rotate Image
// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
//
//You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
// Example 1:
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//        Output: [[7,4,1],[8,5,2],[9,6,3]]

// Time complexity: O(n^2)
// Space complexity: O(n^2)
public class BruteForce_vk {
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int[][] ans = new int[n][n];
            for(int r = 0; r < matrix.length; r++){
                for(int c = 0; c < matrix.length; c++){
                    ans[c][n-1-r] = matrix[r][c];
                }
            }

            for(int r = 0; r < matrix.length; r++){
                for(int c = 0; c < matrix.length; c++){
                    matrix[r][c] = ans[r][c];
                }
            }
        }
    }
}
