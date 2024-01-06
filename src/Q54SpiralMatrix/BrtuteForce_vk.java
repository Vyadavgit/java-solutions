package Q54SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

// incomplete solution
public class BrtuteForce_vk {
    public static void main(String[] args) {
        int[][] matrix  = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        List<Integer> list = new ArrayList<Integer>();
        boolean forward = true;
        boolean downward = true;
        int center = r/2;
        int i = 0, j = 0;

        boolean[][] flags = new boolean[r][c];

        while(!flags[center][center]){
            r = r-1;
            c = c-1;

            if(forward){// runs through columns - forward
                while(j <= c){
                    list.add(matrix[i][j]);
                    flags[i][j] = true;
                    j++;
                }
                j--;
                forward = false;
                i++;
            }else{
                // backwards
                while(j >= c){
                    list.add(matrix[i][j]);
                    flags[i][j] = true;
                    j--;
                }
                j++;
                forward = true;
                i--;
            }

            if(downward){// runs through rows - downward
                while(i <= r){
                    list.add(matrix[i][j]);
                    flags[i][j] = true;
                    i++;
                }
                i--;
                downward = false;
                j--;
            }else{
                // upwards
                while(i >= r){
                    list.add(matrix[i][j]);
                    flags[i][j] = true;
                    i--;
                }
                i++;
                downward = true;
                j++;
            }
        }
        return list;
    }
}
