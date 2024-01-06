package Q54SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

// Q54. Spiral Matrix
// Given an m x n matrix, return all elements of the matrix in spiral order.
// Example 1:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//         Output: [1,2,3,6,9,8,7,4,5]
// Time Complexity: O(m * n) , where m = rows, n = cols
// Space Complexity: O(m + n) , where m = rows, n = cols
public class Solution {

    public static void main(String[] args) {
        int [][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(traverse(arr,0, 0, new ArrayList<>()));

        arr = new int[][]{{1}};
        System.out.println(traverse(arr,0, 0, new ArrayList<>()));

        arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(traverse(arr,0, 0, new ArrayList<>()));
    }

    static List<Integer> traverse(int[][] arr, int i, int j, List<Integer> list){
        if(arr[i][j] != Integer.MIN_VALUE){
            list.add(arr[i][j]);
            arr[i][j] = Integer.MIN_VALUE;
        }

        if (j < arr[i].length-1 && arr[i][j+1] != Integer.MIN_VALUE){ // traverse to the right
            traverse(arr,i, j+1, list);
        }else if(i < arr.length-1 && arr[i+1][j] != Integer.MIN_VALUE) { // traverse downwards
            traverse(arr, i+1, j, list);
        }else if(j > 0 && arr[i][j-1] != Integer.MIN_VALUE){ // traverse left
            traverse(arr, i, j-1, list);
        }

        if(i > 0 && arr[i-1][j] != Integer.MIN_VALUE){ // traverse upwards
            while (arr[i-1][j] != Integer.MIN_VALUE){
                i--;
                list.add(arr[i][j]);
                arr[i][j] = Integer.MIN_VALUE;
            }
            traverse(arr, i, j+1, list); // traverse right after completing the spiral
        }

        return list;
    }

}
